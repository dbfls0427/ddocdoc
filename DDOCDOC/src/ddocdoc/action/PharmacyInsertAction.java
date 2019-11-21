package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.PharmacyService;
import ddocdoc.service.PharmacyServiceImpl;


public class PharmacyInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		PharmacyService service = PharmacyServiceImpl.getInstance();
		System.out.println("UpdateAction.java 됨!");
		
		
		service.pharmacyInsert(request);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		forward.setPath("/DDOCDOC/pharmacy/pharmacyList.do");
		forward.setRedirect(true);
		return forward;
	}

}
