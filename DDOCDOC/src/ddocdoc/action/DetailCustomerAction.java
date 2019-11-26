package ddocdoc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class DetailCustomerAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		if(LoginSession.loginSession == null || LoginSession.loginSession.getAttribute("customer") == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 필요합니다.'); location.href='../Customer/loginForm.do';</script>");
			return null;
		}else {
			request.setAttribute("customer", (CustomerVO)LoginSession.loginSession.getAttribute("customer"));
			
			forward.setPath("/detailCustomer.jsp");
			forward.setRedirect(false);
			
			return forward;
		}	
		
	}

}
