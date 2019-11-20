package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HospitalResFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		String cusNum = request.getParameter("cus_num");
		String hosName = request.getParameter("hos_name");
		System.out.println("cusNum : " + cusNum + ", hosNum : " + hosName);
		
		request.setAttribute("cus_num", cusNum);
		request.setAttribute("hos_name", hosName);
		
		forward.setPath("/hos_res/hos_res.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
