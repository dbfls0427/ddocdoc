<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
String cus_num = request.getParameter("customer.cus_num");
out.println(cus_num);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>똑닥</title>
</head>
<body>
<h3>아이정보수정</h3>

<form action="/DDOCDOC/child/childUpdate.do" method="post">
	<input type="hidden" name="cus_num" value="${customer.cus_num }"><br>
	아이이름: <input type="text" name="ch_name"><br>
	아이나이: <input type="text" name="ch_age"><br>
	아이생일: <input type="text" name="ch_birth" placeholder="YY/MM/DD"><br>
	아이성별: <input type="text" name="ch_gender"><br>
	<input type="submit" value="저장">
</form>
</body>
</html>