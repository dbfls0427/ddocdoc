package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.PharmacyService;
import ddocdoc.service.PharmacyServiceImpl;
import ddocdoc.vo.PharmacyVO;
//import ddocdoc.vo.PharmacyVO;

public class PharmacyUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PharmacyService service = PharmacyServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		
		request.setCharacterEncoding("utf-8");
	
		System.out.println("UpdateAction.java 됨!");
			
		  service.pharmacyUpdate(request);
		  forward.setRedirect(true);
		 // forward.setPath("/DDOCDOC/pharmacy/pharmacyDetail.do?seq="+phar_num); 
		 forward.setPath("/DDOCDOC/pharmacy/pharmacyList.do");
			
			
		return forward;
	}

}




