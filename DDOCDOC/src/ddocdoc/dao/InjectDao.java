package ddocdoc.dao;

import java.util.HashMap;
import java.util.List;

import ddocdoc.vo.ChildHeightVO;
import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public interface InjectDao {

	//���� ��õ���� �ҷ�����
	List<InjectInfoVO> selectInjInfo();

	//������� �ҷ�����
	List<String> selectInjList(String ch_num);
	
	//���� ����ϱ�
	int insertInj(ChildInjectVO civo);
	
	//���� ���� ��
	ChildInjectVO selectInjDetail(HashMap<String, String> map);
	
	//���� ���� ����
	int updateInj(ChildInjectVO civo);
	
	//���� ���� ����
	int deleteInj(HashMap<String, String> map);
	
	//������ϰ���
	int injCount(String ch_num);
	
	//��ü ��������
	int injTotal(String ch_num);
}
