package ddocdoc.service;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;

public interface CustomerService {
	// �� ȸ������
	public int insertCustomer(CustomerVO customer);
	
	// �� �α���
	public CustomerVO loginCustomer(HttpServletRequest request);

	// ������ȣ
	public void confirmNumber();
	
	// ���� ��ȣ ���
	public String selectHosNum(String hos_name);
	
	// ���� ���� �Է�
	public int insertHospitalRes(HospitalResVO hospitalresVO);
}
