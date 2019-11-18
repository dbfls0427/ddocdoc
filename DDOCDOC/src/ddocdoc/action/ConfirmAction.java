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
		
		String result = sc.confirmNumber();
		
		System.out.println(result);
		forward.setPath("join.do");
		forward.setRedirect(false);
		
		return forward;
	}

}
