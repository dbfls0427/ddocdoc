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
			System.out.println("아이번호" + ch_num);
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

	//아이 키 리스트
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

	//아이 키 상세
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

	//아이 키 수정
	@Override
	public int updateChildHeight(ChildHeightVO chvo) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ChildHeightMapper.class).updateChildHeight(chvo);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("키 수정 성공");
			}else {
				sqlSession.rollback();
				System.out.println("키 수정 실패");
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

	//아이 키 삭제
	@Override
	public int deleteChildHeight(String he_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(ChildHeightMapper.class).deleteChildHeight(he_num);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("키 삭제 성공");
			}else {
				sqlSession.rollback();
				System.out.println("키 삭제 실패");
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

	//아이키 번호 가져오기
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

}
