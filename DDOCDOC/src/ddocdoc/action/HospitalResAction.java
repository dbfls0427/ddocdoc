package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.CustomerService;
import ddocdoc.service.CustomerServiceImpl;
import ddocdoc.vo.HospitalResVO;

public class HospitalResAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		CustomerService sc = CustomerServiceImpl.getInstance();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		
		String hos_name = request.getParameter("hos_name");
		String cus_num = request.getParameter("cus_num");
		
		System.out.println("HospitalResAction ¿¡¼­ " + hos_name);
		
		String hos_num = sc.selectHosNum(hos_name);
		
		HospitalResVO res = new HospitalResVO();
		res.setHos_res_type(request.getParameter("res_type"));
		res.setHos_res_sym(request.getParameter("res_sym"));
		res.setHos_res_memo(request.getParameter("res_memo"));
		res.setHos_res_date(request.getParameter("res_date"));
		System.out.println(request.getParameter("res_date"));
		res.setHos_res_time(request.getParameter("res_time"));
		res.setCus_num(cus_num);
		res.setHos_num(hos_num);
		
		int re = sc.insertHospitalRes(res);
		
		
		forward.setPath("/loginSuccess.jsp");
		forward.setRedirect(false);
		
		
		
		
		
		return forward;
	}

}
