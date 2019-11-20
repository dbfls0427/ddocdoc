package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.ChildHeightVO;

public interface ChildHeightService {

	//아이번호 가져오기
	String selectChildNum(String cus_num);
	
	//아이키 등록
	int insertChildHeight(HttpServletRequest request);
	
	//아이키 전체리스트
	List<ChildHeightVO> ChildHeightList(HttpServletRequest request);
	
	//아이키 상세
	ChildHeightVO detailChildHeight(HttpServletRequest request);
	
	//아이키 수정
	int updateChildHeight(HttpServletRequest request);
	
	//아이키 삭제
	int deleteChildHeight(HttpServletRequest request);
	
	//아이 키 번호 가져오기
	String selectHeNum(String ch_num);
}
