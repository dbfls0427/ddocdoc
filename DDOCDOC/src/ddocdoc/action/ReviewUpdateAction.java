package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ReviewService;
import ddocdoc.service.ReviewServiceImpl;

public class ReviewUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReviewService service = ReviewServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("utf-8");
		
		System.out.println("Review UpdateAction.java 됨!");
		
			service.reviewUpdate(request);
			forward.setRedirect(true);
			forward.setPath("/DDOCDOC/review/reviewList.do");
		
		return forward;  
	}

}
