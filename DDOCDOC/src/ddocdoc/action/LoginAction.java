package ddocdoc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalVO;

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
			
			if(customer.getCus_id().equals("admin") && customer.getCus_pw().equals("123")) {
				System.out.println("admin모드입니다.");
				request.setAttribute("customer", (CustomerVO)LoginSession.loginSession.getAttribute("customer"));
				forward.setPath("adminModeAction.do");
				forward.setRedirect(true);
				return forward;
			}
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('아이디와 비밀번호가 틀립니다.'); location.href='loginForm.do';</script>");
			return null;
		}
		
		return forward;
		
		
	}

}
