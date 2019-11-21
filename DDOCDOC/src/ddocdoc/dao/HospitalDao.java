package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;

public interface HospitalDao {
	// ���� ���� ���	
	public int hospitalInsert(HospitalVO HospitalVO);
	
	// ���� ���� ������
	public HospitalVO hospitalDetail(String hos_num);
	
	// ���� ���� ����Ʈ
	public List<HospitalVO> hospitalList();
	
	// ���� ���� ����	
	public int hospitalUpdate(HospitalVO HospitalVO);
	
	// ���� ���� ����
	public int hospitalDelete(String hos_num);
	
	// ���� ���� ȯ�� ����Ʈ
	public List<HospitalResVO> hosResList(String hos_num);
	
	// ���� ȯ�� �̸� ����
	//List<CustomerVO> hosResNameCustomer(String cus_num);
	
	// ���� ���� ����
	int booleanHosRes(HospitalResVO HosResVO);
}
