package ddocdoc.service;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;

public interface CustomerService {
	// �� ȸ������
	public int insertCustomer(CustomerVO customer);
	
	// �� �α���
	public CustomerVO loginCustomer(HttpServletRequest request);
}
