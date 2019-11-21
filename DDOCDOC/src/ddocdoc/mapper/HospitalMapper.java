package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
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
	
	// ���� ���� ���� ����Ʈ
	List<HospitalResVO> hosResList(String hos_num);
	
	// ���� ȯ�� �̸� ����
//	List<CustomerVO> hosResNameCustomer(String cus_num);
	
	// ���� ���� ����
	int booleanHosRes(HospitalResVO HosResVO);
	
}
