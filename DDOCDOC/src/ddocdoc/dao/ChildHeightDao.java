package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.ChildHeightVO;

public interface ChildHeightDao {

	//���̹�ȣ ��������
	String selectChildNum(String cus_num);
	
	//����Ű ���
	int insertChildHeight(ChildHeightVO chvo);
	
	//����Ű ��ü����Ʈ
	List<ChildHeightVO> ChildHeightList(String ch_num);
}
