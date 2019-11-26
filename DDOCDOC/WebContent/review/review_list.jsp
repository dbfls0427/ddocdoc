<%@page import="ddocdoc.vo.ReviewVO"%>
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
<h1>후기 목록</h1>
<a href="reviewInsertForm.do">후기 입력</a><br>

<table border="1">

	<tr>
		<td>글 번호</td>
		<td>제목</td>
		<td>작성자</td>
		<td>작성일</td>
		<td>조회수</td>
		
	</tr>
	
	<c:forEach var="reviewvo" items="${list }">
		<tr>
			<tr>
			<td>${reviewvo.rv_num }</td>
			<td><a href="reviewDetail.do?seq=${reviewvo.rv_num }">${reviewvo.rv_title }</a></td>
			<td>${cus_name }</td>
			<td>${reviewvo.rv_date }</td>
			<td>${reviewvo.rv_count }</td>
	</c:forEach>






</table>
</body>
</html>