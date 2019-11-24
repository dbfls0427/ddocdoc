package ddocdoc.action;

import java.util.ArrayList;
import java.util.HashMap;
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
		
		//성별 가져오기
		String gender = service.selectGender(request);
		//표준키 가져오기
		Float st_height = null;
		String genderTable = null;
		if(gender.equals("여")) {
			genderTable = "dd_girl_st_height";
		}else{
			genderTable = "dd_boy_st_height";
		}
		System.out.println("액션에서 테이블이름~~~~" + genderTable);
		
		st_height = service.selectStHeight(request,genderTable);

		forward.setPath("/heightList.jsp?height_list="+height_list+"&st_height=" + st_height+"&ch_name=" + ch_name);
		forward.setRedirect(false);
		
		return forward;
	}

}
