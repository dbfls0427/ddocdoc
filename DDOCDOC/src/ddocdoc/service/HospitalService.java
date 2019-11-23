package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.HospitalWaitVO;
import ddocdoc.vo.MedicineVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;


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
	
	// ���� ���� ȯ�� ����Ʈ
	public List<HospitalResVO> hosResList(String hos_num);
	
	// ���� ȯ�� �̸� ����
	//public List<CustomerVO> hosResNameCustomer(HttpServletRequest request)throws Exception;
	
	// ���� ���� ����
	public int booleanHosRes(HttpServletRequest request)throws Exception;

	// ����ȣ ����
	public int increaseWait(String hos_num);
	
	// ����ȣ ������ ����
	public int insertWaitData(HospitalWaitVO waitVO);
	
	// �ش� ���� ����ȣ �߱�
	public int hospitalWait(String hos_num);
	
	// �� ����Ʈ ����
	public List<MedicineVO> medicineList();
	
	// ó���� �� �Է�
	public int insertPreDetail(PresDetailVO presDetail);
	
	// ó���� �� �� ����Ʈ
	public List<PresDetailVO> presDetailList(String pres_num);
	
	// ó���� �� �� �� �̸�
	public List<String> presDetailMedName(String pres_num);
	
	// ó���� �Է�
	public int insertPres(HttpServletRequest request) throws Exception;
	
	// presDetail
	public PresVO presDetail();

}
