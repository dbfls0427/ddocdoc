package ddocdoc.mapper;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.LoginVO;

public interface CustomerMapper {
	int insertCustomer(CustomerVO customer);
	
	CustomerVO loginCustomer(LoginVO login);
	
	// 병원 번호 출력
	String selectHosNum(String hos_name);
	
	// 병원 예약 입력
	int insertHospitalRes(HospitalResVO hospitalresVO);
}
