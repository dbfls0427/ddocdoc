<%@page import="ddocdoc.vo.ChildVO" %>
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
<h3>아이정보 목록</h3>
<a href="/DDOCDOC/child/childInsertForm.do">아이정보 등록</a>

<table border="1">
	<tr>
		<td>아이 이름</td>
		<td>아이 생일</td>
	</tr>
	
	<c:forEach var="ChildVO" items="${childList}" >
		<tr>
			<td><a href="/DDOCDOC/child/childDetail.do?ch_num=${ChildVO.ch_num}">${ChildVO.ch_name }</a></td>
			<td>${ChildVO.ch_birth }</td>
		</tr>
	</c:forEach>
	
</table>

</body>
</html>