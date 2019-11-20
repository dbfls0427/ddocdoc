package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildHeightService;
import ddocdoc.service.ChildHeightServiceImpl;
import ddocdoc.vo.ChildHeightVO;

public class HeightDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildHeightService service = ChildHeightServiceImpl.getInstance();
		ChildHeightVO chvo = new ChildHeightVO();
		
		chvo = service.detailChildHeight(request);
		
		request.setAttribute("height", chvo);
		
		forward.setPath("/heightDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
