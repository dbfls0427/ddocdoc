<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>키 : ${height.he_height }</h1>
	<br><br>
	<button><a href="updateHeightForm.do?he_num=${height.he_num }&ch_num=${height.ch_num}">수정</a></button>
	<button><a href="deleteHeight.do?he_num=${height.he_num }">삭제</a></button>

</body>
</html>