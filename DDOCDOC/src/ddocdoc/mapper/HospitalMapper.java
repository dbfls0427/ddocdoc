package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.HospitalWaitVO;
import ddocdoc.vo.MedicineVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

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
	
	// ����ȣ ����
	int increaseWait(String hos_num);
	
	// ����ȣ ������ ����
	int insertWaitData(HospitalWaitVO waitVO);
	
	// �ش� ���� ����ȣ �߱�
	int hospitalWait(String hos_num);
	
	
	// �� ����Ʈ
	List<MedicineVO> medicineList();
	
	// ó���� �� �Է�
	int insertPreDetail(PresDetailVO presDetail);
	
	// ó���� �� �� ����Ʈ
	List<PresDetailVO> presDetailList(String pres_num);
	
	// ó���� �� �� �� �̸�
	List<String> presDetailMedName(String pres_num);
	
	// ó���� �Է�
	int insertPres(PresVO presVO);
	
	// presDetail
	PresVO presDetail();
	
}
