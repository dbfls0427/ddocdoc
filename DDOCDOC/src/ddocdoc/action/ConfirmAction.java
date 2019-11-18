package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;


/**
 * ������ȣ �߱�
 * @author ������
 *
 */
public class ConfirmAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		System.out.println("ConfirmAction");
		String result = sc.confirmNumber();
		
		System.out.println(result);
		forward.setPath("/joinForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
