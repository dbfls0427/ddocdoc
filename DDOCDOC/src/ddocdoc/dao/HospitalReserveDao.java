package ddocdoc.dao;

import ddocdoc.vo.HospitalReserveVO;

public interface HospitalReserveDao {

	//�����ϱ�
	public int insertHosRes(HospitalReserveVO hvo);
	
	//���� ��ȣ ��������
	public String hosNum(String hos_name);
}
