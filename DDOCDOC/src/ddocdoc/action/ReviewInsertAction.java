package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ReviewService;
import ddocdoc.service.ReviewServiceImpl;

public class ReviewInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		ReviewService service = ReviewServiceImpl.getInstance();
		System.out.println("Review UpdateAction.java 됨!");
		
		service.reviewInsert(request);
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		forward.setPath("/DDOCDOC/review/reviewList.do");
		forward.setRedirect(true);
		return forward;
	}
  
}
