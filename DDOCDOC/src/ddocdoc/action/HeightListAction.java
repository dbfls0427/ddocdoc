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
		
		//������ Ű ����Ʈ ��������
		List<ChildHeightVO> list = service.ChildHeightList(request);
		request.setAttribute("list", list);
		
		//������ Ű�� ��������
		List<ChildHeightVO> height_list = new ArrayList<ChildHeightVO>();
		ChildHeightVO chvo = null;
			for(int i=0; i < list.size(); i++) {
				chvo = new ChildHeightVO();
				chvo.setHe_height(list.get(i).getHe_height());
				chvo.setHe_date(list.get(i).getHe_date());
				height_list.add(chvo);
			}
			request.setAttribute("height_list", height_list);
				
		
		forward.setPath("/heightList.jsp?height_list="+height_list);
		forward.setRedirect(false);
		
		return forward;
	}

}
