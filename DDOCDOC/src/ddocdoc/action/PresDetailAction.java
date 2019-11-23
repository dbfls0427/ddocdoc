package ddocdoc.action;

import java.io.PrintWriter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

public class PresDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		String hos_res_num = request.getParameter("hos_res_num");
		String hos_num = request.getParameter("hos_num");
		
		PresVO pres = sc.presRealDetail(hos_res_num);
		String pres_num = pres.getPres_num();
		List<PresDetailVO> list = sc.cusPresDetailList(pres_num);
		List<String> list2 = sc.cusPresDetailMedName(pres_num);
		String check = sc.selectPayCheck(pres_num);
		int price = sc.selectPayPrice(hos_res_num);
		
		HospitalVO hos = sc.detailHospital(hos_num);
		String hos_name = hos.getHos_name();
		
		
		
		
		if(pres != null) {
			request.setAttribute("pres", pres);
			request.setAttribute("cus_name", ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_name());
			request.setAttribute("hos_name", hos_name);
			request.setAttribute("list", list);
			request.setAttribute("list2", list2);
			request.setAttribute("check", check);
			request.setAttribute("price", price);
			forward.setPath("/pres/presDetail.jsp");
			forward.setRedirect(false);
			return forward;
		}else {
			response.setCharacterEncoding("EUC-KR");
		     PrintWriter writer = response.getWriter();
		     writer.println("<script type='text/javascript'>");
		     writer.println("alert('처방전이 등록되지 않았습니다. 진료 현황을 확인해주세요.');location.href='resList.do';");
		     writer.println("</script>");
		     writer.flush();
			return null;
		}
		
	}

}
