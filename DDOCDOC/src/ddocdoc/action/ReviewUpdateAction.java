package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;

public class ReviewUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		CustomerService service = CustomerServiceImpl.getInstance();
		request.setCharacterEncoding("utf-8");
		
		
			service.reviewUpdate(request);
			forward.setRedirect(true);
			forward.setPath("reviewList.do");
		
		return forward;  
	}

}
