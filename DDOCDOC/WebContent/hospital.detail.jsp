<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>똑닥</title>
</head>
<body>
<h3>병원정보 상세보기</h3>

<table border="1">
	<tr>
		<td>병원번호</td>
		<td>병원종류</td>
		<td>병원이름</td>
		<td>병원전화번호</td>
		<td>병원주소</td>
		<td>운영시간</td>
		<td>병원정보사항</td>
	</tr>
		<tr>
			<td><b>${hospitalvo.hos_num }</b></td>
			<td>${hospitalvo.hos_type }</td>
			<td>${hospitalvo.hos_name }</td>
			<td>${hospitalvo.hos_tel }</td>
			<td>${hospitalvo.hos_addr }</td>
			<td>${hospitalvo.hos_time }</td>
			<td>${hospitalvo.hos_info }</td>
		</tr>

</table>

<a href="/DDOCDOC/hospital/hospitalList.do">리스트</a> <br>
 
<a href="/DDOCDOC/hospital/hospitalUpdateForm.do?seq=${hospitalvo.hos_num }">수정</a> <br>

<a href="/DDOCDOC/hospital/hospitalDelete.do?seq=${hospitalvo.hos_num }">삭제</a> 

<br><br><br>
<hr>

<h5>예약환자 리스트</h5>
<!-- <p>현재예약환자 인원수:  <span>    <span>명</p>-->

<div style="display:flex;">
	<table border="1">
		<tr>고객명</tr>
		<c:forEach var="nameVO" items="${CustomerVO }">
			<tr>
				<td>고객이름 ????????${nameVO.cus_name }</td>
			</tr>
		</c:forEach>
	</table>
	
	<table border="1">
		<tr>
			<td>고객번호</td>
			<td>진료종류</td>
			<td>진료증상</td>
			<td>메모</td>
			<td>진료날짜</td>
			<td>진료시간</td>
			<td>병원예약번호</td>
			<td> 예약접수 </td>
			<td> 예약상태 </td>
		</tr>
	
	
		<c:forEach var="hosresvo" items="${HosResVO }">
			<tr>
				<td>고객번호${hosresvo.cus_num }</td>
				<td>${hosresvo.hos_res_type }</td>
				<td>${hosresvo.hos_res_sym }</td>
				<td>${hosresvo.hos_res_memo }</td>
				<td>진료날짜${hosresvo.hos_res_date }</td>
				<td>진료시간${hosresvo.hos_res_time }</td>
				<td>${hosresvo.hos_res_num }</td>
				<td><a href="/DDOCDOC/hospital/boolean_hos_res.do?hos_res_num=${hosresvo.hos_res_num}&seq=${hosresvo.hos_num}">예약</a></td>
				<td>${hosresvo.hos_acpt }</td>
			</tr>
		</c:forEach>
	</table>
</div>
</body>
</html>