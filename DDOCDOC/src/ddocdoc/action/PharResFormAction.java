package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class PharResFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String cusNum = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num();
		String hosName = request.getParameter("hos_name");
		System.out.println("cusNum : " + cusNum + ", hosName : " + hosName);
		
		request.setAttribute("cus_num", cusNum);
		request.setAttribute("hos_name", hosName);
		
		forward.setPath("/phar_res/pharResForm.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
