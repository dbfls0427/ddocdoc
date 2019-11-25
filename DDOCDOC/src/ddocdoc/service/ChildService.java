package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.ChildVO;

public interface ChildService {
	
	// �������� ��� ����
	public int insertChild(HttpServletRequest request) throws Exception;
	
	// �������� �󼼺��� ����
	public ChildVO childDetail(String ch_num);
	
	// �������� ����Ʈ ����
	public List<ChildVO> childList(String cus_num);
	
	// �������� ���� ����
	public int updateChild(HttpServletRequest request) throws Exception;
	
	// �������� ���� ����
	public int deleteChild(String ch_num);

}
