package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.HospitalWaitVO;
import ddocdoc.vo.MedicineVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

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
	public int booleanHosRes(HospitalResVO HosResVO);
	
	// ����ȣ ����
	public int increaseWait(String hos_num);
	
	// ����ȣ ������ ����
	public int insertWaitData(HospitalWaitVO waitVO);
	
	// �ش� ���� ����ȣ �߱�
	public int hospitalWait(String hos_num);
	
	// �� ����Ʈ
	public List<MedicineVO> medicineList();
	
	// ó���� �� �Է�
	public int insertPreDetail(PresDetailVO presDetail);
	
	// ó���� �� �� ����Ʈ
	public List<PresDetailVO> presDetailList(String pres_num);
	
	// ó���� �� �� �� �̸�
	public List<String> presDetailMedName(String pres_num);
	
	// ó���� �Է�
	public int insertPres(PresVO presVO);
	
	// presDetail
	public PresVO presDetail();
	
}
