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
		
		//jsp에서이름받아오기 위해
		String cus_name = request.getParameter("cus_name");
		request.setAttribute("cus_name", cus_name);
		
		String cus_num = request.getParameter("cus_num");
		request.setAttribute("cus_num", cus_num);
		
		forward.setRedirect(true);
		forward.setPath("/DDOCDOC/child/childList.do");
		
		return forward;
	}

}
