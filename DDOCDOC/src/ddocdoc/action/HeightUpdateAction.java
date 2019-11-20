package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildHeightService;
import ddocdoc.service.ChildHeightServiceImpl;

public class HeightUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildHeightService service= ChildHeightServiceImpl.getInstance();
		String he_num = request.getParameter("he_num");
		System.out.println("updateAction : " +he_num);
		
		service.updateChildHeight(request);
		
		forward.setPath("detailHeight.do?he_num=" + he_num);
		forward.setRedirect(true);
		
		return forward;
	}

}
