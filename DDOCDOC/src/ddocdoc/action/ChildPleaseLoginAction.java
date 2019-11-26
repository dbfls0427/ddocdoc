package ddocdoc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class ChildPleaseLoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		
		if(LoginSession.loginSession == null || LoginSession.loginSession.getAttribute("customer") == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 필요합니다.'); location.href='../Customer/loginForm.do';</script>");
			return null;
		}else {
			String cus_name = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_name();
			request.setAttribute("cus_name", cus_name);
			
			forward.setPath("/child.index.jsp?cus_name=" + cus_name);
			forward.setRedirect(false);
			
			
			return forward;
		}
		
	}

}
