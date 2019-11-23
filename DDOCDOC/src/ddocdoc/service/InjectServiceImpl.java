package ddocdoc.service;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

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
	
	//���� ��õ���� �ҷ�����
	@Override
	public List<InjectInfoVO> selectInjInfo() {
		return dao.selectInjInfo();
	}

	//������ ��� �ҷ�����
	@Override
	public List<String> selectInjList(HttpServletRequest request) {
		String ch_num = request.getParameter("ch_num");
		
		return dao.selectInjList(ch_num);
	}


}
