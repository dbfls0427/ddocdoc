package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildService;
import ddocdoc.service.ChildServiceImpl;

public class ChildDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildService service = ChildServiceImpl.getInstance();
		
		String ch_num = request.getParameter("ch_num");
		service.deleteChild(ch_num);
		
		forward.setPath("/DDOCDOC/child/childList.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
