package ddocdoc.service;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;

public interface CustomerService {
	// 고객 회원가입
	public int insertCustomer(CustomerVO customer);
	
	// 고객 로그인
	public CustomerVO loginCustomer(HttpServletRequest request);

	// 인증번호
	public void confirmNumber();
	
	// 병원 번호 출력
	public String selectHosNum(String hos_name);
	
	// 병원 예약 입력
	public int insertHospitalRes(HospitalResVO hospitalresVO);
}
