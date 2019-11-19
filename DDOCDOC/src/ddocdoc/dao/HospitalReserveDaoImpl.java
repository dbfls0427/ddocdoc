package ddocdoc.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.HospitalReserveMapper;
import ddocdoc.vo.HospitalReserveVO;

public class HospitalReserveDaoImpl implements HospitalReserveDao{
	private static HospitalReserveDaoImpl dao = new HospitalReserveDaoImpl();
		
		public static HospitalReserveDaoImpl getInstance() {
			return dao;
		}
		
		//SqlSession ¿¬°á
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
	
	@Override
	public int insertHosRes(HospitalReserveVO hvo) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(HospitalReserveMapper.class).insertHosRes(hvo);
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
	public String hosNum(String hos_name) {
		SqlSession sqlSession = getSessionFactory().openSession();
		String name ="";
		try {
			name = sqlSession.getMapper(HospitalReserveMapper.class).hosNum(hos_name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return name;
	}

	
}
