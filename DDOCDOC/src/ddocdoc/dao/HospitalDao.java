package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.HospitalWaitVO;
import ddocdoc.vo.MedicineVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

public interface HospitalDao {
	// 병원 정보 등록	
	public int hospitalInsert(HospitalVO HospitalVO);
	
	// 병원 정보 상세정보
	public HospitalVO hospitalDetail(String hos_num);
	
	// 병원 정보 리스트
	public List<HospitalVO> hospitalList();
	
	// 병원 정보 수정	
	public int hospitalUpdate(HospitalVO HospitalVO);
	
	// 병원 정보 삭제
	public int hospitalDelete(String hos_num);
	
	// 병원 예약 환자 리스트
	public List<HospitalResVO> hosResList(String hos_num);
	
	// 예약 환자 이름 추출
	//List<CustomerVO> hosResNameCustomer(String cus_num);
	
	// 병원 예약 접수
	public int booleanHosRes(HospitalResVO HosResVO);
	
	// 대기번호 증가
	public int increaseWait(String hos_num);
	
	// 대기번호 데이터 저장
	public int insertWaitData(HospitalWaitVO waitVO);
	
	// 해당 병원 대기번호 발급
	public int hospitalWait(String hos_num);
	
	// 약 리스트
	public List<MedicineVO> medicineList();
	
	// 처방전 명세 입력
	public int insertPreDetail(PresDetailVO presDetail);
	
	// 처방전 약 명세 리스트
	public List<PresDetailVO> presDetailList(String pres_num);
	
	// 처방전 약 명세 약 이름
	public List<String> presDetailMedName(String pres_num);
	
	// 처방전 입력
	public int insertPres(PresVO presVO);
	
	// presDetail
	public PresVO presDetail();
	
}
