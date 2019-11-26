package ddocdoc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;

public class HospitalResDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		String hos_res_num = request.getParameter("hos_res_num");
		
		HospitalResVO res = sc.detailRes(hos_res_num);
		String check = sc.checkResAcpt(hos_res_num);
		
		if(check.equals("예약 접수 대기 중")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('예약 접수가 아직 되지 않아 대기번호 발급이 안되었습니다. 접수가 완료될 때 까지 잠시만 기다려주세요.'); location.href='resList.do';</script>");
			return null;
		}else {
			int count = sc.detailWait(hos_res_num);
			request.setAttribute("res", res);
			request.setAttribute("cus_name", ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_name());
			request.setAttribute("count", count);
			
			forward.setPath("/hos_res/resDetail.jsp");
			forward.setRedirect(false);
			
			return forward;
		}
		
		
	}

}
