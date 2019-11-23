package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.HospitalService;
import ddocdoc.service.HospitalServiceImpl;

public class PresInsertAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		HospitalService service = HospitalServiceImpl.getInstance();
		
		String hos_res_num = request.getParameter("hos_res_num");
		
		int re = service.insertPres(request);
		
		request.setAttribute("hos_res_num", hos_res_num);


		
		forward.setPath("presInsertForm.do");
		forward.setRedirect(false);
		return forward;
	}

}
