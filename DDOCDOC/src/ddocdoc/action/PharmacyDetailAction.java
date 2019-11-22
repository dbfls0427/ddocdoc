package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.PharmacyService;
import ddocdoc.service.PharmacyServiceImpl;
import ddocdoc.vo.PharmacyVO;




public class PharmacyDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PharmacyService service =  PharmacyServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		String phar_num = request.getParameter("seq");
		
		PharmacyVO pharmacyvo = service.pharmacyDetail(phar_num);
		
		request.setAttribute("pharmacyvo", pharmacyvo);
		
		
		forward.setPath("/pharmacy_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

	
	
}

