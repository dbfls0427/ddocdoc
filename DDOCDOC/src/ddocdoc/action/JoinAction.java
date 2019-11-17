package ddocdoc.action;

import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");

		
		CustomerVO customer = new CustomerVO();
		customer.setCus_id(request.getParameter("joinID"));
		customer.setCus_pw(request.getParameter("joinPW"));
		customer.setCus_name(request.getParameter("joinName"));
		customer.setCus_addr(request.getParameter("joinAddr"));
		customer.setCus_email(request.getParameter("joinEmail"));
//		customer.setCus_birth((Date)request.getParameter("joinBirth"));
		
		int re = sc.insertCustomer(customer);
		
		forward.setPath("/loginForm.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
