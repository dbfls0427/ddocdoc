package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;
import ddocdoc.vo.PayVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

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
	
	// 예약 취소 시 대기번호 감소
	public int decreaseWait(String hos_num);
	
	// 대기번호 조회
	public int detailWait(String hos_res_num);
	
	// 회원정보 수정
	public int customerUpdate(CustomerVO customer);
	
	// 회원 탈퇴
	public int customerDelete(String cus_num);
	
	// 처방전 보기
	public PresVO presRealDetail(String hos_res_num);
	
	// 처방전 약 명세 조회 리스트
	public List<PresDetailVO> cusPresDetailList(String pres_num);
		
	// 처방전 약 명세 약 이름
	public List<String> cusPresDetailMedName(String pres_num);
	
	// 결제 하기
	public int insertPay(PayVO pay);
	
	// 결제완료
	public int updatePay(String pres_num);
	
	// 처방전 결제 여부 추출
	public String selectPayCheck(String pres_num);
	
	// 약 가격 추출
	public int selectPayPrice(String hos_res_num);
}
