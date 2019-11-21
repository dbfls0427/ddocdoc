package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;

public interface CustomerDao {
	// �� ȸ������
	public int insertCustomer(CustomerVO customer);
	
	// �α��� Ȯ��
	public CustomerVO loginCustomer(LoginVO login);
	
	// ���� ��ȣ ���
	public String selectHosNum(String hos_name);
	
	// ���� ���� �Է�
	public int insertHospitalRes(HospitalResVO hospitalresVO);
	
	// ���� ��� ����Ʈ
	public List<HospitalResVO> resList(String cus_num);
	
	// ���� ���� ����
	public HospitalVO detailHospital(String hos_num);
	
	// ���� �̸� ����
	public List<String> detailNameHospital(String cus_num);
	
	// ���� �� ����
	public HospitalResVO detailRes(String hos_res_num);
	
	// ���� ���
	public int deleteRes(String hos_res_num);
	
}
