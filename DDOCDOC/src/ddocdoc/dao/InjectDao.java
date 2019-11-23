package ddocdoc.dao;

import java.util.HashMap;
import java.util.List;

import ddocdoc.vo.ChildHeightVO;
import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public interface InjectDao {

	//접종 추천내역 불러오기
	List<InjectInfoVO> selectInjInfo();

	//접종기록 불러오기
	List<String> selectInjList(String ch_num);
}
