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
	
	//SqlSession 연결
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
	
	//접종 추천내역 불러오기 
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

	//접종한기록 불러오기
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
				System.out.println("접종 등록 성공");
			}else {
				sqlSession.rollback();
				System.out.println("접종 등록 실패");
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

	//접종내역 상세
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

	//접종내역 수정
	@Override
	public int updateInj(ChildInjectVO civo) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(InjectMapper.class).updateInj(civo);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("접종 수정 완료!");
			}else {
				sqlSession.rollback();
				System.out.println("접종 수정 실패!");
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

	//접종 내역 삭제
	@Override
	public int deleteInj(HashMap<String, String> map) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(InjectMapper.class).deleteInj(map);
			
			if(re > 0) {
				sqlSession.commit();
				System.out.println("접종 삭제 완료!");
			}else {
				sqlSession.rollback();
				System.out.println("접종 삭제 실패!");
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
	
	//접종한 갯수
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

	//전체접종갯수
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
