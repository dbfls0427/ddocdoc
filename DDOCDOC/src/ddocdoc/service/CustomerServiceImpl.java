package ddocdoc.service;

import java.util.HashMap;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import ddocdoc.dao.CustomerDao;
import ddocdoc.dao.CustomerDaoImpl;
import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.LoginVO;
import ddocdoc.service.Coolsms;

public class CustomerServiceImpl implements CustomerService{
	private static CustomerServiceImpl sc = new CustomerServiceImpl();
	private static CustomerDao dao;
	LoginSession session = new LoginSession(); //�α��� ���� ��ü ����
	
	
	public static CustomerServiceImpl getInstance() {
		dao = CustomerDaoImpl.getInstance();
		return sc;
	}
	
	
	// �� ȸ������
	public int insertCustomer(CustomerVO customer) {
		return dao.insertCustomer(customer);
	}
	
	
	// �α��� Ȯ��
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
	public String confirmNumber() {
		Random rand = new Random();
		String numStr = "";
		
		for(int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}
		
		System.out.println("���񽺿���" + numStr);
		sendSMS(numStr, "01087327595");
		
		
		
		return numStr;
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
	
	

}
