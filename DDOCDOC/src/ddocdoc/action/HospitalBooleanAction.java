package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.HosResVO;

public class HospitalBooleanAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HospitalService service = HospitalServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		// 병원 예약 접수
		String hos_res_num = request.getParameter("hos_res_num");
		int hosResvo = service.booleanHosRes(request);
				
		request.setAttribute("boolean", hosResvo);
		System.out.println("hos_res_num"+hos_res_num);
		
		
		
		
		forward.setPath("/hospitalBooleanList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
