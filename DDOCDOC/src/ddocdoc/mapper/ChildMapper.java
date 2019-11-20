package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.ChildVO;

public interface ChildMapper {
	
	// 아이 정보 등록 
	int insertChild(ChildVO ChildVO);
		
	// 아이 정보 상세보기
	ChildVO childDetail(String ch_num);
		
	// 아이 정보 리스트
	List<ChildVO> childList();
	
	// 아이 정보 수정
	int updateChild(ChildVO ChildVO);
		
	// 아이 정보 삭제
	int deleteChild(String ch_num);
}
