package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;

public class AdminRes implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");

		String cus_num = request.getParameter("cus_num");
		String hos_name = request.getParameter("hos_name");
		
		CustomerVO cus = sc.customerDetail(cus_num);
		
		request.setAttribute("cus", cus);
		request.setAttribute("hos_name", hos_name);
		
		forward.setPath("/hos_res/QrRes.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
