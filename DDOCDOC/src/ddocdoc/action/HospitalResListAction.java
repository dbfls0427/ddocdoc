package ddocdoc.action;



import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.HospitalVO;

public class HospitalResListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalService sc = HospitalServiceImpl.getInstance();
		
		List<HospitalVO> list = sc.hospitalList();
		
		request.setAttribute("list", list);
		
		forward.setPath("/hos_res/hos_res_list.jsp");
		forward.setRedirect(true);
		
		return forward;
	}

}
