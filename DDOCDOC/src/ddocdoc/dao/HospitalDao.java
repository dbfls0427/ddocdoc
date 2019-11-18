package ddocdoc.dao;

import java.util.List;

import ddocdoc.vo.HospitalVO;

public interface HospitalDao {
	// ���� ���� ���	
	public int hospitalInsert(HospitalVO HospitalVO);
	
	// ���� ���� ������
	public HospitalVO hospitalDetail(String hos_num);
	
	// ���� ���� ����Ʈ
	public List<HospitalVO> hospitalList();
	
	// ���� ���� ����	
	public int hospitalUpdate(HospitalVO HospitalVO);
	
	// ���� ���� ����
	public int hospitalDelete(String hos_num);
}
