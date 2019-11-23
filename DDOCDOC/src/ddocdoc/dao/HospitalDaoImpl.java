package ddocdoc.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.mapper.CustomerMapper;
import ddocdoc.mapper.HospitalMapper;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.HospitalWaitVO;
import ddocdoc.vo.MedicineVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

public class HospitalDaoImpl implements HospitalDao{
	private static HospitalDaoImpl dao = new HospitalDaoImpl();
	
	public static HospitalDaoImpl getInstance() {
		return dao;
	}
	
	//SqlSession ����
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
	
	// ���� ���� ���	
	public int hospitalInsert(HospitalVO HospitalVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalInsert(HospitalVO);
			if(re>0) {
				sqlSession.commit();
				System.out.println("����������� ����!");
			}else {
				sqlSession.rollback();
				System.out.println("����������� ����");
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
	
	// ���� ���� ������
	public HospitalVO hospitalDetail(String hos_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		HospitalVO hospitalvo = null;
		
		try {
			hospitalvo = sqlSession.getMapper(HospitalMapper.class).hospitalDetail(hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		
		return hospitalvo;
	}
	
	// ���� ���� ����Ʈ
	public List<HospitalVO> hospitalList(){
		SqlSession sqlSession = getSessionFactory().openSession();
		List<HospitalVO> list = null;
		try {
			list = sqlSession.getMapper(HospitalMapper.class).hospitalList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	// ���� ���� ����	
	public int hospitalUpdate(HospitalVO HospitalVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalUpdate(HospitalVO);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("������������ ����!");
			}else {
				sqlSession.rollback();
				System.out.println("������������ ����");
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
	
	// ���� ���� ����
	public int hospitalDelete(String hos_num) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalDelete(hos_num);
			if(re>0) {
				sqlSession.commit();
				System.out.println("������������ ����!");
			}else {
				sqlSession.rollback();
				System.out.println("������������ ����");
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
	
	// ���� ���� ȯ�� ����Ʈ
	@Override
	public List<HospitalResVO> hosResList(String hos_num) {
		SqlSession slqSession = getSessionFactory().openSession();
		List<HospitalResVO> list = null;
		
		try {
			list = slqSession.getMapper(HospitalMapper.class).hosResList(hos_num);
			for(int i = 0; i < list.size(); i++) {
				System.out.println("dao���� : " + list.get(i).getHos_res_num() + " " + list.get(i).getHos_acpt());
			}
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if(slqSession != null) {
				slqSession.close();
			}
		}
		
		return list;
	}

	// ���� ȯ�� �̸� ����
	/*
	@Override
	public List<CustomerVO> hosResNameCustomer(String cus_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		List<CustomerVO> list = null;
		
		try {
			list = sqlSession.getMapper(HospitalMapper.class).hosResNameCustomer(cus_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
				
		return list;
	}
	*/
	
	// ���� ���� ����
	@Override
	public int booleanHosRes(HospitalResVO HosResVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).booleanHosRes(HosResVO);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("������������ ����!");
			}else {
				sqlSession.rollback();
				System.out.println("������������ ����");
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
	
	
	// ����ȣ ����
	@Override
	public int increaseWait(String hos_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(HospitalMapper.class).increaseWait(hos_num);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
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
	 
	// ����ȣ ������ ����
	@Override
	public int insertWaitData(HospitalWaitVO waitVO) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(HospitalMapper.class).insertWaitData(waitVO);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
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
	
	// �ش� ���� ����ȣ �߱�
	@Override
	public int hospitalWait(String hos_num) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int count = 0;
		try {
			count = sqlSession.getMapper(HospitalMapper.class).hospitalWait(hos_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return count;
	}

	// �� ����Ʈ
	@Override
	public List<MedicineVO> medicineList() {
		SqlSession sqlSession = getSessionFactory().openSession();
		List<MedicineVO> list = null;
		
		try {
			list = sqlSession.getMapper(HospitalMapper.class).medicineList();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
				
		return list;
	}
	
	
	// ó���� �� �Է�
	@Override
	public int insertPreDetail(PresDetailVO presDetail) {
		SqlSession sqlSession = getSessionFactory().openSession();
		int re = -1;
		try {
			re = sqlSession.getMapper(HospitalMapper.class).insertPreDetail(presDetail);
			if(re>0) {
				sqlSession.commit();
			}else {
				sqlSession.rollback();
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
	
	// ó���� �� �� ����Ʈ
	@Override
	public List<PresDetailVO> presDetailList(String pres_num){
		SqlSession sqlSession = getSessionFactory().openSession();
		List<PresDetailVO> list = null;
		try {
			list = sqlSession.getMapper(HospitalMapper.class).presDetailList(pres_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}
	
	// ó���� �� �� �� �̸�
	@Override
	public List<String> presDetailMedName(String pres_num){
		SqlSession sqlSession = getSessionFactory().openSession();
		List<String> list = null;
		try {
			list = sqlSession.getMapper(HospitalMapper.class).presDetailMedName(pres_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return list;
	}

	// ó���� �Է�
	@Override
	public int insertPres(PresVO presVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).insertPres(presVO);
			if(re>0) {
				sqlSession.commit();
				System.out.println("ó������� ����!");
			}else {
				sqlSession.rollback();
				System.out.println("ó������� ����");
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
	
	// presDetail
	@Override
	public PresVO presDetail() {
		SqlSession sqlSession = getSessionFactory().openSession();
		PresVO pres = null;
		try {
			pres = sqlSession.getMapper(HospitalMapper.class).presDetail();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return pres;
	}
	
	
	
}
