package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.ChildHeightVO;

public interface ChildHeightMapper {

	//���̹�ȣ ��������
	String selectChildNum(String cus_num);
	
	//����Ű ���
	int insertChildHeight(ChildHeightVO chvo);
	
	//����Ű ��ü����Ʈ
	List<ChildHeightVO> ChildHeightList(String ch_num);
	
	//����Ű ��
	ChildHeightVO detailChildHeight(String he_num);
	
	//����Ű ����
	int updateChildHeight(ChildHeightVO chvo);
	
	//����Ű ����
	int deleteChildHeight(String he_num);
	
	//���� Ű��ȣ ��������
	String selectHeNum(String ch_num);
}