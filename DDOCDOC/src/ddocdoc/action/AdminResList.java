package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.HospitalVO;

public class AdminResList implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalService sc = HospitalServiceImpl.getInstance();
		
		String reqNum = request.getParameter("cus_num");
		String[] split = reqNum.split(";");
		String cus_num = split[1];
		List<HospitalVO> list = sc.hospitalList();
		System.out.println(split[1]);
		
		request.setAttribute("cus_num", cus_num);
		request.setAttribute("list", list);
		
		forward.setPath("/hos_res/QrResList.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
