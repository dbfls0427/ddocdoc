package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.PharmacyService;
import ddocdoc.service.PharmacyServiceImpl;
import ddocdoc.vo.PharmacyVO;



public class PharmacyUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PharmacyService service = PharmacyServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		
		String phar_num = request.getParameter("seq");
		System.out.println(phar_num+"phar_num");
		
		PharmacyVO pharmacyvo = service.pharmacyDetail(phar_num);
		request.setAttribute("pharmacyvo", pharmacyvo);
		
//		String phar_name = request.getParameter("phar_name");
//		System.out.println(phar_name+"phar_name");
//		
//		
//		String phar_tel = request.getParameter("phar_tel");
//		System.out.println(phar_tel+"phar_tel");
//		
//		String phar_addr = request.getParameter("phar_addr");
//		System.out.println(phar_addr+"phar_addr");
//		
//		
//		String phar_time = request.getParameter("phar_time");
//		System.out.println(phar_time+"phar_time");
//		
//		
//		String phar_info = request.getParameter("phar_info");
//		System.out.println(phar_info+"phar_info");
//		
//		
//		
//		
//		request.setAttribute("phar_num", phar_num);
//		request.setAttribute("phar_name", phar_name);
//		request.setAttribute("phar_tel", phar_tel);
//		request.setAttribute("phar_addr", phar_addr);
//		request.setAttribute("phar_time", phar_time);
//		request.setAttribute("phar_info", phar_info);
		
		
		
		forward.setRedirect(false);
		forward.setPath("/pharmacy_modify.jsp");
		
		
		return forward;
		
	}

}
