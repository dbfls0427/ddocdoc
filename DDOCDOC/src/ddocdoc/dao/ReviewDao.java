package ddocdoc.dao;

import java.util.List;

import ddocdoc.service.ReviewSearch;
import ddocdoc.vo.ReviewVO;

public interface ReviewDao {

	//review create
	public int reviewInsert(ReviewVO ReviewVo);
	
	//review detail
	public ReviewVO reviewDetail(String rv_num);
	
	//review list
	public List<ReviewVO> reviewList();
	
	//review update
	public int reviewUpdate(ReviewVO ReviewVO);
	
	//review delete
	public int reviewDelete(String rv_num);
	
	//review search
	public int ReviewSearch (ReviewSearch search);
}
   