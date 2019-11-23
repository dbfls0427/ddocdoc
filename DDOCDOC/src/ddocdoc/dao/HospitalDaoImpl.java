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
	
	// 병원 정보 등록	
	public int hospitalInsert(HospitalVO HospitalVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalInsert(HospitalVO);
			if(re>0) {
				sqlSession.commit();
				System.out.println("병원정보등록 성공!");
			}else {
				sqlSession.rollback();
				System.out.println("병원정복등록 실패");
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
	
	// 병원 정보 상세정보
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
	
	// 병원 정보 리스트
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
	
	// 병원 정보 수정	
	public int hospitalUpdate(HospitalVO HospitalVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalUpdate(HospitalVO);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("병원정보수정 성공!");
			}else {
				sqlSession.rollback();
				System.out.println("병원정복수정 실패");
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
	
	// 병원 정보 삭제
	public int hospitalDelete(String hos_num) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).hospitalDelete(hos_num);
			if(re>0) {
				sqlSession.commit();
				System.out.println("병원정보삭제 성공!");
			}else {
				sqlSession.rollback();
				System.out.println("병원정보삭제 실패");
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
	
	// 병원 예약 환자 리스트
	@Override
	public List<HospitalResVO> hosResList(String hos_num) {
		SqlSession slqSession = getSessionFactory().openSession();
		List<HospitalResVO> list = null;
		
		try {
			list = slqSession.getMapper(HospitalMapper.class).hosResList(hos_num);
			for(int i = 0; i < list.size(); i++) {
				System.out.println("dao에서 : " + list.get(i).getHos_res_num() + " " + list.get(i).getHos_acpt());
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

	// 예약 환자 이름 추출
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
	
	// 병원 예약 접수
	@Override
	public int booleanHosRes(HospitalResVO HosResVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).booleanHosRes(HosResVO);
			
			if(re>0) {
				sqlSession.commit();
				System.out.println("병원예약접수 성공!");
			}else {
				sqlSession.rollback();
				System.out.println("병원예약접수 실패");
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
	
	
	// 대기번호 증가
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
	 
	// 대기번호 데이터 저장
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
	
	// 해당 병원 대기번호 발급
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

	// 약 리스트
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
	
	
	// 처방전 명세 입력
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
	
	// 처방전 약 명세 리스트
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
	
	// 처방전 약 명세 약 이름
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

	// 처방전 입력
	@Override
	public int insertPres(PresVO presVO) {
		int re = -1;
		SqlSession sqlSession = getSessionFactory().openSession();
		
		try {
			re = sqlSession.getMapper(HospitalMapper.class).insertPres(presVO);
			if(re>0) {
				sqlSession.commit();
				System.out.println("처방전등록 성공!");
			}else {
				sqlSession.rollback();
				System.out.println("처방전등록 실패");
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
