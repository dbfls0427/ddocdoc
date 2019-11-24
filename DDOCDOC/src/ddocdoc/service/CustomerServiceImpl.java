package ddocdoc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import ddocdoc.dao.CustomerDao;
import ddocdoc.dao.CustomerDaoImpl;
import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.ConfirmVO;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;
import ddocdoc.vo.PayVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;
import ddocdoc.service.Coolsms;

public class CustomerServiceImpl implements CustomerService{
	private static CustomerServiceImpl sc = new CustomerServiceImpl();
	private static CustomerDao dao;
	LoginSession session = new LoginSession(); //�α��� ���� ��ü ����
	public static ConfirmVO confirm;
	public static boolean check = true;
	
	
	public static CustomerServiceImpl getInstance() {
		dao = CustomerDaoImpl.getInstance();
		return sc;
	}
	
	
	// �� ȸ������
	@Override
	public int insertCustomer(CustomerVO customer) {
		return dao.insertCustomer(customer);
	}
	
	
	// �α��� Ȯ��
	@Override
	public CustomerVO loginCustomer(HttpServletRequest request) {
		LoginVO login = new LoginVO();
		login.setLoginId(request.getParameter("customerID"));
		login.setLoginPw(request.getParameter("customerPW"));
		
		CustomerVO customer = dao.loginCustomer(login);
		
		if(customer != null) {
			session.sessionInsert(request, customer);
		}else {
			return null;
		}
		
		return customer;
		
		
		
	}
	
	//������ȣ
	@Override
	public void confirmNumber() {
		Random rand = new Random();
		String numStr = "";
		
		for(int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}
		
		System.out.println("���񽺿���" + numStr);
		sendSMS(numStr, "01087327595");
		
		confirm = new ConfirmVO();
		confirm.setConfirmNum(numStr);
		
		
		
	}
	
	//����ȣ ���� ����
	@Override
	public void hospitalResSms(int count) {
		String resultCount = Integer.toString(count);
		sendSMS("������ ���� ����ȣ�� " + resultCount + "�� �Դϴ�. �������ּż� ����帳�ϴ�.", "01087327595");
	}
	
	//SMS
	public static void sendSMS(String msg, String phone) {
		String api_key = "NCS6LRSLFNTOFWIF";
		String api_secret = "A6SHXGJ6CYRMF4ADYZO0JFOS5SLZJERK";
		Coolsms coolsms = new Coolsms(api_key, api_secret);
		
		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", "01087327595");
		set.put("from", phone);
		set.put("text", msg);
		set.put("type", "sms");
		
		JSONObject result = coolsms.send(set);
		if((Boolean) result.get("status") == true) {
			System.out.println("����");
			System.out.println(result.get("group_id"));
			System.out.println(result.get("result_code"));
			System.out.println(result.get("result_message"));
			System.out.println(result.get("success_count"));
		}else {
			System.out.println("����");
			System.out.println(result.get("code"));
			System.out.println(result.get("message"));
		}
	}
	
	
	//���� ��ȣ ���
	@Override
	public String selectHosNum(String hos_name) {
		return dao.selectHosNum(hos_name);
	}
	
	
	// ���� ���� �Է�
	@Override
	public int insertHospitalRes(HospitalResVO hospitalresVO) {
		return dao.insertHospitalRes(hospitalresVO);
	}
	
	// ���� ��� ����Ʈ
	@Override
	public List<HospitalResVO> resList(String cus_num){
		return dao.resList(cus_num);
	}
	
	
	// ���� ���� ����
	@Override
	public HospitalVO detailHospital(String hos_num) {
		return dao.detailHospital(hos_num);
	}
	
	// ���� �̸� ����
	@Override
	public List<String> detailNameHospital(String cus_num){
		return dao.detailNameHospital(cus_num);
	}
	
	// ���� �� ����
	@Override
	public HospitalResVO detailRes(String hos_res_num) {
		return dao.detailRes(hos_res_num);
	}
	
	// ���� ���
	@Override
	public int deleteRes(String hos_res_num) {
		return dao.deleteRes(hos_res_num);
	}
	
	// ���� ��� �� ����ȣ ����
	@Override
	public int decreaseWait(String hos_num) {
		return dao.decreaseWait(hos_num);
	}
	
	// ����ȣ ��ȸ
	@Override
	public int detailWait(String hos_res_num) {
		return dao.detailWait(hos_res_num);
	}
	
	// ȸ������ ����
	@Override
	public int customerUpdate(CustomerVO customer) {
		return dao.customerUpdate(customer);
	}
	
	
	// ȸ�� Ż��
	@Override
	public int customerDelete(String cus_num) {
		return dao.customerDelete(cus_num);
	}
	
	// ó���� ����
	@Override
	public PresVO presRealDetail(String hos_res_num) {
		return dao.presRealDetail(hos_res_num);
	}
	
	// ó���� �� �� ��ȸ ����Ʈ
	@Override
	public List<PresDetailVO> cusPresDetailList(String pres_num) {
		return dao.cusPresDetailList(pres_num);
	}
			
	// ó���� �� �� �� �̸�
	@Override
	public List<String> cusPresDetailMedName(String pres_num){
		return dao.cusPresDetailMedName(pres_num);
		
	}
	
	// ���� �ϱ�
	@Override
	public int insertPay(PayVO pay) {
		return dao.insertPay(pay);
	}
	
	// �����Ϸ�
	@Override
	public int updatePay(String pres_num) {
		return dao.updatePay(pres_num);
	}
	
	// ó���� ���� ���� ����
	@Override
	public String selectPayCheck(String pres_num) {
		return dao.selectPayCheck(pres_num);
	}
	
	// �� ���� ����
	@Override
	public int selectPayPrice(String hos_res_num) {
		return dao.selectPayPrice(hos_res_num);
	}

}
