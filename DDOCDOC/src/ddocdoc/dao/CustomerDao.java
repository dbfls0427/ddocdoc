package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
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
	
	// 예약 목록 리스트
	public List<HospitalResVO> resList(String cus_num);
	
	// 병원 정보 추출
	public HospitalVO detailHospital(String hos_num);
	
	// 병원 이름 추출
	public List<String> detailNameHospital(String cus_num);
	
	// 예약 상세 정보
	public HospitalResVO detailRes(String hos_res_num);
	
	// 예약 취소
	public int deleteRes(String hos_res_num);
	
}
