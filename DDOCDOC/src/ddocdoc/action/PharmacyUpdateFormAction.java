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
		

		
		
		
		forward.setRedirect(false);
		forward.setPath("/pharmacy_modify.jsp");
		
		
		return forward;
		
	}

}
