package ddocdoc.dao;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.LoginVO;

public interface CustomerDao {
	// 고객 회원가입
	public int insertCustomer(CustomerVO customer);
	
	// 로그인 확인
	public CustomerVO loginCustomer(LoginVO login);
	
	
}
