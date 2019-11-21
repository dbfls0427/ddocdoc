package ddocdoc.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.CustomerMapper;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;

public class CustomerDaoImpl implements CustomerDao{
	private static CustomerDaoImpl dao = new CustomerDaoImpl();
	
	public static CustomerDaoImpl getInstance() {
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
	
	
	// 고객 회원가입
	@Override
	public int insertCustomer(CustomerVO customer) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).insertCustomer(customer);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
		
		
	}
	
	//로그인 확인
	@Override
	public CustomerVO loginCustomer(LoginVO login) {
		SqlSession session = getSqlSessionFactory().openSession();
		CustomerVO customer = null;
		try {
			customer = session.getMapper(CustomerMapper.class).loginCustomer(login);
			if(customer == null) {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return customer;
	}
	
	
	//병원 번호 출력
	@Override
	public String selectHosNum(String hos_name) {
		SqlSession session = getSqlSessionFactory().openSession();
		String hos_num = null;
		System.out.println("1. dao에서 " + hos_name);
		hos_name = hos_name.trim();
		try {
			hos_num = session.getMapper(CustomerMapper.class).selectHosNum(hos_name);
			System.out.println("2. dao에서 " + hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return hos_num;
	}
	
	//병원 예약 입력
	@Override
	public int insertHospitalRes(HospitalResVO hospitalresVO) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).insertHospitalRes(hospitalresVO);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	
	// 예약 목록 리스트
	@Override
	public List<HospitalResVO> resList(String cus_num){
		SqlSession session = getSqlSessionFactory().openSession();
		List<HospitalResVO> list = null;
		try {
			list = session.getMapper(CustomerMapper.class).resList(cus_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
		
	}
	
	// 병원 정보 추출
	@Override
	public HospitalVO detailHospital(String hos_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		HospitalVO hos = null;
		try {
			hos = session.getMapper(CustomerMapper.class).detailHospital(hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return hos;
	}
	
	//병원 이름 추출
	@Override
	public List<String> detailNameHospital(String cus_num){
		SqlSession session = getSqlSessionFactory().openSession();
		List<String> list = null;
		try {
			list = session.getMapper(CustomerMapper.class).detailNameHospital(cus_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	
	// 예약 상세 내용
	@Override
	public HospitalResVO detailRes(String hos_res_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		HospitalResVO res = null;
		try {
			res = session.getMapper(CustomerMapper.class).detailRes(hos_res_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return res;
	}
	
	// 예약 취소
	@Override
	public int deleteRes(String hos_res_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).deleteRes(hos_res_num);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}
	
	// 예약 취소할 때 대기번호 감소
	@Override
	public int decreaseWait(String hos_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).decreaseWait(hos_num);
			if(re > 0) {
				session.commit();
			}else {
				session.rollback();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return re;
	}

	// 대기번호 조회
	@Override
	public int detailWait(String hos_res_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		int count = 0;
		try {
			count = session.getMapper(CustomerMapper.class).detailWait(hos_res_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return count;
	}

}
