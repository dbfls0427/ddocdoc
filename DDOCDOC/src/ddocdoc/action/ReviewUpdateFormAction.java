package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.ReviewVO;

public class ReviewUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		CustomerService service = CustomerServiceImpl.getInstance();
		String rv_num = request.getParameter("seq");
		
		ReviewVO reviewvo = service.reviewDetail(rv_num);
		request.setAttribute("reviewvo", reviewvo);
		
		forward.setRedirect(false);
		forward.setPath("/review/review_modify.jsp");
		return forward;
	}

}
