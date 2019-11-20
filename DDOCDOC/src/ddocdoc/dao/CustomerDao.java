package ddocdoc.dao;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
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
	
}
