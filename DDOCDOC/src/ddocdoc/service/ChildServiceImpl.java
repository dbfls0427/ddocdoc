package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.dao.ChildDao;
import ddocdoc.dao.ChildDaoImpl;
import ddocdoc.vo.ChildVO;

public class ChildServiceImpl implements ChildService {
	private static ChildServiceImpl service = new ChildServiceImpl();
	private static ChildDao dao;
	
	public static ChildServiceImpl getInstance() {
		dao = ChildDaoImpl.getInstance();
		return service;
	}

	// �������� ��� ����
	@Override
	public int insertChild(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ChildVO ChildVO = new ChildVO();
		ChildVO.setCh_name(request.getParameter("ch_name"));
		int ch_age = Integer.parseInt(request.getParameter("ch_age"));
		ChildVO.setCh_age(ch_age);
		
		
	    String s = request.getParameter("ch_birth");
	    java.util.Date birth = new java.util.Date(s);
	    java.sql.Date ch_birth = new java.sql.Date(birth.getTime());
	    ChildVO.setCh_birth(ch_birth);
	    
		ChildVO.setCh_gender(request.getParameter("ch_gender"));
		ChildVO.setCus_num(request.getParameter("cus_num")); 
		
		return dao.insertChild(ChildVO);
	}

	// �������� �󼼺��� ����
	@Override
	public ChildVO childDetail(String ch_num) {
		ChildVO childVO = dao.childDetail(ch_num);
		return childVO;
	}

	// �������� ����Ʈ ����
	@Override
	public List<ChildVO> childList() {
		return dao.childList();
	}

	// �������� ���� ����
	@Override
	public int updateChild(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		ChildVO childVO = new ChildVO();
		childVO.setCh_num(request.getParameter("ch_num"));
		childVO.setCh_name(request.getParameter("ch_name"));
		int ch_age = Integer.parseInt(request.getParameter("ch_age"));
		childVO.setCh_age(ch_age);
		 String s = request.getParameter("ch_birth");
	    java.util.Date birth = new java.util.Date(s);
	    java.sql.Date ch_birth = new java.sql.Date(birth.getTime());
	    childVO.setCh_birth(ch_birth);
	    childVO.setCh_gender(request.getParameter("ch_gender"));
	    
	    int re = dao.updateChild(childVO);
		
		return re;
	}

	// �������� ���� ����
	@Override
	public int deleteChild(String ch_num) {
		return dao.deleteChild(ch_num);
	}

}
