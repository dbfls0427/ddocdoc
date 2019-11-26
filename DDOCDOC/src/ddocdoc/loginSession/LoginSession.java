package ddocdoc.loginSession;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalVO;

public class LoginSession {

	public static HttpSession loginSession = null;
	private static CustomerVO customer = null;
	
	public void sessionInsert(HttpServletRequest request, CustomerVO cus) {
		loginSession = request.getSession();
		customer = cus;
		loginSession.setAttribute("customer", customer);
	}
	
}
