package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.swing.ListModel;

import ddocdoc.dao.ReviewDao;
import ddocdoc.dao.ReviewDaoImpl;
import ddocdoc.vo.ReviewVO;

public class ReviewServiceImpl implements ReviewService{
	private static ReviewServiceImpl service = new ReviewServiceImpl();
	private static ReviewDao dao;
	private static final int PAGE_SIZE =2;
	
	public static ReviewServiceImpl getInstance() {
		dao = ReviewDaoImpl.getInstance();
		return service;
	}
	
	//review create
	public int reviewInsert(HttpServletRequest request)throws Exception{
		request.setCharacterEncoding("utf-8");
		
		ReviewVO ReviewVO = new ReviewVO();
		
		ReviewVO.setRv_title(request.getParameter("rv_title"));
		ReviewVO.setRv_writer(request.getParameter("rv_writer"));
		ReviewVO.setRv_content(request.getParameter("rv_content"));
		
		/*
		 * String date = request.getParameter("rv_date"); java.util.Date rvdate = new
		 * java.util.Date(date); java.sql.Date rv_date = new
		 * java.sql.Date(rvdate.getTime()); ReviewVO.setRv_date(rv_date);
		 */
		
		//ReviewVO.setRv_date(request.getParameter("rv_date"));
		
		return dao.reviewInsert(ReviewVO);
	}

	//review detail
	public ReviewVO reviewDetail(String rv_num) {
		ReviewVO reviewvo = dao.reviewDetail(rv_num);
		
		return reviewvo;
	}
	
	
	//review list
	public List<ReviewVO> reviewList(){
		return dao.reviewList();
	}
	
	//review update
	public int reviewUpdate(HttpServletRequest request)throws Exception{
		
		ReviewVO reviewvo = new ReviewVO();
			reviewvo.setRv_num(request.getParameter("rv_num"));
			reviewvo.setRv_title(request.getParameter("rv_title"));
			reviewvo.setRv_writer(request.getParameter("rv_writer"));
			reviewvo.setRv_content(request.getParameter("rv_content"));
		int re = dao.reviewUpdate(reviewvo);
		return re;
	}
	
	//review delete
	public int reviewDelete(String rv_num) {
		return dao.reviewDelete(rv_num);
	} 
	
	//search
	public void reviewListModel(HttpServletRequest request)throws Exception{
		ReviewSearch search = new ReviewSearch();
		HttpSession session = request.getSession(); //검색정보
		
		//검색할 경우(검색버튼 클릭)
		if(request.getParameterValues("area")!=null) {
			session.removeAttribute("search");
			search.setArea(request.getParameterValues("area"));
			search.setSearchKey("%"+request.getParameter("searchKey")+"%");
			session.setAttribute("search", search);
		}	
		
		//검색 후 페이지를 클릭
		else if(session.getAttribute("search")!= null) {
			search = (ReviewSearch)session.getAttribute("search");
		}
		
		//페이징 처리 로직
		
		//총글갯수
		int totalCount = dao.ReviewSearch(search);
		
		//총페이지수
		int totalPageCount = totalCount/PAGE_SIZE;
		if(totalCount%PAGE_SIZE > 0) {
			totalPageCount++;
		}
		
		//현재페이지
		String pageNum = request.getParameter("pageNum");
		if(pageNum == null) {
			pageNum = "1";
		}
		int requestPage = Integer.parseInt(pageNum);
		
		//startPage
		//startPage = 현재페이지 -(현재페이지 -1)%5
		int startPage = requestPage -(requestPage -1) % 5;
		
		//endPage
		int endPage = startPage + 4;
		if(endPage > totalPageCount) {
			endPage = totalPageCount;
		}
		
		//startRow
		//startRow = (현재페이지 -1)* 페이지당 글갯수
		int startRow = (requestPage -1) * PAGE_SIZE;
		
		List<ReviewVO> list = dao.reviewList(search, startRow);
		ListModel listModel = new ListModel(list, requestPage, totalPageCount, startPage, endPage);
		return reviewList;
	}

	@Override
	public int reviewSeach() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}