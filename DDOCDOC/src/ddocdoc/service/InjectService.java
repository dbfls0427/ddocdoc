package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.ChildHeightVO;
import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public interface InjectService {

	//접종추천내역 불러오기
	List<InjectInfoVO> selectInjInfo();
	
	//접종한기록 불러오기
	List<String> selectInjList(HttpServletRequest request);
	
	//접종 기록하기
	int insertInj(HttpServletRequest request);
	
	//접종 내역상세
	ChildInjectVO selectInjDetail(HttpServletRequest request);
	
	//접종 내역 수정
	int updateInj(HttpServletRequest request);
	
	//접종 내역 삭제
	int deleteInj(HttpServletRequest request);
	
	//접종기록 갯수
	int injCount(HttpServletRequest request);
	
	//전체갯수
	int injTotal(HttpServletRequest request);
}
