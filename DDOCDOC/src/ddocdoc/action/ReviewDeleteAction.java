package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ReviewService;
import ddocdoc.service.ReviewServiceImpl;

public class ReviewDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReviewService service = ReviewServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		String rv_num = request.getParameter("seq");
		service.reviewDelete(rv_num);
		
		forward.setPath("/DDOCDOC/review/reviewList.do");
		forward.setRedirect(true);
		
		return forward;
	}  

}
