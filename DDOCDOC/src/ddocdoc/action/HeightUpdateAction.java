package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildHeightService;
import ddocdoc.service.ChildHeightServiceImpl;

public class HeightUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildHeightService service= ChildHeightServiceImpl.getInstance();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		 
		String he_num = request.getParameter("he_num");
		String ch_num = request.getParameter("ch_num");
		String ch_name = request.getParameter("ch_name");
		
		System.out.println("updateAction : " +he_num);
		System.out.println("updateAction에서 ch_num : " +ch_num);
		System.out.println("updateAction에서 ch_name : " +ch_name);
		
		service.updateChildHeight(request);
		
		forward.setPath("HeightList.do?ch_num=" + ch_num + "&ch_name=" + ch_name);
		forward.setRedirect(false);
		
		return forward;
	}

}
