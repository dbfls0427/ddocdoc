package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.PayVO;
import ddocdoc.vo.PharResVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;
import ddocdoc.vo.ReviewVO;

public interface CustomerService {
	// �� ȸ������
	public int insertCustomer(CustomerVO customer);

	// �� �α���
	public CustomerVO loginCustomer(HttpServletRequest request);

	// ������ȣ
	public void confirmNumber();

	// ����ȣ ����
	public void hospitalResSms(int count);

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

	// ���� ��� �� ����ȣ ����
	public int decreaseWait(String hos_num);

	// ����ȣ ��ȸ
	public int detailWait(String hos_res_num);

	// ȸ������ ����
	public int customerUpdate(CustomerVO customer);

	// ȸ�� Ż��
	public int customerDelete(String cus_num);

	// ó���� ����
	public PresVO presRealDetail(String hos_res_num);

	// ó���� �� �� ��ȸ ����Ʈ
	public List<PresDetailVO> cusPresDetailList(String pres_num);

	// ó���� �� �� �� �̸�
	public List<String> cusPresDetailMedName(String pres_num);

	// ���� �ϱ�
	public int insertPay(PayVO pay);

	// �����Ϸ�
	public int updatePay(String pres_num);

	// ó���� ���� ���� ����
	public String selectPayCheck(String pres_num);

	// �� ���� ����
	public int selectPayPrice(String hos_res_num);

	// �౹ ��ȣ ����
	public String selectPharNum(String phar_name);

	// �౹ �����ϱ�
	public int insertPharRes(PharResVO pvo);

	// �౹ ���� ����Ʈ
	public List<PharResVO> pharResList(String cus_num);

	// �౹ �̸� ��������
	public List<String> detailNamePharmacy(String cus_num);

	// �౹ ���� �󼼺���
	public PharResVO presDetail(String phar_res_num);

	// �౹ �̸� ����
	public String selectPharmacyName(String phar_num);

	// �౹ ����ȣ ����
	public int increasePharResWait(String phar_res_num);

	// �౹ ����ȣ ��ȸ
	public int detailPharWait(String phar_num);

	// review create
	public int reviewInsert(HttpServletRequest request) throws Exception;

	// review detail
	public ReviewVO reviewDetail(String rv_num);

	// review info list
	public List<ReviewVO> reviewList(String cus_num);

	// review update
	public int reviewUpdate(HttpServletRequest request) throws Exception;

	// review delete
	public int reviewDelete(String rv_num);
	
	// ��ȸ �� ����
	public int increaseHits(String rv_num);
		
	// �Խñ� ��ȸ �� ��ȸ
	public int detailHits(String rv_num);
}
