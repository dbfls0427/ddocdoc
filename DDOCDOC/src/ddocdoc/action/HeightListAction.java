package ddocdoc.action;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ddocdoc.service.ChildHeightService;
import ddocdoc.service.ChildHeightServiceImpl;
import ddocdoc.vo.ChildHeightVO;

public class HeightListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		ActionForward forward = new ActionForward();
		ChildHeightService service = ChildHeightServiceImpl.getInstance();
		
		request.setCharacterEncoding("utf-8");
		 response.setContentType("text/html;charset=UTF-8");
		
		//아이의 키 리스트 가져오기
		List<ChildHeightVO> list = service.ChildHeightList(request);
		request.setAttribute("list", list);
		
		//아이의 키만 가져오기
		List<ChildHeightVO> height_list = new ArrayList<ChildHeightVO>();
		ChildHeightVO chvo = null;
			for(int i=0; i < list.size(); i++) {
				chvo = new ChildHeightVO();
				chvo.setHe_height(list.get(i).getHe_height());
				chvo.setHe_date(list.get(i).getHe_date());
				height_list.add(chvo);
			}
			
		request.setAttribute("height_list", height_list);
		String ch_name = request.getParameter("ch_name");
		
		//표준키 가져오기
		Float st_height = service.selectStHeight(request);
		
		
			
		forward.setPath("/heightList.jsp?height_list="+height_list+"&st_height=" + st_height+"&ch_name=" + ch_name);
		forward.setRedirect(false);
		
		return forward;
	}

}
