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
		
		int count = service.injCount(request);
		int total = service.injTotal(request);
		
		System.out.println(count);
		System.out.println(total);
		
		String percent =  Math.round((double) count / (double) total * 100.0) + "%";
		int pc = (int)Math.round((double) count / (double) total * 100.0);
		System.out.println(percent);
		
		//접종 여부
		for(int i=0; i<injList.size(); i++) {
			System.out.println(injList.get(i));
		}
		String ch_num = request.getParameter("ch_num");
	
		request.setAttribute("list", list);
		request.setAttribute("injList", injList);
		request.setAttribute("percent", percent);
		request.setAttribute("pc", pc);
		
		forward.setPath("/injection/injectList.jsp?ch_num=" + ch_num);
		forward.setRedirect(false);
		
		return forward;
	}

}
