package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.ChildVO;

public interface ChildMapper {
	
	// ���� ���� ��� 
	int insertChild(ChildVO ChildVO);
		
	// ���� ���� �󼼺���
	ChildVO childDetail(String ch_num);
		
	// ���� ���� ����Ʈ
	List<ChildVO> childList();
	
	// ���� ���� ����
	int updateChild(ChildVO ChildVO);
		
	// ���� ���� ����
	int deleteChild(String ch_num);
}
