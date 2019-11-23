package ddocdoc.mapper;

import java.util.HashMap;
import java.util.List;

import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public interface InjectMapper {

	//접종 추천내역 불러오기
	List<InjectInfoVO> selectInjInfo();

	//접종기록 불러오기
	List<String> selectInjList(String ch_num);
	
	//접종 기록하기
	int insertInj(ChildInjectVO civo);
	
	//접종내역 상세
	ChildInjectVO selectInjDetail(HashMap<String, String> map);
	
	//접종내역 수정
	int updateInj(ChildInjectVO civo);
	
	//접종 내역 삭제
	int deleteInj(HashMap<String, String> map);
	
	//접종률 가져오기
	int injCount(String ch_num);
	
	//전체 접종갯수 가져오기
	int injTotal(String ch_num);
}
