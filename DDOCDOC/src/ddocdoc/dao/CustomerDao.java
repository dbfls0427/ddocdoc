package ddocdoc.dao;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.LoginVO;

public interface CustomerDao {
	// 고객 회원가입
	public int insertCustomer(CustomerVO customer);
	
	// 로그인 확인
	public CustomerVO loginCustomer(LoginVO login);
	
	// 병원 번호 출력
	public String selectHosNum(String hos_name);
	
	// 병원 예약 입력
	public int insertHospitalRes(HospitalResVO hospitalresVO);
	
}
