package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MapAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String cus_num = request.getParameter("cus_num");
		
		System.out.println("mapAction : " + cus_num);
		request.setAttribute("cus_num", cus_num);
		forward.setPath("/map/hosSearch.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
