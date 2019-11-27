package ddocdoc.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.loginSession.LoginSession;
import ddocdoc.service.ChildService;
import ddocdoc.service.ChildServiceImpl;
import ddocdoc.vo.ChildVO;
import ddocdoc.vo.CustomerVO;

public class ChildListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildService service = ChildServiceImpl.getInstance();
		
		String cus_num = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num();
		System.out.println("cus_num__childLIstAction 에서1: "+cus_num);
		request.setAttribute("cus_name", cus_num);
		System.out.println("cus_num__childLIstAction 에서2: "+cus_num);
		
		
		List<ChildVO> list = service.childList(cus_num);
		request.setAttribute("cus_num", cus_num);
		request.setAttribute("childList", list);
		
		String cus_name = request.getParameter("cus_name");
		request.setAttribute("cus_name", cus_name);
		
		System.out.println("cus_num__childLIstAction 에서3: "+cus_num);
		System.out.println("리스트액션에서 고객이름:" + cus_name);
		forward.setRedirect(false);
		forward.setPath("/child.list.jsp");
		
		return forward;
	}

}
