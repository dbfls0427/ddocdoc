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
		
		String cus_num = request.getParameter("cus_num");
		String ch_num= service.selectChildNum(cus_num);
		
		request.setAttribute("ch_num", ch_num);
		
		service.insertChildHeight(request);
		
		forward.setPath("HeightList.do?ch_num=" + ch_num);
		forward.setRedirect(false);
		
		return forward;
	}

}
