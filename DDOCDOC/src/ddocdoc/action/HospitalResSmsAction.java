package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;

public class HospitalResSmsAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		int count = Integer.parseInt(request.getParameter("count"));
		String hos_res_num = request.getParameter("hos_res_num");
		
		sc.hospitalResSms(count);
		
		forward.setPath("detailRes.do?hos_res_num=" + hos_res_num);
		forward.setRedirect(false);
		
		return forward;
	}

}
