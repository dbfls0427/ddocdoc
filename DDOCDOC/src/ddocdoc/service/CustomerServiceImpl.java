package ddocdoc.service;

import java.util.HashMap;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.json.simple.JSONObject;

import ddocdoc.dao.CustomerDao;
import ddocdoc.dao.CustomerDaoImpl;
import ddocdoc.loginSession.LoginSession;
import ddocdoc.vo.ConfirmVO;
import ddocdoc.vo.CustomerVO;
import ddocdoc.vo.HospitalResVO;
import ddocdoc.vo.HospitalVO;
import ddocdoc.vo.LoginVO;
import ddocdoc.vo.PayVO;
import ddocdoc.vo.PharResVO;
import ddocdoc.vo.PresDetailVO;
import ddocdoc.vo.PresVO;
import ddocdoc.vo.ReviewVO;
import ddocdoc.service.Coolsms;

public class CustomerServiceImpl implements CustomerService {
	private static CustomerServiceImpl sc = new CustomerServiceImpl();
	private static CustomerDao dao;
	LoginSession session;// 로그인 세션 객체 생성
	ConfirmVO confirm = null;
	String confirmNum;

	public static boolean check = true;

	public static CustomerServiceImpl getInstance() {
		dao = CustomerDaoImpl.getInstance();
		return sc;
	}

	// 고객 회원가입
	@Override
	public int insertCustomer(CustomerVO customer) {
		return dao.insertCustomer(customer);
	}

	// 로그인 확인
	@Override
	public CustomerVO loginCustomer(HttpServletRequest request) {
		LoginVO login = new LoginVO();
		login.setLoginId(request.getParameter("customerID"));
		login.setLoginPw(request.getParameter("customerPW"));

		CustomerVO customer = dao.loginCustomer(login);

		if (customer != null) {
			session = new LoginSession();
			session.sessionInsert(request, customer);
		} else {
			return null;
		}

		return customer;

	}

	// 인증번호
	@Override
	public void confirmNumber() {
		Random rand = new Random();
		String numStr = "";

		for (int i = 0; i < 6; i++) {
			String ran = Integer.toString(rand.nextInt(10));
			numStr += ran;
		}

		sendSMS(numStr, "01087327595");
		confirmNum = numStr;
		confirm = new ConfirmVO();
		confirm.setConfirmNum(confirmNum);
	}
	
	// get confirm
	@Override
	public ConfirmVO getConfirm(){
		
		return confirm;
	}
	
	

	// 대기번호 문자 인증
	@Override
	public void hospitalResSms(int count) {
		String resultCount = Integer.toString(count);
		sendSMS("고객님의 병원 대기번호는 " + resultCount + "번 입니다. 예약해주셔서 감사드립니다.", "01087327595");
	}

	// SMS
	public static void sendSMS(String msg, String phone) {
		String api_key = "NCS6LRSLFNTOFWIF";
		String api_secret = "A6SHXGJ6CYRMF4ADYZO0JFOS5SLZJERK";
		Coolsms coolsms = new Coolsms(api_key, api_secret);

		HashMap<String, String> set = new HashMap<String, String>();
		set.put("to", "01087327595");
		set.put("from", phone);
		set.put("text", msg);
		set.put("type", "sms");

		JSONObject result = coolsms.send(set);
		if ((Boolean) result.get("status") == true) {
			System.out.println("성공");
			System.out.println(result.get("group_id"));
			System.out.println(result.get("result_code"));
			System.out.println(result.get("result_message"));
			System.out.println(result.get("success_count"));
		} else {
			System.out.println("실패");
			System.out.println(result.get("code"));
			System.out.println(result.get("message"));
		}
	}

	// 병원 번호 출력
	@Override
	public String selectHosNum(String hos_name) {
		return dao.selectHosNum(hos_name);
	}

	// 병원 예약 입력
	@Override
	public int insertHospitalRes(HospitalResVO hospitalresVO) {
		return dao.insertHospitalRes(hospitalresVO);
	}

	// 예약 목록 리스트
	@Override
	public List<HospitalResVO> resList(String cus_num) {
		return dao.resList(cus_num);
	}

	// 병원 정보 추출
	@Override
	public HospitalVO detailHospital(String hos_num) {
		return dao.detailHospital(hos_num);
	}

	// 병원 이름 추출
	@Override
	public List<String> detailNameHospital(String cus_num) {
		return dao.detailNameHospital(cus_num);
	}

	// 예약 상세 정보
	@Override
	public HospitalResVO detailRes(String hos_res_num) {
		return dao.detailRes(hos_res_num);
	}

	// 예약 취소
	@Override
	public int deleteRes(String hos_res_num) {
		return dao.deleteRes(hos_res_num);
	}

	// 예약 취소 시 대기번호 감소
	@Override
	public int decreaseWait(String hos_num) {
		return dao.decreaseWait(hos_num);
	}

