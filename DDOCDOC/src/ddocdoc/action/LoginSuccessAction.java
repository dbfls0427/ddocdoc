package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class LoginSuccessAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerVO customer = ((CustomerVO)LoginSession.loginSession.getAttribute("customer"));
		
		
		if(customer != null) {
			request.setAttribute("customer", customer);
			forward.setPath("/loginSuccess.jsp");
			forward.setRedirect(false);
			return forward;
		}else {
			forward.setPath("/index.html");
			forward.setRedirect(false);
			return forward;
		}
		
		
	}

}
