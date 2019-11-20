package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildService;
import ddocdoc.service.ChildServiceImpl;

public class ChildInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildService service = ChildServiceImpl.getInstance();
		
		service.insertChild(request);
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		
		forward.setRedirect(true);
		forward.setPath("/DDOCDOC/child/childList.do");
		
		return forward;
	}

}
