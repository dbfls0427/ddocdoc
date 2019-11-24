package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.PharResVO;

public class PharResAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String phar_name = request.getParameter("phar_name");
		String cus_num = request.getParameter("cus_num");
		
		System.out.println("PharResAction ���� " + phar_name);
		
		String phar_num = sc.selectPharNum(phar_name);
		
		PharResVO pvo = new PharResVO();
		pvo.setCus_num(request.getParameter("cus_num"));
		pvo.setPhar_num(phar_num);
		pvo.setPhar_res_memo(request.getParameter("phar_res_memo"));
		pvo.setPhar_res_time(request.getParameter("phar_res_time"));
		pvo.setPhar_wait(0);
		
		int re = sc.insertPharRes(pvo);
		List<HospitalResVO> list = sc.resList(cus_num);
		List<PharResVO> pharList = sc.pharResList(cus_num);
		List<String> pharNameList =sc.detailNamePharmacy(cus_num);
		
		request.setAttribute("list", list);
		request.setAttribute("pharList", pharList);
		request.setAttribute("pharNameList", pharNameList);
		
		forward.setPath("resList.do");
		forward.setRedirect(false);
		
		
		
		
		
		return forward;
	}

}
