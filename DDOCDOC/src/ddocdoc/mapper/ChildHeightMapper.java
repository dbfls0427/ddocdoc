package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.ChildHeightVO;

public interface ChildHeightMapper {

	//아이번호 가져오기
	String selectChildNum(String cus_num);
	
	//아이키 등록
	int insertChildHeight(ChildHeightVO chvo);
	
	//아이키 전체리스트
	List<ChildHeightVO> ChildHeightList(String ch_num);
	
	//아이키 상세
	ChildHeightVO detailChildHeight(String he_num);
	
	//아이키 수정
	int updateChildHeight(ChildHeightVO chvo);
	
	//아이키 삭제
	int deleteChildHeight(String he_num);
	
	//아이 키번호 가져오기
	String selectHeNum(String ch_num);
}
