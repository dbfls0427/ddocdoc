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
		String ch_name = request.getParameter("ch_name");
		
		//���� ��������
		String gender = service.selectGender(request);
		//ǥ��Ű ��������
		Float st_height = null;
		String genderTable = null;
		if(gender.equals("��")) {
			genderTable = "dd_girl_st_height";
		}else{
			genderTable = "dd_boy_st_height";
		}
		System.out.println("�׼ǿ��� ���̺��̸�~~~~" + genderTable);
		
		st_height = service.selectStHeight(request,genderTable);

		forward.setPath("/heightList.jsp?height_list="+height_list+"&st_height=" + st_height+"&ch_name=" + ch_name);
		forward.setRedirect(false);
		
		return forward;
	}

}
