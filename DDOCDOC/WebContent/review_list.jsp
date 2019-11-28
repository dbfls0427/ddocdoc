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
<a href="/DDOCDOC/review/reviewInsertForm.do">후기 입력</a><br>

<table border="1">

	<tr>
		<td>후기 번호</td>
		<td>후기 제목</td>
		<td>후기 작성자</td>
		<td>조회수</td>
	</tr>
	
	<c:forEach var="reviewvo" items="${list }">
		<tr>
			<tr>
			<td>${reviewvo.rv_num }</td>
			<td><a href="/DDOCDOC/review/reviewDetail.do?seq=${reviewvo.rv_num }">${reviewvo.rv_title }</a></td>
			<td>${reviewvo.rv_writer }</td>
			<td>${reviewvo.rv_count }</td>
	</c:forEach>
</table>
<br><br>

<!--페이지처리 영역  -->
<!--이전  -->
<c:if test="${listModel.startPage > 5 }">
	<a href="list.do?pageNum=${listModelstartPage -1 }">[이전]</a>
</c:if>

<!-- 페이지 목록 -->
<c:forEach var="PageNo" begin="${listModel.startPage }"
				end="${listModel.endPage }">
		<c:if test="${listModel.requestPage == pageNo }"><b></c:if>
			<a href="list.do?pageNum=${pageNo }">[${pageNo }]</a>
		<c:if test="${listModel.requestPage == pageNo }"></b></c:if>
</c:forEach>	

<!--이후-->
<c:if test="${listModel.endPage < listModel.totalPageCount }">
	<a href="list.do?pageNum=${listModel.endPage +1 }">[이후]</a>
</c:if>

<form action="list.do" method="post">
	<input type="checkbox" name="area" value="title"> 제목
	<input type="checkbox" name="area" value="writer">작성자
	<input type="text" name="searchKey" size="10">
	<input type="submit" value="검색">	
</form>
</body>
</html>