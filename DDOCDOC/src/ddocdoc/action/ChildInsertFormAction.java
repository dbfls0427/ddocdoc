package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildService;
import ddocdoc.service.ChildServiceImpl;

public class ChildInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		forward.setPath("/child.insert.jsp");
		forward.setRedirect(false);
		
		return forward;
		
	}

}
