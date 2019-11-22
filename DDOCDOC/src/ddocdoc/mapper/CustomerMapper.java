package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;

public interface CustomerMapper {
	int insertCustomer(CustomerVO customer);
	
	CustomerVO loginCustomer(LoginVO login);
	
	// 병원 번호 출력
	String selectHosNum(String hos_name);
	
	// 병원 예약 입력
	int insertHospitalRes(HospitalResVO hospitalresVO);
	
	// 예약 목록 리스트
	List<HospitalResVO> resList(String cus_num);
	
	// 병원 정보 추출
	HospitalVO detailHospital(String hos_num);
	
	// 병원 이름 추출
	List<String> detailNameHospital(String cus_num);
	
	//예약 상세 내용
	HospitalResVO detailRes(String hos_res_num);
	
	//예약 취소
	int deleteRes(String hos_res_num);
	
	// 예약 취소할 때 대기번호 감소
	int decreaseWait(String hos_num);
	
	// 대기번호 조회
	int detailWait(String hos_res_num);
	
	// 마이페이지 수정
	int customerUpdate(CustomerVO customer);
	
	// 회원 탈퇴
	int customerDelete(String cus_num);
}
