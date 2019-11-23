package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public interface InjectService {

	//접종추천내역 불러오기
	List<InjectInfoVO> selectInjInfo();
	
	//접종한기록 불러오기
	List<String> selectInjList(HttpServletRequest request);
}
