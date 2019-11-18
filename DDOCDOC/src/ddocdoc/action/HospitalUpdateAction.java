package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;

public class HospitalUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalService service = HospitalServiceImpl.getInstance();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String hos_num = request.getParameter("hos_num");
		
		service.hospitalUpdate(request);
		
		forward.setRedirect(true);
		forward.setPath("/doc/hospital/hospitalDetail.do?seq="+hos_num);
		return forward;
	}

}


