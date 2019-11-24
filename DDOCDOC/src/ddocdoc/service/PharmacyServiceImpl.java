package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.dao.PharmacyDao;
import ddocdoc.dao.PharmacyDaoImpl;
import ddocdoc.vo.PharmacyVO;


public class PharmacyServiceImpl implements PharmacyService{
	private static PharmacyServiceImpl service = new PharmacyServiceImpl();
	private static PharmacyDao dao;
	
	
	
	public static PharmacyServiceImpl getInstance() {
		dao = PharmacyDaoImpl.getInstance();
		return service;
	}
	
	
	
	// pharmacy create
	public int pharmacyInsert(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		 
		PharmacyVO PharmacyVO = new PharmacyVO();
		 //PharmacyVO.setPhar_num(request.getParameter("phar_num"));
		PharmacyVO.setPhar_name(request.getParameter("phar_name"));
		PharmacyVO.setPhar_tel(request.getParameter("phar_tel"));
		PharmacyVO.setPhar_time(request.getParameter("phar_time"));
		PharmacyVO.setPhar_addr(request.getParameter("phar_addr"));
		PharmacyVO.setPhar_info(request.getParameter("phar_info"));
		 PharmacyVO.setPhar_wait(0);
		
		return dao.pharmacyInsert(PharmacyVO); 
	}
	
	//pharmacy detail 
	public PharmacyVO pharmacyDetail(String phar_num) {
		PharmacyVO pharmacyvo= dao.pharmacyDetail(phar_num);
		
		return pharmacyvo;
	}
	
	
	//pharmacy info list
	public List<PharmacyVO> pharmacyList(){
		return dao.pharmacyList();
	}
	
	
	//pharmacy update
	public int pharmacyUpdate(HttpServletRequest request)throws Exception{
		
		
		PharmacyVO pharmacyvo = new PharmacyVO();
		 pharmacyvo.setPhar_num(request.getParameter("phar_num")); 
		 pharmacyvo.setPhar_name(request.getParameter("phar_name"));
		 pharmacyvo.setPhar_tel(request.getParameter("phar_tel"));
		 pharmacyvo.setPhar_time(request.getParameter("phar_time"));
		 pharmacyvo.setPhar_addr(request.getParameter("phar_addr"));
		 pharmacyvo.setPhar_info(request.getParameter("phar_info"));
		
		 int re = dao.pharmacyUpdate(pharmacyvo);
		return re;
	}
	
	
	//pharmacy delete
	public int pharmacyDelete(String phar_num) {
		return dao.pharmacyDelete(phar_num);
	}



	
	
	
}