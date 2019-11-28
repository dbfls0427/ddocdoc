package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ReviewService;
import ddocdoc.service.ReviewServiceImpl;
import ddocdoc.vo.ReviewVO;

public class ReviewDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReviewService service = ReviewServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		String rv_num = request.getParameter("seq");
		
		ReviewVO reviewvo = service.reviewDetail(rv_num);
		
		request.setAttribute("reviewvo", reviewvo);
		
		forward.setPath("/review_detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}  

}
