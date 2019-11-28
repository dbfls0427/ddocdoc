package ddocdoc.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.ReviewMapper;
import ddocdoc.vo.ReviewVO;

public class ReviewDaoImpl implements ReviewDao {
	private static ReviewDaoImpl dao = new ReviewDaoImpl();

	public static ReviewDaoImpl getInstance() {
		return dao;
	}
	
	public SqlSessionFactory getSqlsessionFactory() {
		String resource ="mybatis-config.xml";
		InputStream in = null;
		try {
			in = Resources.getResourceAsStream(resource);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return new SqlSessionFactoryBuilder().build(in);
	}
	
	//review create 
	public int reviewInsert(ReviewVO ReviewVO) {
		System.out.println(ReviewVO);
		int re = -1;
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		
		try {
			System.out.println("ok");
			re = sqlSession.getMapper(ReviewMapper.class).reviewInsert(ReviewVO);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("INSERT SUCCESS");
			}else {
				sqlSession.rollback();
				System.out.println("INSERT FAIL");
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
	
	//review detail
	public ReviewVO reviewDetail(String rv_num) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		ReviewVO reviewvo = null;
		try {
			reviewvo = sqlSession.getMapper(ReviewMapper.class).reviewDetail(rv_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return reviewvo;
	}
	
	//review list
	public List<ReviewVO> reviewList(){
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		List<ReviewVO> list = null;
		
		try {
			list = sqlSession.getMapper(ReviewMapper.class).reviewList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	//review update
	public int reviewUpdate(ReviewVO ReviewVO) {
		int re =-1;
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(ReviewMapper.class).reviewUpdate(ReviewVO);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("UPDATE SUCCESS");
			}else {
				sqlSession.rollback();
				System.out.println("UPDATE FAIL");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		
		return re;
	}
	
	
	
	//review delete
	public int reviewDelete(String rv_num) {
		int re = -1;
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(ReviewMapper.class).reviewDelete(rv_num);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("DELETE SUCCESS");
			}else {
				sqlSession.rollback();
				System.out.println("DELETE FAIL");
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
	
	//review search
	public int ReviewSearch(ReviewSearch search) {
		SqlSession sqlSession = getSqlsessionFactory().openSession();
		int re =0;
		try {
			re = sqlSession.getMapper(ReviewMapper.class).ReviewSearch(search);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			sqlSession.close();
		}
		
		return re;
	}
}
