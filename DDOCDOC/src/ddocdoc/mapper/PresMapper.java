package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.PresVO;

public interface PresMapper {
	// ó���� ���
	int hospitalInsert(PresVO PresVO);
	
	// �� ����Ʈ
	List<CustomerVO> customerList();
}
