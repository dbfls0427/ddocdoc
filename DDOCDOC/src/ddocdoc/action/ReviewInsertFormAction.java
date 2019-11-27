package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class ReviewInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		request.setAttribute("customer", (CustomerVO)LoginSession.loginSession.getAttribute("customer"));
		request.setAttribute("cus_name", ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_name());
		forward.setRedirect(false);
		forward.setPath("/review/review_insert.jsp");
		
		return forward;
	}
  
}
