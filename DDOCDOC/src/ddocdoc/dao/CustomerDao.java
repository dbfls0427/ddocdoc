package ddocdoc.dao;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.LoginVO;

public interface CustomerDao {
	// �� ȸ������
	public int insertCustomer(CustomerVO customer);
	
	// �α��� Ȯ��
	public CustomerVO loginCustomer(LoginVO login);
	
	
}
