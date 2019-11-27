package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.dao.HospitalDao;
import ddocdoc.dao.HospitalDaoImpl;
import ddocdoc.vo.HospitalVO;

public class HospitalUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalDao dao = HospitalDaoImpl.getInstance();
		
		String hos_num = request.getParameter("seq");
		System.out.println(hos_num+"hos_num");
		request.setAttribute("hos_num", hos_num);
		
		HospitalVO hospitalvo = dao.hospitalDetail(hos_num);
		request.setAttribute("hospitalvo", hospitalvo);
		
		forward.setRedirect(false);
		forward.setPath("/hospital.modify.jsp");
		
		return forward;
	}

}
