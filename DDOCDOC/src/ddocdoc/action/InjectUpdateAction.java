package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.InjectService;
import ddocdoc.service.InjectServiceImpl;

public class InjectUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		InjectService service = InjectServiceImpl.getInstance();
		
		request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		 
		service.updateInj(request);
		
		String ch_num = request.getParameter("ch_num");
		forward.setPath("InjectListAction.do?ch_num="+ch_num);
		forward.setRedirect(false);
		
		return forward;
	}

}
