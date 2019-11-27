<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td>병원번호</td>
			<td>병원종류</td>
			<td>병원이름</td>
		</tr>
		<c:forEach var="hospitalvo" items="${list}">
			<tr>
				<td>${hospitalvo.hos_num }</td>
				<td>${hospitalvo.hos_type }</td>
				<td><a
					href="/DDOCDOC/hospital/adminRes.do?hos_name=${hospitalvo.hos_name }&cus_num=${cus_num}">${hospitalvo.hos_name }</a></td>
			</tr>
		</c:forEach>
	</table>



</body>
</html>