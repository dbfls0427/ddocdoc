<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

로그인 성공!
<form action="logout.do" method="post">
	<input type = "submit" value="로그아웃">
</form>

${customer.cus_name }

<form action="detailCustomer.do" method = "post">
	<input type = "submit" value="회원 상세정보">
</form>

<form action = "hos_res.do" method = "post">
	<input type = "submit" value = "병원 예약">

</form>


</body>
</html>