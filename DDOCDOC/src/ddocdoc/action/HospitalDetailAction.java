package ddocdoc.action;

import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;

public class HospitalDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HospitalService service = HospitalServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		System.out.println("hospitaldetailAction�Ѿ��~!");
		
		String hos_num = request.getParameter("seq");
		
		// ���� �󼼺���
		HospitalVO hospitalvo = service.hospitalDetail(hos_num);
		request.setAttribute("hospitalvo", hospitalvo);
		
		// ���� ���� ȯ�� ����Ʈ
		List<HospitalResVO> HosResVO = service.hosResList(hos_num);
		
		for(int i = 0; i < HosResVO.size(); i++) {
			System.out.println("detailaction���� " + HosResVO.get(i).getHos_res_num() + HosResVO.get(i).getHos_acpt());
		}
		
		request.setAttribute("HosResVO", HosResVO);
		
		
		
		
		System.out.println(hos_num);
		System.out.println("hos_num: "+hos_num);
		
		
		forward.setPath("/hospital.detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
