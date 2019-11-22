package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.ChildHeightService;
import ddocdoc.service.ChildHeightServiceImpl;
import ddocdoc.vo.CustomerVO;

public class HeightInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildHeightService service = ChildHeightServiceImpl.getInstance();
		
		String ch_num= request.getParameter("ch_num");
		String ch_name= request.getParameter("ch_name");
		System.out.println("insertFormAction에서 ch_num : " +ch_num);
		System.out.println("insertFormAction에서 ch_name : " +ch_name);
		
		//아이키번호 가져오기
		//String he_num = service.selectHeNum(ch_num);
		request.setAttribute("ch_name", ch_name);
		forward.setPath("/heightInsertForm.jsp?ch_num="+ch_num + "&ch_name="+ch_name);
		forward.setRedirect(false);
		
		return forward;
	}

}
