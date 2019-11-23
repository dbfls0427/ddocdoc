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



}
