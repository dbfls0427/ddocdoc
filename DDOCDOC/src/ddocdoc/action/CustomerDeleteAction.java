package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;

public class CustomerDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		String cus_num = request.getParameter("cus_num");
		
		sc.customerDelete(cus_num);
		
		forward.setPath("/loginForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
