package ddocdoc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class HospitalResFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String cusNum = request.getParameter("cus_num");
		String hosName = request.getParameter("hos_name");
		
		
		if(LoginSession.loginSession == null || LoginSession.loginSession.getAttribute("customer") == null) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('로그인이 필요합니다.'); location.href='loginForm.do';</script>");
			return null;
		}else {
			request.setAttribute("cus_num", cusNum);
			request.setAttribute("hos_name", hosName);
			
			forward.setPath("/hos_res/hos_res.jsp");
			forward.setRedirect(false);
			
			
			return forward;
		}
		
		
	}

}
