package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.ChildHeightVO;
import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public interface InjectService {

	//������õ���� �ҷ�����
	List<InjectInfoVO> selectInjInfo();
	
	//�����ѱ�� �ҷ�����
	List<String> selectInjList(HttpServletRequest request);
	
	//���� ����ϱ�
	int insertInj(HttpServletRequest request);
	
	//���� ������
	ChildInjectVO selectInjDetail(HttpServletRequest request);
	
	//���� ���� ����
	int updateInj(HttpServletRequest request);
	
	//���� ���� ����
	int deleteInj(HttpServletRequest request);
	
	//������� ����
	int injCount(HttpServletRequest request);
	
	//��ü����
	int injTotal(HttpServletRequest request);
}
