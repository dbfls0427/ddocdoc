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
public class ConfirmFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		System.out.println("ConfirmAction");
		sc.confirmNumber();
		
		forward.setPath("/confirmForm.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
