package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class HeightInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String cus_num = request.getParameter("cus_num");
		System.out.println("insertFormAction : " +cus_num);
		
		forward.setPath("/heightInsertForm.jsp?cus_num="+cus_num);
		forward.setRedirect(false);
		
		return forward;
	}

}
