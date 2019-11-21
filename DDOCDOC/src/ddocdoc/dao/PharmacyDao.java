package ddocdoc.dao;

import ddocdoc.vo.PharmacyVO;

import java.util.List;



public interface PharmacyDao {
	// pharmacy create
	public int pharmacyInsert(PharmacyVO PharmacyVo);
	
	
	//pharmacy detail
	public PharmacyVO pharmacyDetail(String phar_num);
	
	//pharmacy info list
	public List<PharmacyVO> pharmacyList();
	

	//pharmacy update
	public int pharmacyUpdate(PharmacyVO PharmacyVO);
	
	
	//pharmacy delete
	public int pharmacyDelete(String phar_num);
	
	
}
