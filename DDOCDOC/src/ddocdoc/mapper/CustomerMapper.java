package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;
import ddocdoc.vo.PayVO;
import ddocdoc.vo.PharResVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

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
	
	// ó���� ����
	PresVO presRealDetail(String hos_res_num);
	
	// ó���� �� �� ��ȸ ����Ʈ
	List<PresDetailVO> cusPresDetailList(String pres_num);
	
	// ó���� �� �� �� �̸�
	List<String> cusPresDetailMedName(String pres_num);
	
	// ���� �ϱ�
	int insertPay(PayVO pay);
	
	// �����Ϸ�
	int updatePay(String pres_num);
	
	// ó���� ���� ���� ����
	String selectPayCheck(String pres_num);
	
	// �� ���� ����
	int selectPayPrice(String hos_res_num);
	
	//�౹ ��ȣ ���
	String selectPharNum(String phar_name);
	
	//�౹ �����ϱ�
	int insertPharRes(PharResVO pvo);
	
	//�౹ ���� ����Ʈ
	List<PharResVO> pharResList(String cus_num);
	
	//�౹ �̸� ��������
	List<String> detailNamePharmacy(String cus_num);
}
