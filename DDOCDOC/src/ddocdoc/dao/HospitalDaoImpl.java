package ddocdoc.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.CustomerMapper;
import ddocdoc.mapper.HospitalMapper;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;

public class HospitalDaoImpl implements HospitalDao{
	private static HospitalDaoImpl dao = new HospitalDaoImpl();
	
	public static HospitalDaoImpl getInstance() {
		return dao;
	}
	
	//SqlSession ����
	public SqlSessionFactory getSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	// ���� ���� ���	
	public int hospitalInsert(HospitalVO HospitalVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalInsert(HospitalVO);
			if(re>0) {
				sqlSession.commit();
				System.out.println("����������� ����!");
			}else {
				sqlSession.rollback();
				System.out.println("����������� ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	// ���� ���� ������
	public HospitalVO hospitalDetail(String hos_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		HospitalVO hospitalvo = null;
		
		try {
			hospitalvo = sqlSession.getMapper(HospitalMapper.class).hospitalDetail(hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return hospitalvo;
	}
	
	// ���� ���� ����Ʈ
	public List<HospitalVO> hospitalList(){
		SqlSession sqlSession = getSessionFactory().openSession();
		List<HospitalVO> list = null;
		try {
			list = sqlSession.getMapper(HospitalMapper.class).hospitalList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	// ���� ���� ����	
	public int hospitalUpdate(HospitalVO HospitalVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalUpdate(HospitalVO);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("������������ ����!");
			}else {
				sqlSession.rollback();
				System.out.println("������������ ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	// ���� ���� ����
	public int hospitalDelete(String hos_num) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalDelete(hos_num);
			if(re>0) {
				sqlSession.commit();
				System.out.println("������������ ����!");
			}else {
				sqlSession.rollback();
				System.out.println("������������ ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	// ���� ���� ȯ�� ����Ʈ
	@Override
	public List<HospitalResVO> hosResList(String hos_num) {
		SqlSession slqSession = getSessionFactory().openSession();
		List<HospitalResVO> list = null;
		
		try {
			list = slqSession.getMapper(HospitalMapper.class).hosResList(hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(slqSession != null) {
				slqSession.close();
			}
		}
		
		return list;
	}

	// ���� ȯ�� �̸� ����
	/*
	@Override
	public List<CustomerVO> hosResNameCustomer(String cus_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		List<CustomerVO> list = null;
		
		try {
			list = sqlSession.getMapper(HospitalMapper.class).hosResNameCustomer(cus_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
				
		return list;
	}
	*/
	
	// ���� ���� ����
	@Override
	public int booleanHosRes(HospitalResVO HosResVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).booleanHosRes(HosResVO);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("������������ ����!");
			}else {
				sqlSession.rollback();
				System.out.println("������������ ����");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	
	
	 
	
}
