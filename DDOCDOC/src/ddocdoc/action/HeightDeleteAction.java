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
		String ch_name = request.getParameter("ch_name");
		forward.setPath("HeightList.do?ch_num="+ch_num + "&ch_name=" + ch_name);
		forward.setRedirect(false);
		
		return forward;
	}

}
