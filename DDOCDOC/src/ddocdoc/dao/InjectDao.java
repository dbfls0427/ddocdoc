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
}
