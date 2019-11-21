package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;

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
	
	// ���� ��� ����Ʈ
	public List<HospitalResVO> resList(String cus_num);
	
	//���� ���� ����
	public HospitalVO detailHospital(String hos_num);
	
	// ���� �̸� ����
	public List<String> detailNameHospital(String cus_num);
	
	// ���� �� ����
	public HospitalResVO detailRes(String hos_res_num);
	
	// ���� ���
	public int deleteRes(String hos_res_num);
}
