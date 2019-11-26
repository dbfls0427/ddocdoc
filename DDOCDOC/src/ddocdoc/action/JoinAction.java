package ddocdoc.action;

import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.CustomerVO;

public class JoinAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		 request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		 
		 if(sc.getConfirm()==null) {
			 response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('인증번호 인증이 안되었습니다. 본인인증을 진행해주세요.'); location.href='join.do';</script>");
				return null;
		 }else if(sc.getConfirm().isFinalCheck()){
			 CustomerVO customer = new CustomerVO();
				customer.setCus_id(request.getParameter("joinID"));
				customer.setCus_pw(request.getParameter("joinPW"));
				customer.setCus_name(request.getParameter("joinName"));
				customer.setCus_addr(request.getParameter("joinAddr"));
				customer.setCus_email(request.getParameter("joinEmail"));
				
				int re = sc.insertCustomer(customer);
				forward.setPath("loginForm.do");
				forward.setRedirect(true);
				
				
				return forward;
		 }
		 
		 return forward;
		
		
		
		
	}

}
