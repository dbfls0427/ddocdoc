package ddocdoc.dao;

import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.CustomerMapper;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
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
	
	
	// �� ȸ������
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
	
	//�α��� Ȯ��
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
	
	
	//���� ��ȣ ���
	public String selectHosNum(String hos_name) {
		SqlSession session = getSqlSessionFactory().openSession();
		String hos_num = null;
		System.out.println("1. dao���� " + hos_name);
		hos_name = hos_name.trim();
		try {
			hos_num = session.getMapper(CustomerMapper.class).selectHosNum(hos_name);
			System.out.println("2. dao���� " + hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return hos_num;
	}
	
	//���� ���� �Է�
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
	

}
