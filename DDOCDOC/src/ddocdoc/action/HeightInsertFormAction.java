package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.ChildHeightService;
import ddocdoc.service.ChildHeightServiceImpl;
import ddocdoc.vo.CustomerVO;

public class HeightInsertFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildHeightService service = ChildHeightServiceImpl.getInstance();
		
		String ch_num = request.getParameter("ch_num");
		System.out.println("insertFormAction���� ch_num : " +ch_num);
		
		//����Ű��ȣ ��������
		//String he_num = service.selectHeNum(ch_num);
		
		forward.setPath("/heightInsertForm.jsp?ch_num="+ch_num);
		forward.setRedirect(false);
		
		return forward;
	}

}
