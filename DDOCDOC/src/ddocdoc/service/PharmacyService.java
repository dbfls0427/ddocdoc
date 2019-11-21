package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.PharmacyVO;

public interface PharmacyService {
	// pharmacy create
	public int pharmacyInsert(HttpServletRequest request)throws Exception;
	
	
	//pharmacy detail 
	public PharmacyVO pharmacyDetail(String phar_num);
	
	//pharmacy info list
	public List<PharmacyVO> pharmacyList();
	
	//pharmacy update
	public int pharmacyUpdate(HttpServletRequest request)throws Exception;

	//pharmacy delete
	public int pharmacyDelete(String phar_num);

	

	
}
