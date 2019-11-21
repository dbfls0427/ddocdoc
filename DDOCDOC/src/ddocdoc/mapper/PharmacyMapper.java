package ddocdoc.mapper;

import ddocdoc.vo.PharmacyVO;

import java.util.List;
 
 
public interface PharmacyMapper {
	
	  // pharmacy create  
	  //pharmacy detail  
	  //pharmacy info list
	  //pharmacy update
	  //pharmacy delete
	    
 
 
    // pharmacy create
    int pharmacyInsert(PharmacyVO PharmacyVO);
 
    //pharmacy detail 
    PharmacyVO pharmacyDetail(String phar_num);
    
   //pharmacy info list
    List<PharmacyVO> pharmacyList();
    
   //pharmacy update 
    int pharmacyUpdate(PharmacyVO PharmacyVO);
    
    //pharmacy delete
    int pharmacyDelete(String phar_num);
   
}