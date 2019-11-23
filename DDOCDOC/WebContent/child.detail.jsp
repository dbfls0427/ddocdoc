<%@page import="ddocdoc.vo.ChildVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>똑닥</title>
</head>
<body>
<h1>아이관리</h1>
<h3>아이정보 상세보기</h3>
<table border="1">
	<tr>
		<td>아이이름</td>
		<td>아이나이</td>
		<td>아이생일</td>
		<td>아이성별</td>
	</tr>
	
	<tr>
		<td>${childVO.ch_name}</td>
		<td>${childVO.ch_age}</td>
		<td>${childVO.ch_birth}</td>
		<td>${childVO.ch_gender}</td>
	</tr>
</table>

<a href="/DDOCDOC/child/childList.do">아이정보목록</a><br>

<a href="/DDOCDOC/child/childUpdateForm.do?ch_num=${childVO.ch_num}">수정</a><br>

<a href="/DDOCDOC/child/childDelete.do?ch_num=${childVO.ch_num}">삭제</a><br>

<form action="/DDOCDOC/Height/HeightList.do" method="post">
	<input type="hidden" name="ch_num" value="${childVO.ch_num}">
	<input type="hidden" name="ch_name" value="${childVO.ch_name}">
	<input type = "submit" value="키 관리">
</form>
<br><br>
<form action="/DDOCDOC/Inject/InjectListAction.do" method="post">
	<input type="hidden" name="ch_num" value="${childVO.ch_num}">
	<input type="hidden" name="ch_name" value="${childVO.ch_name}">
	<input type = "submit" value="접종관리">
</form>

</body>
</html>