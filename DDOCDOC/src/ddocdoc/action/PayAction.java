package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.PayVO;

public class PayAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		
		
		String pres_num = request.getParameter("pres_num");
		String cus_num = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num();
		String pay_type = request.getParameter("pay_type");
		
				
		PayVO pay = new PayVO();
		pay.setCus_num(cus_num);
		pay.setPay_type(pay_type);
		pay.setPres_num(pres_num);
		
		sc.insertPay(pay);
		sc.updatePay(pres_num);

		forward.setPath("resList.do");
		forward.setRedirect(true);
		
		return forward;
	}

}
