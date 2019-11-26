package ddocdoc.dao;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import ddocdoc.vo.ReviewVO;
import ddocdoc.mapper.CustomerMapper;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;
import ddocdoc.vo.PayVO;
import ddocdoc.vo.PharResVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;

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
			if(count == 0) {
				return 0;
			}
			System.out.println("다오에서 : " + count);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return count;
	}
	
	
	// 회원정보 수정
	@Override
	public int customerUpdate(CustomerVO customer) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).customerUpdate(customer);
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
	
	
	
	//회원 탈퇴
	@Override
	public int customerDelete(String cus_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).customerDelete(cus_num);
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
	
	
	
	// 처방전 보기
	@Override
	public PresVO presRealDetail(String hos_res_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		PresVO pres = null;
		try {
			pres = session.getMapper(CustomerMapper.class).presRealDetail(hos_res_num);
			if(pres == null) {
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return pres;
	}

	
	
	// 처방전 약 명세 조회 리스트
	@Override
	public List<PresDetailVO> cusPresDetailList(String pres_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		List<PresDetailVO> presDetail = null;
		try {
			presDetail = session.getMapper(CustomerMapper.class).cusPresDetailList(pres_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return presDetail;
	}
		
	// 처방전 약 명세 약 이름
	@Override
	public List<String> cusPresDetailMedName(String pres_num){
		SqlSession session = getSqlSessionFactory().openSession();
		List<String> list = null;
		try {
			list = session.getMapper(CustomerMapper.class).cusPresDetailMedName(pres_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	// 결제 하기
	@Override
	public int insertPay(PayVO pay) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).insertPay(pay);
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
	
	// 결제완료
	@Override
	public int updatePay(String pres_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).updatePay(pres_num);
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
	
	// 처방전 결제 여부 추출
	@Override
	public String selectPayCheck(String pres_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		String check = null;
		try {
			check = session.getMapper(CustomerMapper.class).selectPayCheck(pres_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return check;
	}
	
	
	// 약 가격 추출
	@Override
	public int selectPayPrice(String hos_res_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		int price = 0;
		try {
			price = session.getMapper(CustomerMapper.class).selectPayPrice(hos_res_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return price;
	}

	//약국번호불러오기
	@Override
	public String selectPharNum(String phar_name) {
		SqlSession session = getSqlSessionFactory().openSession();
		String phar_num = null;
		try {
			phar_num = session.getMapper(CustomerMapper.class).selectPharNum(phar_name);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return phar_num;
	}

	//약국 예약하기
	@Override
	public int insertPharRes(PharResVO pvo) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).insertPharRes(pvo);
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

	//약국 예약리스트
	@Override
	public List<PharResVO> pharResList(String cus_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		List<PharResVO> list = null;
		try {
			list = session.getMapper(CustomerMapper.class).pharResList(cus_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	// 약국 이름 추출
	@Override
	public List<String> detailNamePharmacy(String cus_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		List<String> list = null;
		try {
			list = session.getMapper(CustomerMapper.class).detailNamePharmacy(cus_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return list;
	}
	
	// 약국 예약 상세보기
	@Override
	public PharResVO pharResDetail(String phar_res_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		PharResVO res = null;
		try {
			res = session.getMapper(CustomerMapper.class).pharResDetail(phar_res_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return res;
	}
	
	
	// 약국 이름 추출
	@Override
	public String selectPharmacyName(String phar_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		String name = null;
		try {
			name = session.getMapper(CustomerMapper.class).selectPharmacyName(phar_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return name;
	}
	
	// 약국 대기번호 증가
	@Override
	public int increasePharResWait(String phar_res_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		int re = -1;
		try {
			re = session.getMapper(CustomerMapper.class).increasePharResWait(phar_res_num);
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
	
	// 약국 대기번호 조회
	@Override
	public int detailPharWait(String phar_num) {
		SqlSession session = getSqlSessionFactory().openSession();
		int count = 0;
		try {
			count = session.getMapper(CustomerMapper.class).detailPharWait(phar_num);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(session != null) {
				session.close();
			}
		}
		return count;
	}
	
	//review create
	@Override
		public int reviewInsert(ReviewVO ReviewVO) {
			System.out.println(ReviewVO);
			int re = -1;
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			
			try {
				System.out.println("ok");
				re = sqlSession.getMapper(CustomerMapper.class).reviewInsert(ReviewVO);
				
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
		
		//review detail
		@Override
		public ReviewVO reviewDetail(String rv_num) {
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			ReviewVO reviewvo = null;
			try {
				reviewvo = sqlSession.getMapper(CustomerMapper.class).reviewDetail(rv_num);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(sqlSession !=null) {
					sqlSession.close();
				}
			}
			return reviewvo;
		}
		
		//review list
		@Override
		public List<ReviewVO> reviewList(String cus_num){
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			List<ReviewVO> list = null;
			
			try {
				list = sqlSession.getMapper(CustomerMapper.class).reviewList(cus_num);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(sqlSession != null) {
					sqlSession.close();
				}
			}
			return list;
		}
		
		//review update
		@Override
		public int reviewUpdate(ReviewVO ReviewVO) {
			int re =-1;
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			
			try {
				re = sqlSession.getMapper(CustomerMapper.class).reviewUpdate(ReviewVO);
				
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
				if(sqlSession !=null) {
					sqlSession.close();
				}
			}
			
			return re;
		}
		
		
		
		//review delete
		@Override
		public int reviewDelete(String rv_num) {
			int re = -1;
			SqlSession sqlSession = getSqlSessionFactory().openSession();
			
			try {
				re = sqlSession.getMapper(CustomerMapper.class).reviewDelete(rv_num);
				
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
		
		
		// 조회 수 증가
		@Override
		public int increaseHits(String rv_num) {
			SqlSession session = getSqlSessionFactory().openSession();
			int re = -1;
			try {
				re = session.getMapper(CustomerMapper.class).increaseHits(rv_num);
				if(re>0) {
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
		
		// 게시글 조회 수 조회
		@Override
		public int detailHits(String rv_num) {
			SqlSession session = getSqlSessionFactory().openSession();
			int count = 0;
			try {
				count = session.getMapper(CustomerMapper.class).detailHits(rv_num);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(session != null) {
					session.close();
				}
			}
			return count;
		}
		
		// 예약 접수 확인
		@Override
		public String checkResAcpt(String hos_res_num) {
			SqlSession session = getSqlSessionFactory().openSession();
			String check = null;
			try {
				check = session.getMapper(CustomerMapper.class).checkResAcpt(hos_res_num);
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				if(session != null) {
					session.close();
				}
			}
			return check;
		}
	
}
