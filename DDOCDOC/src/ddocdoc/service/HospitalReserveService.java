package ddocdoc.service;

import ddocdoc.vo.HospitalReserveVO;

public interface HospitalReserveService {

	//�����ϱ�
	public int insertHosRes(HospitalReserveVO hvo);
		
	//���� ��ȣ ��������
	public String hosNum(String hos_name);
}
