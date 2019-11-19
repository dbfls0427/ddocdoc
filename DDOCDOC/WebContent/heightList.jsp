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
	<table border="1">
		<tr>
			<td>입력 키</td>
			<td>등록 날짜</td>
		</tr>
		<c:forEach var="height" items="${list }">
			<tr>
				<td>${height.he_height }</td>
				<td>${height.he_date }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>