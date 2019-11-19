package ddocdoc.dao;

import java.io.InputStream;
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
	
	//db준비
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
	
	//아이번호 가져오기
	@Override
	public String selectChildNum(String cus_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		String ch_num="";
		try {
			ch_num = sqlSession.getMapper(ChildHeightMapper.class).selectChildNum(cus_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return ch_num;
	}

	//아이키 등록
	@Override
	public int insertChildHeight(ChildHeightVO chvo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ChildHeightMapper.class).insertChildHeight(chvo);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("키등록 성공");
			}else {
				sqlSession.rollback();
				System.out.println("키등록 실패");
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

}
