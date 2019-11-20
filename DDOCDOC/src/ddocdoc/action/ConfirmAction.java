package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;

public class ConfirmAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		String confirm = request.getParameter("confirm");
		
		if(CustomerServiceImpl.confirm.getConfirmNum().equals(confirm)) {
			CustomerServiceImpl.confirm.setCheck(true);
		}
		
		if(CustomerServiceImpl.confirm.isCheck()) {
			System.out.println("confirm 성공");
			request.setAttribute("confirm", CustomerServiceImpl.confirm);
			forward.setPath("/confirmForm.jsp");
			forward.setRedirect(false);
		}else{
			System.out.println("confirm 실패");
			request.setAttribute("confirm", CustomerServiceImpl.confirm);
			forward.setPath("/confirmForm.jsp");
			forward.setRedirect(false);
		}
		
		
		return forward;
	}

}
