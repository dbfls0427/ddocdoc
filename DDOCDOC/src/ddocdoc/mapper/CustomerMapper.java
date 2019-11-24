package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;
import ddocdoc.vo.PayVO;
import ddocdoc.vo.PharResVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

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
	
	// 처방전 보기
	PresVO presRealDetail(String hos_res_num);
	
	// 처방전 약 명세 조회 리스트
	List<PresDetailVO> cusPresDetailList(String pres_num);
	
	// 처방전 약 명세 약 이름
	List<String> cusPresDetailMedName(String pres_num);
	
	// 결제 하기
	int insertPay(PayVO pay);
	
	// 결제완료
	int updatePay(String pres_num);
	
	// 처방전 결제 여부 추출
	String selectPayCheck(String pres_num);
	
	// 약 가격 추출
	int selectPayPrice(String hos_res_num);
	
	//약국 번호 출력
	String selectPharNum(String phar_name);
	
	//약국 예약하기
	int insertPharRes(PharResVO pvo);
	
	//약국 예약 리스트
	List<PharResVO> pharResList(String cus_num);
	
	//약국 이름 가져오기
	List<String> detailNamePharmacy(String cus_num);
}
