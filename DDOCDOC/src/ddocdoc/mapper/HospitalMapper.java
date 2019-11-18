package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.HospitalVO;

public interface HospitalMapper {
	// ���� ���� ��� 
	int hospitalInsert(HospitalVO HospitalVO);
	
	// ���� ���� �󼼺���
	HospitalVO hospitalDetail(String hos_num);
	
	// ���� ���� ����Ʈ
	List<HospitalVO> hospitalList();
	
	// ���� ���� ����
	int hospitalUpdate(HospitalVO HospitalVO);
	
	// ���� ���� ����
	int hospitalDelete(String hos_num);
}
