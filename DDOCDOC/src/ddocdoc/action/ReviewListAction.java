package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ReviewService;
import ddocdoc.service.ReviewServiceImpl;
import ddocdoc.vo.ReviewVO;

public class ReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ReviewService service = ReviewServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		List<ReviewVO> list = service.reviewList();
		
		request.setAttribute("list", list);
		forward.setPath("/review_list.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}  

}
