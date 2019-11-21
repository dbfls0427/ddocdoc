package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;


public interface HospitalService {
	
	// 병원정보 등록 서비스
	public int hospitalInsert(HttpServletRequest request) throws Exception;
	
	// 병원정보 상세보기 서비스
	public HospitalVO hospitalDetail(String hos_num);
	
	// 병원 정보 리스트 서비스
	public List<HospitalVO> hospitalList();
	
	// 병원 정보 수정	 서비스
	public int hospitalUpdate(HttpServletRequest request)throws Exception;
	
	// 병원 정보 삭제 서비스
	public int hospitalDelete(String hos_num);
	
	// 병원 예약 환자 리스트
	public List<HospitalResVO> hosResList(String hos_num);
	
	// 예약 환자 이름 추출
	//public List<CustomerVO> hosResNameCustomer(HttpServletRequest request)throws Exception;
	
	// 병원 예약 접수
	public int booleanHosRes(HttpServletRequest request)throws Exception;
}
