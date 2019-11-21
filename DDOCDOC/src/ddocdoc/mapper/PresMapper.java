package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.PresVO;

public interface PresMapper {
	// 처방전 등록
	int hospitalInsert(PresVO PresVO);
	
	// 고객 리스트
	List<CustomerVO> customerList();
}
