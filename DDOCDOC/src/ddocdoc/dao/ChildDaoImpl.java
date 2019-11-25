package ddocdoc.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.ChildMapper;
import ddocdoc.vo.ChildVO;

public class ChildDaoImpl implements ChildDao {
	private static ChildDaoImpl dao = new ChildDaoImpl();
	
	public static ChildDaoImpl getInstance() {
		return dao;
	}
	
	//sqlSession 연결
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

	// 아이정보 등록
	@Override
	public int insertChild(ChildVO ChildVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(ChildMapper.class).insertChild(ChildVO);
			if(re>0) {
				sqlSession.commit();
				System.out.println("아이정보등록 성공!");
			}else {
				sqlSession.rollback();
				System.out.println("아이정보등록 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		
		
		return re;
	}

	// 아이정보 상세정보
	@Override
	public ChildVO childDetail(String ch_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		ChildVO childVO = null;
		
		try {
			childVO = sqlSession.getMapper(ChildMapper.class).childDetail(ch_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return childVO;
	}

	// 아이정보 리스트
	@Override
	public List<ChildVO> childList(String cus_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		List<ChildVO> list = null;
		
		try {
			list = sqlSession.getMapper(ChildMapper.class).childList(cus_num);
			System.out.println("cus_num Dao에서:"+cus_num);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	// 아이정보 수정
	@Override
	public int updateChild(ChildVO ChildVO) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		
		try {
			re = sqlSession.getMapper(ChildMapper.class).updateChild(ChildVO);
			if(re>0) {
				sqlSession.commit();
				System.out.println("아이정보수정 성공!");
			}else {
				sqlSession.rollback();
				System.out.println("아이정보수정 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return re;
	}

	// 아이정보 삭제
	@Override
	public int deleteChild(String ch_num) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(ChildMapper.class).deleteChild(ch_num);
			if(re>0) {
				sqlSession.commit();
				System.out.println("success delete");
			}else {
				sqlSession.rollback();
				System.out.println("fail delete");
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
