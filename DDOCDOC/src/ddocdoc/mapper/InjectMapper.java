package ddocdoc.mapper;

import java.util.HashMap;
import java.util.List;

import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public interface InjectMapper {

	//���� ��õ���� �ҷ�����
	List<InjectInfoVO> selectInjInfo();

	//������� �ҷ�����
	List<String> selectInjList(String ch_num);
}
