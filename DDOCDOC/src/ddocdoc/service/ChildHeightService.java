package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.ChildHeightVO;

public interface ChildHeightService {

	//���̹�ȣ ��������
	String selectChildNum(String cus_num);
	
	//����Ű ���
	int insertChildHeight(HttpServletRequest request);
	
	//����Ű ��ü����Ʈ
	List<ChildHeightVO> ChildHeightList(HttpServletRequest request);
}
