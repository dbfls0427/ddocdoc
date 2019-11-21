package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;

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
	int booleanHosRes(HospitalResVO HosResVO);
}
