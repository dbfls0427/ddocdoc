package ddocdoc.service;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;

public interface CustomerService {
	// 고객 회원가입
	public int insertCustomer(CustomerVO customer);
	
	// 고객 로그인
	public CustomerVO loginCustomer(HttpServletRequest request);
}
