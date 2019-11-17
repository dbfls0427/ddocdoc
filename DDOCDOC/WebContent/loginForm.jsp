<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<form action="login.do" method = "post">
		ID : <input type = "text" name = "customerID"><br>
		PW : <input type = "text" name = "customerPW"><br>
		<input type = "submit" value = "로그인">
		
	
	
	</form> <br>
	
	<form action="join.do" method = "post">
		<input type = "submit" value = "회원가입">
	</form>



</body>
</html>