<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>

	<form action="customerMypageUpdate.do" method="post">
		<input type = "hidden" name = "cus_num" value="${cus_num }"><br>
		아이디 : ${cus_id }<br>
		비밀 번호 : <input type = "text" name = "cus_pw"><br>
		이름 : <input type = "text" name = "cus_name"><br>
		주소 : <input type = "text" name = "cus_addr"><br>
		이메일 : <input type = "text" name = "cus_email"><br>
		생년 월일 : <input type = "text" name = "cus_birth"><br>
		<input type = "submit" value = "수정">
	
	</form>


</body>
</html>