package ddocdoc.mapper;

import ddocdoc.vo.HospitalReserveVO;

public interface HospitalReserveMapper {

	int insertHosRes(HospitalReserveVO hvo);
	
	String hosNum(String hos_name);
}
