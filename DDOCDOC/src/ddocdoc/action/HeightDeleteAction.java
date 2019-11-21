package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildHeightService;
import ddocdoc.service.ChildHeightServiceImpl;

public class HeightDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildHeightService service = ChildHeightServiceImpl.getInstance();
		
		service.deleteChildHeight(request);
		
		String ch_num = request.getParameter("ch_num");
		forward.setPath("HeightList.do?ch_num="+ch_num);
		forward.setRedirect(false);
		
		return forward;
	}

}
