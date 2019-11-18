package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.HospitalVO;

public class hospitalDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HospitalService service = HospitalServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		
		String hos_num = request.getParameter("seq");
		
	
		HospitalVO hospitalvo = service.hospitalDetail(hos_num);
		request.setAttribute("hospitalvo", hospitalvo);
		
		
		forward.setPath("/hospital.detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
