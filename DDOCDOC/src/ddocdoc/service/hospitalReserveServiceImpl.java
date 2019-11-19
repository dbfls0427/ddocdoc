package ddocdoc.service;

import ddocdoc.dao.CustomerDao;
import ddocdoc.dao.CustomerDaoImpl;
import ddocdoc.dao.HospitalReserveDao;
import ddocdoc.dao.HospitalReserveDaoImpl;
import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.HospitalReserveVO;

public class hospitalReserveServiceImpl implements HospitalReserveService{
	private static hospitalReserveServiceImpl service = new hospitalReserveServiceImpl();
	private static HospitalReserveDao dao;
	
	public static hospitalReserveServiceImpl getInstance() {
		dao = HospitalReserveDaoImpl.getInstance();
		return service;
	}
	

	@Override
	public int insertHosRes(HospitalReserveVO hvo) {
		return dao.insertHosRes(hvo);
	}

	@Override
	public String hosNum(String hos_name) {
		return dao.hosNum(hos_name);
	}

}
