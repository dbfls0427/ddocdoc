package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;

public class CustomerUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		String cus_num = request.getParameter("cus_num");
		CustomerVO cus = new CustomerVO();
		cus.setCus_num(cus_num);
		cus.setCus_pw(request.getParameter("cus_pw"));
		System.out.println(request.getParameter("cus_pw") + request.getParameter("cus_name") + request.getParameter("cus_addr") + request.getParameter("cus_email"));
		cus.setCus_name(request.getParameter("cus_name"));
		cus.setCus_addr(request.getParameter("cus_addr"));
		cus.setCus_email(request.getParameter("cus_email"));
		
		sc.customerUpdate(cus);
		((CustomerVO)LoginSession.loginSession.getAttribute("customer")).setCus_pw(request.getParameter("cus_pw"));
		((CustomerVO)LoginSession.loginSession.getAttribute("customer")).setCus_name(request.getParameter("cus_name"));
		((CustomerVO)LoginSession.loginSession.getAttribute("customer")).setCus_addr(request.getParameter("cus_addr"));
		((CustomerVO)LoginSession.loginSession.getAttribute("customer")).setCus_email(request.getParameter("cus_email"));
		
		forward.setPath("/loginSuccess.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
