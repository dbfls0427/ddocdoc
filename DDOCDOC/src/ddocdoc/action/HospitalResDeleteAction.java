package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;

public class HospitalResDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		String hos_res_num = request.getParameter("hos_res_num");
		String hos_num = request.getParameter("hos_num");
		
		
		int decreaseRe = sc.decreaseWait(hos_num);
		int re = sc.deleteRes(hos_res_num);
		
		
		
		forward.setPath("resList.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
