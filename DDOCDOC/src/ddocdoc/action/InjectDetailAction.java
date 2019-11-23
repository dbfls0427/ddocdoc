package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.InjectService;
import ddocdoc.service.InjectServiceImpl;
import ddocdoc.vo.ChildInjectVO;

public class InjectDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		InjectService service = InjectServiceImpl.getInstance();
		
		String ch_num = request.getParameter("ch_num");
		String inj_content = request.getParameter("inj_content");
		String inj_info_name = request.getParameter("inj_info_name");
		String inj_info_date = request.getParameter("inj_info_date");
		
		ChildInjectVO civo = service.selectInjDetail(request);
		
		request.setAttribute("civo", civo);
		request.setAttribute("inj_info_name", inj_info_name);
		request.setAttribute("inj_info_date", inj_info_date);
		
		
		forward.setPath("/injection/injectDetail.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
