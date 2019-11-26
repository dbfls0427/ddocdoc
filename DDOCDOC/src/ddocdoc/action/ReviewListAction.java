package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.ReviewVO;

public class ReviewListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		ActionForward forward = new ActionForward();
		CustomerService service = CustomerServiceImpl.getInstance();
		String cus_num = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num();
		List<ReviewVO> list = service.reviewList(cus_num);
		
		request.setAttribute("list", list);
		forward.setPath("/review/review_list.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}  

}
