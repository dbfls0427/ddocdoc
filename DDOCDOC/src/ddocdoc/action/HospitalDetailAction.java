package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HosResVO;
import ddocdoc.vo.HospitalVO;

public class HospitalDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HospitalService service = HospitalServiceImpl.getInstance();
		ActionForward forward = new ActionForward();
		
		
		String hos_num = request.getParameter("seq");
//		String cus_num = (String)(LoginSession.loginSession.getAttribute("cus_num"));
		
		// ���� �󼼺���
		HospitalVO hospitalvo = service.hospitalDetail(hos_num);
		request.setAttribute("hospitalvo", hospitalvo);
		
		// ���� ���� ȯ�� ����Ʈ
		List<HosResVO> HosResVO = service.hosResList(hos_num);
		
		
		request.setAttribute("HosResVO", HosResVO);
		
		// ���� ȯ�� �̸� ����
		//List<CustomerVO> CustomerVO = service.hosResNameCustomer(request);
		//request.setAttribute("CustomerVO", CustomerVO);
		//String hos_num = request.getParameter("hos_num"); 
		// hos_num �̸��ߺ�
		
		
		
		
		System.out.println(hos_num);
		System.out.println("hos_num: "+hos_num);
		
		
		forward.setPath("/hospital.detail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
