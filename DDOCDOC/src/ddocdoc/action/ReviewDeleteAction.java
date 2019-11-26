package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;

public class ReviewDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		CustomerService service = CustomerServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		String rv_num = request.getParameter("seq");
		service.reviewDelete(rv_num);
		
		forward.setPath("reviewList.do");
		forward.setRedirect(true);
		
		return forward;
	}  

}
