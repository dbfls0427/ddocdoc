package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;

public interface CustomerMapper {
	int insertCustomer(CustomerVO customer);
	
	CustomerVO loginCustomer(LoginVO login);
	
	// ���� ��ȣ ���
	String selectHosNum(String hos_name);
	
	// ���� ���� �Է�
	int insertHospitalRes(HospitalResVO hospitalresVO);
	
	// ���� ��� ����Ʈ
	List<HospitalResVO> resList(String cus_num);
	
	// ���� ���� ����
	HospitalVO detailHospital(String hos_num);
	
	// ���� �̸� ����
	List<String> detailNameHospital(String cus_num);
	
	//���� �� ����
	HospitalResVO detailRes(String hos_res_num);
	
	//���� ���
	int deleteRes(String hos_res_num);
	
	// ���� ����� �� ����ȣ ����
	int decreaseWait(String hos_num);
	
	// ����ȣ ��ȸ
	int detailWait(String hos_res_num);
	
	// ���������� ����
	int customerUpdate(CustomerVO customer);
	
	// ȸ�� Ż��
	int customerDelete(String cus_num);
}
