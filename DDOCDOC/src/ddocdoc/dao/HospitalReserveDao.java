package ddocdoc.dao;

import ddocdoc.vo.HospitalReserveVO;

public interface HospitalReserveDao {

	//예약하기
	public int insertHosRes(HospitalReserveVO hvo);
	
	//병원 번호 가져오기
	public String hosNum(String hos_name);
}
