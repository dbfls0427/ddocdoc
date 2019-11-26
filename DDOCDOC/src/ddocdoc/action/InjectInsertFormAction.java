package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class InjectInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String ch_num = request.getParameter("ch_num");
		String inj_content = request.getParameter("inj_content");
		String inj_info_name = request.getParameter("inj_info_name");
		String inj_info_date = request.getParameter("inj_info_date");
		System.out.println(ch_num + " " + inj_content + " " + inj_info_name + " " + inj_info_date);
		
		request.setAttribute("ch_num", ch_num);
		request.setAttribute("inj_content", inj_content);
		request.setAttribute("inj_info_name", inj_info_name);
		request.setAttribute("inj_info_date", inj_info_date);
		
		forward.setPath("/injection/injectInsertForm.jsp");
		forward.setRedirect(false);
		return forward;
	}

}
