package ddocdoc.service;

import java.sql.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.dao.HospitalDao;
import ddocdoc.dao.HospitalDaoImpl;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.HospitalWaitVO;
import ddocdoc.vo.MedicineVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

public class HospitalServiceImpl implements HospitalService {
	private static HospitalServiceImpl service = new HospitalServiceImpl();
	private static HospitalDao dao;
	
	public static HospitalServiceImpl getInstance() {
		dao = HospitalDaoImpl.getInstance();
		return service;
	}
	
	// �������� ��� ����
	public int hospitalInsert(HttpServletRequest request)throws Exception {
		request.setCharacterEncoding("utf-8");
		
		HospitalVO HospitalVO = new HospitalVO();
		HospitalVO.setHos_name(request.getParameter("hos_name"));
		HospitalVO.setHos_tel(request.getParameter("hos_tel"));
		HospitalVO.setHos_addr(request.getParameter("hos_addr"));
		HospitalVO.setHos_time(request.getParameter("hos_time"));
		HospitalVO.setHos_info(request.getParameter("hos_info"));
		HospitalVO.setHos_type(request.getParameter("hos_type"));
		
		// ����� ��ȣ: default:0		
		// int hos_wait = Integer.parseInt(request.getParameter("hos_wait"));
		// hospitalvo.setHos_wait(hos_wait);
		
		return dao.hospitalInsert(HospitalVO);
	}
	
	// �������� �󼼺��� ����
	public HospitalVO hospitalDetail(String hos_num) {
	    HospitalVO hospitalvo = dao.hospitalDetail(hos_num);
		
		return hospitalvo;
	}
	
	// ���� ���� ����Ʈ ����
	public List<HospitalVO> hospitalList(){
		return dao.hospitalList();
	}
	
	// ���� ���� ����	 ����
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
	
	// ���� ���� ���� ����
	public int hospitalDelete(String hos_num) {
		return dao.hospitalDelete(hos_num);
	}

	// ���� ���� ȯ�� ����Ʈ
	@Override
	public List<HospitalResVO> hosResList(String hos_num) {
		boolean check;
		
		List<HospitalResVO> list = dao.hosResList(hos_num);
		for(int i = 0; i <list.size(); i++) {
			System.out.println("���񽺿��� : " + list.get(i).getHos_res_num() + " " + list.get(i).getHos_acpt());
		}
		
		return list;
	}
	
	
/*
	// ���� ȯ�� �̸� ����
	@Override
	public List<CustomerVO> hosResNameCustomer(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		CustomerVO customerVO = new CustomerVO();
		
		String cus_num = request.getParameter("cus_num");
		customerVO.setCus_num(cus_num);
		customerVO.setCus_name(request.getParameter("cus_name"));
		return dao.hosResNameCustomer(cus_num);
	}
*/

	// ���� ���� ����
	@Override
	public int booleanHosRes(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		HospitalResVO hosres = new HospitalResVO();
		hosres.setHos_res_num(request.getParameter("hos_res_num"));
		int re = dao.booleanHosRes(hosres);
		
		return re;
	}
	

	

	
	
//	public int booleanHosRes(HttpServletRequest request)throws Exception; {
//		request.setCharacterEncoding("utf-8");
//		
//		HosResVO HosResVO = new HosResVO();
//		HosResVO.setHos_acpt(request.getParameter("hos_acpt"));
//				
//		
////		HospitalVO hospitalvo = new HospitalVO();
////		hospitalvo.setHos_name(request.getParameter("hos_name"));
////		hospitalvo.setHos_tel(request.getParameter("hos_tel"));
////		hospitalvo.setHos_addr(request.getParameter("hos_addr"));
////		hospitalvo.setHos_time(request.getParameter("hos_time"));
////		hospitalvo.setHos_info(request.getParameter("hos_info"));
////		hospitalvo.setHos_type(request.getParameter("hos_type"));
////		hospitalvo.setHos_num(request.getParameter("hos_num"));
//		int re = dao.booleanHosRes(HosResVO);
//				
//		return re;
//		
//		
//	}


	// ����ȣ ����
	@Override
	public int increaseWait(String hos_num) {
		return dao.increaseWait(hos_num);
	}
	
	// ����ȣ ������ ����
	@Override
	public int insertWaitData(HospitalWaitVO waitVO) {
		return dao.insertWaitData(waitVO);
	}
	
	// �ش� ���� ����ȣ �߱�
	@Override
	public int hospitalWait(String hos_num) {
			return dao.hospitalWait(hos_num);
		}
	
	// �� ����Ʈ ����
	@Override
	public List<MedicineVO> medicineList() {
		return dao.medicineList();
	}
	
	
	// ó���� �� �Է�
	@Override
	public int insertPreDetail(PresDetailVO presDetail) {
		return dao.insertPreDetail(presDetail);
	}
	
	
	// ó���� �� �� ����Ʈ
	@Override
	public List<PresDetailVO> presDetailList(String pres_num){
		return dao.presDetailList(pres_num);
	}
	
	// ó���� �� �� �� �̸�
	@Override
	public List<String> presDetailMedName(String pres_num){
		return dao.presDetailMedName(pres_num);
	}

	// ó���� �Է�
	@Override
	public int insertPres(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		PresVO presVO = new PresVO();
		presVO.setPres_num(request.getParameter("pres_num"));
		presVO.setHos_num(request.getParameter("hos_num"));
		presVO.setPres_count(3);
		presVO.setCus_num(request.getParameter("cus_num"));
		presVO.setHos_res_num(request.getParameter("hos_res_num"));
		
		return dao.insertPres(presVO);
	}
	
	// presDetail
	@Override
	public PresVO presDetail() {
		return dao.presDetail();
	}
	
	

}
