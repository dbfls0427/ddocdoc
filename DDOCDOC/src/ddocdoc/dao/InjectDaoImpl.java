package ddocdoc.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.HospitalMapper;
import ddocdoc.mapper.InjectMapper;
import ddocdoc.vo.ChildHeightVO;
import ddocdoc.vo.ChildInjectVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.InjectInfoVO;

public class InjectDaoImpl implements InjectDao {
	private static InjectDaoImpl dao = new InjectDaoImpl();
	
	public static InjectDaoImpl getInstance() {
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
	
	//���� ��õ���� �ҷ����� 
	@Override
	public List<InjectInfoVO> selectInjInfo() {
		SqlSession sqlSession = getSessionFactory().openSession();
		List<InjectInfoVO> list = null;
		try {
			list = sqlSession.getMapper(InjectMapper.class).selectInjInfo();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	//�����ѱ�� �ҷ�����
	@Override
	public List<String> selectInjList(String ch_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		List<String> injList = null;
		try {
			injList = sqlSession.getMapper(InjectMapper.class).selectInjList(ch_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return injList;
	}

	@Override
	public int insertInj(ChildInjectVO civo) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(InjectMapper.class).insertInj(civo);
			if(re>0) {
				sqlSession.commit();
				System.out.println("���� ��� ����");
			}else {
				sqlSession.rollback();
				System.out.println("���� ��� ����");
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

	//�������� ��
	@Override
	public ChildInjectVO selectInjDetail(HashMap<String, String> map) {
		SqlSession sqlSession = getSessionFactory().openSession();
		ChildInjectVO civo = new ChildInjectVO();
		try {
			civo = sqlSession.getMapper(InjectMapper.class).selectInjDetail(map);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return civo;
	}

	//�������� ����
	@Override
	public int updateInj(ChildInjectVO civo) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(InjectMapper.class).updateInj(civo);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("���� ���� �Ϸ�!");
			}else {
				sqlSession.rollback();
				System.out.println("���� ���� ����!");
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

	//���� ���� ����
	@Override
	public int deleteInj(HashMap<String, String> map) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(InjectMapper.class).deleteInj(map);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("���� ���� �Ϸ�!");
			}else {
				sqlSession.rollback();
				System.out.println("���� ���� ����!");
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
	
	//������ ����
	@Override
	public int injCount(String ch_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int count = -1;
		try {
			count = sqlSession.getMapper(InjectMapper.class).injCount(ch_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return count;
	}

	//��ü��������
	@Override
	public int injTotal(String ch_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int total = -1;
		try {
			total = sqlSession.getMapper(InjectMapper.class).injTotal(ch_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return total;
	}



}
