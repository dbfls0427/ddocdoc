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
		
		String cus_num = request.getParameter("cus_num");
		System.out.println("insertFormAction : " +cus_num);
		
		String ch_num = service.selectChildNum(cus_num);
		
		if(ch_num != null) {
			forward.setPath("HeightList.do?ch_num="+ch_num);
			forward.setRedirect(true);
		}else {
			forward.setPath("/heightInsertForm.jsp?cus_num="+cus_num);
			forward.setRedirect(false);
		}
		
		
		return forward;
	}

}
