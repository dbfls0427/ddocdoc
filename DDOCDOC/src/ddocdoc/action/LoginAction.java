package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;

public class LoginAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		System.out.println("여기까지 옴");
		CustomerVO customer = sc.loginCustomer(request);
		
		
		if(customer != null && LoginSession.loginSession.getAttribute("customer") != null) {
			System.out.println(((CustomerVO) LoginSession.loginSession.getAttribute("customer")).getCus_id() + " " + ((CustomerVO) LoginSession.loginSession.getAttribute("customer")).getCus_pw() + " " + ((CustomerVO) LoginSession.loginSession.getAttribute("customer")).getCus_name() + " " + ((CustomerVO) LoginSession.loginSession.getAttribute("customer")).getCus_email());
			request.setAttribute("customer", (CustomerVO)LoginSession.loginSession.getAttribute("customer"));
			forward.setPath("/loginSuccess.jsp");
			forward.setRedirect(false);
		}else{
			forward.setPath("/loginForm.jsp");
			System.out.println("로그인 실패");
			forward.setRedirect(false);
		}
		
		
		return forward;
	}

}
