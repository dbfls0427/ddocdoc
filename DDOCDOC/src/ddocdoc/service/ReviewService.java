package ddocdoc.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import ddocdoc.vo.ReviewVO;


public interface ReviewService {

	// review create
	public int reviewInsert(HttpServletRequest request)throws Exception;
	
	
	//review detail 
	public ReviewVO reviewDetail(String rv_num);
	
	//review info list
	public List<ReviewVO> reviewList();
	
	//review update
	public int reviewUpdate(HttpServletRequest request)throws Exception;

	//review delete
	public int reviewDelete(String rv_num);
	
	//review search
	public int reviewSeach(ReviewSeach);
} 
