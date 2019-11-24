<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border = "1">
		<tr>
			<td>예약번호</td>
			<td>병원이름</td>
			<td>예약날짜</td>
			<td>처방전</td>
			
		</tr>
		
		<c:forEach var="resVO" items="${list }" varStatus="status">
			<tr>
				<td>${resVO.hos_res_num }</td>
				<td><a href = "detailRes.do?hos_res_num=${resVO.hos_res_num}">${hosName[status.index] }</td>
				<td>${resVO.hos_res_date }</td>
				<td><button><a href = "presDetail.do?hos_res_num=${resVO.hos_res_num }&hos_num=${resVO.hos_num}">처방전 보기</a></button></td>
				
			</tr>
		
		
		</c:forEach>
		
	
	
	</table>
	
	
	
</body>
</html>