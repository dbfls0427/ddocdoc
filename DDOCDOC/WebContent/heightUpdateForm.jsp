<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<form action="updateHeight.do" method="post">
		<input type="hidden" name="he_num" value="${he_num }">
		<input type="text" name="he_height"><br><br>
		<input type="submit" value="수정하기">
	</form>
</body>
</html>