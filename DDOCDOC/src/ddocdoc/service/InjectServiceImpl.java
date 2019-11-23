package ddocdoc.service;

import java.sql.Date;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.catalina.connector.Request;

import ddocdoc.dao.InjectDao;
import ddocdoc.dao.InjectDaoImpl;
import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.InjectInfoVO;

public class InjectServiceImpl implements InjectService {

	private static InjectServiceImpl service = new InjectServiceImpl();
	private static InjectDao dao;
	
	public static InjectServiceImpl getInstance() {
		dao = new InjectDaoImpl().getInstance();
		return service;
	}
	
	//접종 추천내역 불러오기
	@Override
	public List<InjectInfoVO> selectInjInfo() {
		return dao.selectInjInfo();
	}

	//접종한 기록 불러오기
	@Override
	public List<String> selectInjList(HttpServletRequest request) {
		String ch_num = request.getParameter("ch_num");
		
		return dao.selectInjList(ch_num);
	}

	//접종 기록하기
	@Override
	public int insertInj(HttpServletRequest request) {
		ChildInjectVO civo = new ChildInjectVO();
		civo.setInj_content(request.getParameter("inj_content"));
		civo.setInj_date(Date.valueOf(request.getParameter("inj_date")));
		civo.setInj_memo(request.getParameter("inj_memo"));
		civo.setCh_num(request.getParameter("ch_num"));
		
		return dao.insertInj(civo);
	}
	
	//접종내역 상세보기
	@Override
	public ChildInjectVO selectInjDetail(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		String inj_content = request.getParameter("inj_content");
		String ch_num = request.getParameter("ch_num");
		map.put("inj_content", inj_content);
		map.put("ch_num", ch_num);
		
		return dao.selectInjDetail(map);
	}

	//접종 내역 수정
	@Override
	public int updateInj(HttpServletRequest request) {
		ChildInjectVO civo = new ChildInjectVO();
		
		String inj_content = request.getParameter("inj_content");
		String ch_num = request.getParameter("ch_num");
		String inj_memo = request.getParameter("inj_memo");
		
		civo.setCh_num(ch_num);
		civo.setInj_content(inj_content);
		civo.setInj_date(Date.valueOf(request.getParameter("inj_date")));
		civo.setInj_memo(inj_memo);
		
		return dao.updateInj(civo);
	}

	@Override
	public int deleteInj(HttpServletRequest request) {
		HashMap<String, String> map = new HashMap<String, String>();
		
		String inj_content = request.getParameter("inj_content");
		String ch_num = request.getParameter("ch_num");
		map.put("inj_content", inj_content);
		map.put("ch_num", ch_num);
		
		return dao.deleteInj(map);
	}

	@Override
	public int injCount(HttpServletRequest request) {
		String ch_num = request.getParameter("ch_num");
		
		return dao.injCount(ch_num);
	}

	@Override
	public int injTotal(HttpServletRequest request) {
		String ch_num = request.getParameter("ch_num");
		
		return dao.injTotal(ch_num);
	}


}
