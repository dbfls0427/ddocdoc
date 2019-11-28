package ddocdoc.mapper;

import java.util.List;

import ddocdoc.vo.ReviewVO;

public interface ReviewMapper {
	
	//review create
	int reviewInsert(ReviewVO ReviewVO);
	
	//review detail
	ReviewVO reviewDetail(String rv_num);
	
	//review info list
	List<ReviewVO> reviewList();
	
	//review update
	int reviewUpdate(ReviewVO ReviewVO);
	
	//review delete
	int reviewDelete(String rv_num);

} 
