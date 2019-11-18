package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.HospitalVO;

public class HospitalListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalService service = HospitalServiceImpl.getInstance();
		
		List<HospitalVO> list = service.hospitalList();
		request.setAttribute("list", list);
		
		forward.setRedirect(false);
		forward.setPath("/hospital.list.jsp");
		
		return forward;
	}

}
