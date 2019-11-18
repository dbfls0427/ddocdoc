package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HospitalUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String hos_num = request.getParameter("seq");
		System.out.println(hos_num+"hos_num");
		request.setAttribute("hos_num", hos_num);
		
		forward.setRedirect(false);
		forward.setPath("/hospital.modify.jsp");
		
		return forward;
	}

}