	// 대기번호 조회
	@Override
	public int detailWait(String hos_res_num) {
		return dao.detailWait(hos_res_num);
	}

	// 회원정보 수정
	@Override
	public int customerUpdate(CustomerVO customer) {
		return dao.customerUpdate(customer);
	}

	// 회원 탈퇴
	@Override
	public int customerDelete(String cus_num) {
		return dao.customerDelete(cus_num);
	}

	// 처방전 보기
	@Override
	public PresVO presRealDetail(String hos_res_num) {
		return dao.presRealDetail(hos_res_num);
	}

	// 처방전 약 명세 조회 리스트
	@Override
	public List<PresDetailVO> cusPresDetailList(String pres_num) {
		return dao.cusPresDetailList(pres_num);
	}

	// 처방전 약 명세 약 이름
	@Override
	public List<String> cusPresDetailMedName(String pres_num) {
		return dao.cusPresDetailMedName(pres_num);

	}

	// 결제 하기
	@Override
	public int insertPay(PayVO pay) {
		return dao.insertPay(pay);
	}

	// 결제완료
	@Override
	public int updatePay(String pres_num) {
		return dao.updatePay(pres_num);
	}

	// 처방전 결제 여부 추출
	@Override
	public String selectPayCheck(String pres_num) {
		return dao.selectPayCheck(pres_num);
	}

	// 약 가격 추출
	@Override
	public int selectPayPrice(String hos_res_num) {
		return dao.selectPayPrice(hos_res_num);
	}

	// 약국 번호 가져오기
	@Override
	public String selectPharNum(String phar_name) {
		return dao.selectPharNum(phar_name);
	}

	// 약국예약하기
	@Override
	public int insertPharRes(PharResVO pvo) {
		return dao.insertPharRes(pvo);
	}

	// 약국예약 리스트
	@Override
	public List<PharResVO> pharResList(String cus_num) {
		return dao.pharResList(cus_num);
	}

	// 약국 이름 가져오기
	@Override
	public List<String> detailNamePharmacy(String cus_num) {
		return dao.detailNamePharmacy(cus_num);
	}

	// 약국 예약 상세보기
	@Override
	public PharResVO presDetail(String phar_res_num) {
		return dao.pharResDetail(phar_res_num);
	}

	// 약국 이름 추출
	@Override
	public String selectPharmacyName(String phar_num) {
		return dao.selectPharmacyName(phar_num);
	}

	// 약국 대기번호 증가
	@Override
	public int increasePharResWait(String phar_res_num) {
		return dao.increasePharResWait(phar_res_num);
	}

	// 약국 대기번호 조회
	@Override
	public int detailPharWait(String phar_num) {
		return dao.detailPharWait(phar_num);
	}

	// review create
	@Override
	public int reviewInsert(HttpServletRequest request) throws Exception {
		request.setCharacterEncoding("utf-8");
		
		String cus_num = ((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_num();

		ReviewVO ReviewVO = new ReviewVO();

		ReviewVO.setRv_title(request.getParameter("rv_title"));
		ReviewVO.setRv_writer(((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_name());
		ReviewVO.setRv_content(request.getParameter("rv_content"));
		ReviewVO.setCus_num(cus_num);

		return dao.reviewInsert(ReviewVO);
	}

	// review detail
	@Override
	public ReviewVO reviewDetail(String rv_num) {
		ReviewVO reviewvo = dao.reviewDetail(rv_num);

		return reviewvo;
	}

	// review list
	@Override
	public List<ReviewVO> reviewList(String cus_num) {
		return dao.reviewList(cus_num);
	}

	// review update
	@Override
	public int reviewUpdate(HttpServletRequest request) throws Exception {

		ReviewVO reviewvo = new ReviewVO();
		reviewvo.setRv_num(request.getParameter("rv_num"));
		reviewvo.setRv_title(request.getParameter("rv_title"));
		reviewvo.setRv_writer(((CustomerVO)LoginSession.loginSession.getAttribute("customer")).getCus_name());
		reviewvo.setRv_content(request.getParameter("rv_content"));
		int re = dao.reviewUpdate(reviewvo);
		return re;
	}

	// review delete
	@Override
	public int reviewDelete(String rv_num) {
		return dao.reviewDelete(rv_num);
	}
	
	// 조회 수 증가
	@Override
	public int increaseHits(String rv_num) {
		return dao.increaseHits(rv_num);
	}
	
	// 게시글 조회 수 조회
	@Override
	public int detailHits(String rv_num) {
		return dao.detailHits(rv_num);
	}
	
	// 예약 접수 확인
	@Override
	public String checkResAcpt(String hos_res_num) {
		return dao.checkResAcpt(hos_res_num);
	}
	
	// 회원 상세정보
	@Override
	public CustomerVO customerDetail(String cus_num) {
		return dao.customerDetail(cus_num);
	}
}
