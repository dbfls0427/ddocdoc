package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class DetailCustomerAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		request.setAttribute("customer", (CustomerVO)LoginSession.loginSession.getAttribute("customer"));
		
		forward.setPath("/detailCustomer.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
