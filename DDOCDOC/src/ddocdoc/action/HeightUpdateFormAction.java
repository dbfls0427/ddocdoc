package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeightUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String he_num = request.getParameter("he_num");
		
		request.setAttribute("he_num", he_num);
		
		forward.setPath("/heightUpdateForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
