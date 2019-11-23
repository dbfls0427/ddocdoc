package ddocdoc.action;

import java.security.Provider.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.dao.ChildDao;
import ddocdoc.dao.ChildDaoImpl;
import ddocdoc.vo.ChildVO;

public class ChildUpdateFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildDao dao = ChildDaoImpl.getInstance();
		
		
		String ch_num = request.getParameter("ch_num");
		System.out.println("childUpdateForm ch_num : " + ch_num);
		request.setAttribute("ch_num", ch_num);
		
		ChildVO childvo = dao.childDetail(ch_num);
		request.setAttribute("childvo", childvo);
		
		forward.setPath("/child.modify.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
