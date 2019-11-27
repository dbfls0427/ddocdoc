package ddocdoc.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.ConfirmVO;


/**
 * ¿Œ¡ıπ¯»£ πﬂ±ﬁ
 * @author ±Ë¿±≈¬
 *
 */
public class ConfirmRealAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		String confirmNum = request.getParameter("confirm");
		ConfirmVO confirm = sc.getConfirm();
		
		if(confirm.getConfirmNum().equals(confirmNum)) {
			confirm.setCheck(true);
			confirm.setFinalCheck(true);
		}
		
		if(confirm.isCheck()) {
			
			request.setAttribute("confirm", confirm);
			forward.setPath("/confirmForm.jsp");
			forward.setRedirect(false);
			return forward;
		}else {
			request.setAttribute("confirm", confirm);
			forward.setPath("/confirmForm.jsp");
			forward.setRedirect(false);
			return forward;
		}
		
	}

}
