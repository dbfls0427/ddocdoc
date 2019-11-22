package ddocdoc.dao;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.ChildHeightMapper;
import ddocdoc.vo.ChildHeightVO;

public class ChildHeightDaoImpl implements ChildHeightDao {

	private static ChildHeightDaoImpl dao = new ChildHeightDaoImpl();
	
	public static ChildHeightDaoImpl getInstance() {
		return dao;
	}
	
	//db�غ�
	public SqlSessionFactory getSqlSessionFactory() {
		String resource = "mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//���̹�ȣ ��������
	@Override
	public String selectChildNum(String cus_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String ch_num="";
		try {
			ch_num = sqlSession.getMapper(ChildHeightMapper.class).selectChildNum(cus_num);
			System.out.println("���̹�ȣ" + ch_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return ch_num;
	}

	//����Ű ���
	@Override
	public int insertChildHeight(ChildHeightVO chvo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ChildHeightMapper.class).insertChildHeight(chvo);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("Ű��� ����");
			}else {
				sqlSession.rollback();
				System.out.println("Ű��� ����");
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

	//���� Ű ����Ʈ
	@Override
	public List<ChildHeightVO> ChildHeightList(String ch_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		List<ChildHeightVO> list = null;
		try {
			list = sqlSession.getMapper(ChildHeightMapper.class).ChildHeightList(ch_num);
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return list;
	}

	//���� Ű ��
	@Override
	public ChildHeightVO detailChildHeight(String he_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		ChildHeightVO chvo = null;
		try {
			chvo = sqlSession.getMapper(ChildHeightMapper.class).detailChildHeight(he_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return chvo;
	}

	//���� Ű ����
	@Override
	public int updateChildHeight(ChildHeightVO chvo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ChildHeightMapper.class).updateChildHeight(chvo);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("Ű ���� ����");
			}else {
				sqlSession.rollback();
				System.out.println("Ű ���� ����");
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

	//���� Ű ����
	@Override
	public int deleteChildHeight(String he_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ChildHeightMapper.class).deleteChildHeight(he_num);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("Ű ���� ����");
			}else {
				sqlSession.rollback();
				System.out.println("Ű ���� ����");
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

	//����Ű ��ȣ ��������
	@Override
	public String selectHeNum(String ch_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String he_num = null;
		try {
			he_num = sqlSession.getMapper(ChildHeightMapper.class).selectHeNum(ch_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return he_num;
	}

	//ǥ�� Ű ��������
	@Override
	public Float selectStHeight(HashMap<String, String> map) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		Float st_height = null;
		
		System.out.println("dao������~~~~~~~~~~");
		System.out.println(map.get("gender_tb"));
		System.out.println(map.get("ch_num"));
		try {
			st_height = sqlSession.getMapper(ChildHeightMapper.class).selectStHeight(map);
			System.out.println("ǥ��Ű :>>>" + st_height);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return st_height;
	}

	//���� ���� ��������
	@Override
	public String selectGender(String ch_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String gender = null;
		
		try {
			gender = sqlSession.getMapper(ChildHeightMapper.class).selectGender(ch_num);
			System.out.println("���� :>>>" + gender);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return gender;
	}

}
