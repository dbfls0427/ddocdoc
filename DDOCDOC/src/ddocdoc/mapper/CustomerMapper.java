package ddocdoc.mapper;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.LoginVO;

public interface CustomerMapper {
	int insertCustomer(CustomerVO customer);
	
	CustomerVO loginCustomer(LoginVO login);
	
	// ���� ��ȣ ���
	String selectHosNum(String hos_name);
	
	// ���� ���� �Է�
	int insertHospitalRes(HospitalResVO hospitalresVO);
}
