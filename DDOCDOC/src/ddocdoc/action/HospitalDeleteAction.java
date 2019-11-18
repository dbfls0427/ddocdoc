package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;

public class HospitalDeleteAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalService service = HospitalServiceImpl.getInstance();
		
		String hos_num = request.getParameter("seq");
		System.out.println("seqf���ؾ��ϳ�"+hos_num);
		service.hospitalDelete(hos_num);
		
		System.out.println("���Ѿ����?");
		forward.setPath("/DDOCDOC/hospital/hospitalList.do");
		
		System.out.println("�̸����ΰ������� ��");
		forward.setRedirect(true);
		
		return forward;
		
	}

}
