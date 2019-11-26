<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>후기 등록</h1>
<form action="reviewInsert.do" method="post">
	${customer.cus_num}<br>
	
	<input type="hidden" name="cus_num" value="C001"><br>
	<!-- cus_num request.setattribute해서 받아오기 -->
	
	리뷰제목<input type="text" name="rv_title"><br>
	작성자<input type="text" name="rv_writer"><br>
	내용<textarea rows="5" cols="13" name="rv_content"></textarea>
	
<!-- 	날짜<input type="date" id='currentDate' name="rv_date"><br>  -->
	<!-- 조회수<input type="text" name="rv_count"><br>   -->
		
	<input type="submit" value="저장">

</form>

</body>
</html>