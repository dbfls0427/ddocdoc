package ddocdoc.service;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.dao.CustomerDao;
import ddocdoc.dao.CustomerDaoImpl;
import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.LoginVO;

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
	
	

}
