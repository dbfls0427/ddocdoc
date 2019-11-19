package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.ChildHeightVO;

public interface ChildHeightDao {

	//아이번호 가져오기
	String selectChildNum(String cus_num);
	
	//아이키 등록
	int insertChildHeight(ChildHeightVO chvo);
	
	//아이키 전체리스트
	List<ChildHeightVO> ChildHeightList(String ch_num);
}
