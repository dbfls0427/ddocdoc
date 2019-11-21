package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalWaitVO;

public class HospitalBooleanAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HospitalService service = HospitalServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		// 병원 예약 접수
		String hos_res_num = request.getParameter("hos_res_num");
		String seq = request.getParameter("seq");
		
		int hosResvo = service.booleanHosRes(request);
				
		request.setAttribute("boolean", hosResvo);
		System.out.println("hos_res_num"+hos_res_num);
		
		int re = service.increaseWait(seq);
		
		HospitalWaitVO waitVO = new HospitalWaitVO();
		waitVO.setCus_num(((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num());
		waitVO.setHos_num(seq);
		waitVO.setHos_res_num(hos_res_num);
		waitVO.setRes_wait(service.hospitalWait(seq));
		System.out.println("서비스waitVO에서 : " + waitVO.getCus_num() + " " + waitVO.getHos_num() + " " + waitVO.getRes_wait());
		int re2 = service.insertWaitData(waitVO);
		
		
		forward.setPath("hospitalDetail.do?seq=" + seq);
		forward.setRedirect(true);
		
		return forward;
	}

}
