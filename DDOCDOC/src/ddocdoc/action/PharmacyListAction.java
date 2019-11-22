package ddocdoc.action;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import ddocdoc.service.PharmacyService;
import ddocdoc.service.PharmacyServiceImpl;
import ddocdoc.vo.PharmacyVO;


public class PharmacyListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		PharmacyService service = PharmacyServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		List<PharmacyVO> list = service.pharmacyList();
		
		request.setAttribute("list", list);
		forward.setPath("/pharmacy_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}









