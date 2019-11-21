<%@page import="ddocdoc.vo.HospitalVO"%>
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
<h3>병원정보 목록</h3>

<!--  
세션:
<p>${customer.cus_num }</p>
<p>${customer.cus_name }</p>
-->


<a href="/DDOCDOC/hospital/hospitalInsertForm.do">병원정보 입력</a><br>


<table border="1">
	<tr>
		<td>병원번호</td>
		<td>병원종류</td>
		<td>병원이름</td>
	</tr>
		
	
		<c:forEach var="hospitalvo" items="${list}">
			<tr>
				<tr>
				<td>${hospitalvo.hos_num }</td>
				<td>${hospitalvo.hos_type }</td>
				<td><a href="/DDOCDOC/hospital/hospitalDetail.do?seq=${hospitalvo.hos_num }">${hospitalvo.hos_name }</a></td>
		</c:forEach>


	</table>
	

</body>
</html>