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
	<% String ch_num = request.getParameter("ch_num"); %>
	<button><a href="HeightInsertFormAction.do?ch_num=<%=ch_num%>">키 등록</a></button>
	<table border="1">
		<tr>
			<td>입력 키</td>
			<td>등록 날짜</td>
		</tr>
		<c:forEach var="height" items="${list }">
			<tr>
				<td><a href="detailHeight.do?he_num=${height.he_num }">${height.he_height }</a></td>
				<td>${height.he_date }</td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>