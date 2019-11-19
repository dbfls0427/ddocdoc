<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="joinAction.do" method = "post">
		ID : <input type = "text" name = "joinID"><br>
		PW : <input type = "text" name = "joinPW"><br>
		이름 : <input type = "text" name = "joinName"><br>
		주소 : <input type = "text" name = "joinAddr"><br>
		이메일 : <input type = "text" name = "joinEmail"><br>
		생년월일 : <input type = "text" name = "joinBirth"><br>
		인증번호 : <input type = "text" name = "confirmNum">
		
		<input type = "submit" value = "가입">
		
	</form>
	
	<form action="confirm.do" method = "post">
	<input type = "submit" value = "인증번호 받기">
	
	</form>



</body>
</html>