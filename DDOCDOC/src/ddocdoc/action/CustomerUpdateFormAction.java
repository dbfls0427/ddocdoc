package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;

public class CustomerUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String cus_num = request.getParameter("cus_num");
		String cus_id = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_id();
		
		
		request.setAttribute("cus_num", cus_num);
		request.setAttribute("cus_id", cus_id);
		
		forward.setPath("/myPage/myPageUpdateForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
