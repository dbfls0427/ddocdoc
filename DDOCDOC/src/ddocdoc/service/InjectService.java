package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public interface InjectService {

	//������õ���� �ҷ�����
	List<InjectInfoVO> selectInjInfo();
	
	//�����ѱ�� �ҷ�����
	List<String> selectInjList(HttpServletRequest request);
}
