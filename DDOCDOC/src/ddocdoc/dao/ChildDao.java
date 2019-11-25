package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.ChildVO;

public interface ChildDao {
	// �������� ���
	public int insertChild(ChildVO ChildVO); 
	
	// �������� ������
	public ChildVO childDetail(String ch_num); 
	
	// �������� ����Ʈ
	public List<ChildVO> childList(String cus_num);
	
	// �������� ����
	public int updateChild(ChildVO ChildVO);
	
	// �������� ����
	public int deleteChild(String ch_num);
}
