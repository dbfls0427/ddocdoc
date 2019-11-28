<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>후기 수정</h1>
<form action="/DDOCDOC/review/reviewUpdate.do" method="post">
  	후기번호<input type="text" value="${reviewvo.rv_num}" name="rv_num"><br>
  	제목<input type="text" value="${reviewvo.rv_title }" name="rv_title"><br>
  	작성자<input type="text" value="${reviewvo.rv_writer }" name="rv_writer"><br>
  	내용<textarea row="5" cols="13" name="rv_content">${reviewvo.rv_content }</textarea>
  	


	<input type="submit" value="저장">
	<a href="/DDOCDOC/review/reviewList.do">목록</a><br>

</form>

</body>
</html>