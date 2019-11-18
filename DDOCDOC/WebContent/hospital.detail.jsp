<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
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

<a href="/doc/hospital/hospitalList.do">리스트</a> <br>
 
<a href="/doc/hospital/hospitalUpdateForm.do?seq=${hospitalvo.hos_num }">수정</a> <br>

<a href="/doc/hospital/hospitalDelete.do?seq=${hospitalvo.hos_num }">삭제</a> 


</body>
</html>