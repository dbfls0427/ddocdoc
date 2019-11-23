package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;

public interface CustomerService {
	// 고객 회원가입
	public int insertCustomer(CustomerVO customer);
	
	// 고객 로그인
	public CustomerVO loginCustomer(HttpServletRequest request);

	// 인증번호
	public void confirmNumber();
	
	// 대기번호 인증
	public void hospitalResSms(int count);
	
	// 병원 번호 출력
	public String selectHosNum(String hos_name);
	
	// 병원 예약 입력
	public int insertHospitalRes(HospitalResVO hospitalresVO);
	
	// 예약 목록 리스트
	public List<HospitalResVO> resList(String cus_num);
	
	//병원 정보 추출
	public HospitalVO detailHospital(String hos_num);
	
	// 병원 이름 추출
	public List<String> detailNameHospital(String cus_num);
	
	// 예약 상세 내용
	public HospitalResVO detailRes(String hos_res_num);
	
	// 예약 취소
	public int deleteRes(String hos_res_num);
	
	// 예약 취소 시 대기번호 감소
	public int decreaseWait(String hos_num);
	
	// 대기번호 조회
	public int detailWait(String hos_res_num);
	
	// 회원정보 수정
	public int customerUpdate(CustomerVO customer);
	
	// 회원 탈퇴
	public int customerDelete(String cus_num);
}
