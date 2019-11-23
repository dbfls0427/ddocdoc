<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
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
<span>현재 총</span>&nbsp<span>2</span><span>&nbsp건의 접종기간입니다.</span><br>
<br><br>

<button><a href="../map/injSearch.jsp">가까운 소아과 예약</a></button>
<br><br>

<span>접종률</span>
<br>
<button><a>전체</a></button> <button><a>미접종</a></button> <button><a>접종완료</a></button> 
<br><br>

<c:forEach var="list" items="${list }">
	<table border="1">
		<tr>
			<td colspan="2">${list.inj_info_name }</td>
			<td rowspan="2">
				<c:set var="loop_flag" value="false"/>
				<c:set var="answer" value="미접종"/>
				<c:forEach var="inj" items="${injList }">
					<c:if test="${not loop_flag }">
						<c:choose>
							<c:when test="${inj eq list.inj_info_num}">
								<c:set var="answer" value="접종완료"/>
								<c:out value="${answer }"/>
								<c:set var="loop_flag" value="true"/>
							</c:when>
						</c:choose>
					</c:if>
				</c:forEach>
				<c:if test="${answer ne '접종완료' }">
					<c:out value="${answer }"/>
				</c:if>
				
				
			</td>
		</tr>
		<tr>
			<td>${list.inj_info_price }</td>
			<td>${list.inj_info_date }</td>
		</tr>
	</table>
	<br>
</c:forEach>

</body>
</html>