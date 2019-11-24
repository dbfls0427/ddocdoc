<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>똑닥</title>
</head>
<body>
<h3> 약국 예약 상세보기 </h3>

	<table border = "1">
		<tr>
			<td>예약 번호</td>
			<td>예약 시간</td>
			<td>메모</td>
			<td>약국이름</td>
			<td>대기번호</td>
		</tr>
		<tr>
			<td>${res.phar_res_num }</td>
			<td>${res.phar_res_time }</td>
			<td>${res.phar_res_memo }</td>
			<td>${pharName }</td>
			<td>${phar_wait }</td>
		</tr>
	</table>

</body>
</html>