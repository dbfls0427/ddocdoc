package ddocdoc.action;

import java.util.ArrayList;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.InjectService;
import ddocdoc.service.InjectServiceImpl;
import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;


public class InjectListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		InjectService service = new InjectServiceImpl().getInstance();
		
		//접종 추천내역
		List<InjectInfoVO> list = service.selectInjInfo();
		List<String> injList = service.selectInjList(request);
		
		//접종 여부
		for(int i=0; i<injList.size(); i++) {
			System.out.println(injList.get(i));
		}
		
	
		request.setAttribute("list", list);
		request.setAttribute("injList", injList);
		
		forward.setPath("/injection/injectList.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}
