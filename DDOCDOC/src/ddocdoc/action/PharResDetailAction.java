package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.PharResVO;

public class PharResDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		String phar_res_num = request.getParameter("phar_res_num");
		
		PharResVO res = sc.presDetail(phar_res_num);
		String name = sc.selectPharmacyName(request.getParameter("phar_num"));
		String phar_num = res.getPhar_num();
		
		
		request.setAttribute("res", res);
		request.setAttribute("pharName", name);
		request.setAttribute("phar_wait", sc.detailPharWait(phar_num));
		forward.setPath("/phar_res/pharDetail.jsp");
		forward.setRedirect(false);
		
		
		return forward;
	}

}
