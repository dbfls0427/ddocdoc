package ddocdoc.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildHeightService;
import ddocdoc.service.ChildHeightServiceImpl;

public class HeightAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildHeightService service = ChildHeightServiceImpl.getInstance();
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=UTF-8");
		 
		
		String ch_num = request.getParameter("ch_num");
		String ch_name = request.getParameter("ch_name");
		System.out.println("HeightAction에서 ch_num : " + ch_num);
		System.out.println("HeightAction에서 ch_name : " + ch_name);
		
		service.insertChildHeight(request);
		
		forward.setPath("HeightList.do?ch_num=" + ch_num + "&ch_name=" + ch_name);
		forward.setRedirect(false);
		
		return forward;
	}

}
