package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.ChildVO;

public interface ChildDao {
	// 아이정보 등록
	public int insertChild(ChildVO ChildVO); 
	
	// 아이정보 상세정보
	public ChildVO childDetail(String ch_num); 
	
	// 아이정보 리스트
	public List<ChildVO> childList(String cus_num);
	
	// 아이정보 수정
	public int updateChild(ChildVO ChildVO);
	
	// 아이정보 삭제
	public int deleteChild(String ch_num);
}
