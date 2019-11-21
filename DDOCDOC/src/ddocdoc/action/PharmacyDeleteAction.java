package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.PharmacyService;
import ddocdoc.service.PharmacyServiceImpl;


public class PharmacyDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PharmacyService service = PharmacyServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		String phar_num = request.getParameter("seq");
		service.pharmacyDelete(phar_num);
		
		forward.setPath("/DDOCDOC/pharmacy/pharmacyList.do");
		forward.setRedirect(true);
		
		return forward;
	}
}
