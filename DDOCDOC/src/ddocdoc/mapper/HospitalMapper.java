package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.HospitalVO;

public interface HospitalMapper {
	// 병원 정보 등록 
	int hospitalInsert(HospitalVO HospitalVO);
	
	// 병원 정보 상세보기
	HospitalVO hospitalDetail(String hos_num);
	
	// 병원 정보 리스트
	List<HospitalVO> hospitalList();
	
	// 병원 정보 수정
	int hospitalUpdate(HospitalVO HospitalVO);
	
	// 병원 정보 삭제
	int hospitalDelete(String hos_num);
}
