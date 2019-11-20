package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildService;
import ddocdoc.service.ChildServiceImpl;
import ddocdoc.vo.ChildVO;

public class ChildDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ChildService service = ChildServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		String ch_num = request.getParameter("ch_num");
		ChildVO childVO = service.childDetail(ch_num);
		request.setAttribute("childVO", childVO);
		
		forward.setPath("/child.detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
