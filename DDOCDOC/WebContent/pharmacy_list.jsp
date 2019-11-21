<%@page import="ddocdoc.vo.PharmacyVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>약국 목록</h1>
<a href="/DDOCDOC/pharmacy/pharmacyInsertForm.do">약국정보 입력</a><br>

<table border="1">

	<tr>
		<td>약국번호</td>
		<td>약국이름</td>
	</tr>
		
	
		<c:forEach var="pharmacyvo" items="${list}">
			<tr>
				<tr>
				<td>${pharmacyvo.phar_num }</td>
				<td><a href="/DDOCDOC/pharmacy/pharmacyDetail.do?seq=${pharmacyvo.phar_num }">${pharmacyvo.phar_name }</a></td>
		</c:forEach>

</table>


</body>
</html>