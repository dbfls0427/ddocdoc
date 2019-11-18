package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.dao.HospitalDao;
import ddocdoc.dao.HospitalDaoImpl;
import ddocdoc.vo.HospitalVO;

public class HospitalServiceImpl implements HospitalService {
	private static HospitalServiceImpl service = new HospitalServiceImpl();
	private static HospitalDao dao;
	
	public static HospitalServiceImpl getInstance() {
		dao = HospitalDaoImpl.getInstance();
		return service;
	}
	
	// 병원정보 등록 서비스
	public int hospitalInsert(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HospitalVO HospitalVO = new HospitalVO();
		HospitalVO.setHos_name(request.getParameter("hos_name"));
		HospitalVO.setHos_tel(request.getParameter("hos_tel"));
		HospitalVO.setHos_addr(request.getParameter("hos_addr"));
		HospitalVO.setHos_time(request.getParameter("hos_time"));
		HospitalVO.setHos_info(request.getParameter("hos_info"));
		HospitalVO.setHos_type(request.getParameter("hos_type"));
		
		// 대기자 번호: default:0		
		// int hos_wait = Integer.parseInt(request.getParameter("hos_wait"));
		// hospitalvo.setHos_wait(hos_wait);
		
		return dao.hospitalInsert(HospitalVO);
	}
	
	// 병원정보 상세보기 서비스
	public HospitalVO hospitalDetail(String hos_num) {
	    HospitalVO hospitalvo = dao.hospitalDetail(hos_num);
		
		return hospitalvo;
	}
	
	// 병원 정보 리스트 서비스
	public List<HospitalVO> hospitalList(){
		return dao.hospitalList();
	}
	
	// 병원 정보 수정	 서비스
	public int hospitalUpdate(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HospitalVO hospitalvo = new HospitalVO();
		hospitalvo.setHos_name(request.getParameter("hos_name"));
		hospitalvo.setHos_tel(request.getParameter("hos_tel"));
		hospitalvo.setHos_addr(request.getParameter("hos_addr"));
		hospitalvo.setHos_time(request.getParameter("hos_time"));
		hospitalvo.setHos_info(request.getParameter("hos_info"));
		hospitalvo.setHos_type(request.getParameter("hos_type"));
		hospitalvo.setHos_num(request.getParameter("hos_num"));
		int re = dao.hospitalUpdate(hospitalvo);
		return re;
		
	}
	// 병원 정보 삭제 서비스
	public int hospitalDelete(String hos_num) {
		return dao.hospitalDelete(hos_num);
	}
	
}
