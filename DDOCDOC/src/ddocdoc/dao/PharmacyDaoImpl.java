package ddocdoc.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.PharmacyMapper;
import ddocdoc.vo.PharmacyVO;


public class PharmacyDaoImpl implements PharmacyDao{
	private static PharmacyDaoImpl dao = new PharmacyDaoImpl();
	
	public static PharmacyDaoImpl getInstance() {
		return dao;
	}
	
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
	
	//pharmacy create
	public int pharmacyInsert(PharmacyVO PharmacyVO) {
		int re = -1;
		SqlSession sqlSession = getSqlSessionFactory().openSession(); //sql session��ü ����
		
		try {
			re = sqlSession.getMapper(PharmacyMapper.class).pharmacyInsert(PharmacyVO); 
			
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
	
	// pharmacy detail
	public PharmacyVO pharmacyDetail(String phar_num) {
		SqlSession sqlSession = getSqlSessionFactory().openSession();
		PharmacyVO pharmacyvo = null;
		
		try {
			pharmacyvo = sqlSession.getMapper(PharmacyMapper.class).pharmacyDetail(phar_num);
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession !=null) {
				sqlSession.close();
			}
		}
		return pharmacyvo;
		
	}
	
	//pharmacy info list
		public List<PharmacyVO> pharmacyList(){
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			List<PharmacyVO> list = null;
			
			try {
				list = sqlSession.getMapper(PharmacyMapper.class).pharmacyList();
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(sqlSession != null) {
					sqlSession.close();
				}
			}
			
			return list;
		
		}
		
		//pharmacy update
		public int pharmacyUpdate(PharmacyVO PharmacyVO) {
			int re = -1;
			SqlSession sqlSession = getSqlSessionFactory().openSession(); 
			
			try {
				re = sqlSession.getMapper(PharmacyMapper.class).pharmacyUpdate(PharmacyVO); 
				
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
				if(sqlSession != null) {
					sqlSession.close();
				}
			}
			
			return re;
			
		}
		
		
		
	
		
		//pharmacy delete
		public int pharmacyDelete(String phar_num) {
			int re = -1;
			SqlSession sqlSession = getSqlSessionFactory().openSession(); 
			
			try {
				re = sqlSession.getMapper(PharmacyMapper.class).pharmacyDelete(phar_num); 
				
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
		


}
