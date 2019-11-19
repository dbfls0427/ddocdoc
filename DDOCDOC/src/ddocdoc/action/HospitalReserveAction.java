package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalReserveService;
import ddocdoc.service.hospitalReserveServiceImpl;
import ddocdoc.vo.HospitalReserveVO;

public class HospitalReserveAction implements Action{

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalReserveService service = hospitalReserveServiceImpl.getInstance();
		
		HospitalReserveVO hvo = new HospitalReserveVO();
		
		return forward;
		
	}

}
