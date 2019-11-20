package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildService;
import ddocdoc.service.ChildServiceImpl;
import ddocdoc.vo.ChildVO;

public class ChildListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildService service = ChildServiceImpl.getInstance();
		
		List<ChildVO> list = service.childList();
		request.setAttribute("childList", list);
		
		forward.setRedirect(false);
		forward.setPath("/child.list.jsp");
		
		return forward;
	}

}
