package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;

public class LogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		LoginSession.loginSession.removeAttribute("customer");
		
		if(LoginSession.loginSession.getAttribute("customer") == null) {
			System.out.println("로그아웃 성공");
		}
		
		forward.setPath("/loginForm.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
