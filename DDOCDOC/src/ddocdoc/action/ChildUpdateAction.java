package ddocdoc.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.dao.ChildDao;
import ddocdoc.dao.ChildDaoImpl;
import ddocdoc.service.ChildService;
import ddocdoc.service.ChildServiceImpl;
import ddocdoc.vo.ChildVO;

public class ChildUpdateAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildService service = ChildServiceImpl.getInstance();
		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		String ch_num = request.getParameter("ch_num");
		System.out.println("childUpdateAction ch_num : " + ch_num);
		service.updateChild(request);
		
		System.out.println("childUpdateAciton plz go! ");
		forward.setPath("childDetail.do?ch_num="+ch_num);
		forward.setRedirect(false);
		
		
		return forward;
	}

}
