package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.HospitalVO;


public interface HospitalService {
	
	// �������� ��� ����
	public int hospitalInsert(HttpServletRequest request) throws Exception;
	
	// �������� �󼼺��� ����
	public HospitalVO hospitalDetail(String hos_num);
	
	// ���� ���� ����Ʈ ����
	public List<HospitalVO> hospitalList();
	
	// ���� ���� ����	 ����
	public int hospitalUpdate(HttpServletRequest request)throws Exception;
	
	// ���� ���� ���� ����
	public int hospitalDelete(String hos_num);
	
}
