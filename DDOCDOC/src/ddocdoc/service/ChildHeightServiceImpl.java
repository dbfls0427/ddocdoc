package ddocdoc.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.dao.ChildHeightDao;
import ddocdoc.dao.ChildHeightDaoImpl;
import ddocdoc.vo.ChildHeightVO;

public class ChildHeightServiceImpl implements ChildHeightService {
	private static ChildHeightServiceImpl service = new ChildHeightServiceImpl();
	private static ChildHeightDao dao;
	
	public static ChildHeightServiceImpl getInstance() {
		dao = new ChildHeightDaoImpl().getInstance();
		return service;
	}
	
	//아이번호 가져오기
	@Override
	public String selectChildNum(String cus_num) {
		return dao.selectChildNum(cus_num);
	}

	//아이키 등록
	@Override
	public int insertChildHeight(HttpServletRequest request) {
		ChildHeightVO chvo = new ChildHeightVO();
		
		chvo.setHe_height(Integer.parseInt(request.getParameter("he_height")));
		chvo.setCh_num(String.valueOf(request.getAttribute("ch_num")));
		chvo.setHe_date(Date.valueOf(request.getParameter("he_date")));
		
		return dao.insertChildHeight(chvo);
	}

	//아이키 전체리스트
	@Override
	public List<ChildHeightVO> ChildHeightList(HttpServletRequest request) {
		String ch_num = request.getParameter("ch_num");
		
		return dao.ChildHeightList(ch_num);
	}

	//아이키 상세보기
	@Override
	public ChildHeightVO detailChildHeight(HttpServletRequest request) {
		String he_num = request.getParameter("he_num");
		
		return dao.detailChildHeight(he_num);
	}

	//아이키 수정
	@Override
	public int updateChildHeight(HttpServletRequest request) {
		ChildHeightVO chvo = new ChildHeightVO();
		
		chvo.setHe_num(request.getParameter("he_num"));
		chvo.setHe_height(Integer.parseInt(request.getParameter("he_height")));
		
		return dao.updateChildHeight(chvo);
	}

	//아이키 삭제
	@Override
	public int deleteChildHeight(HttpServletRequest request) {
		String he_num = request.getParameter("he_num");
		
		return dao.deleteChildHeight(he_num);
	}

}
