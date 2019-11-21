<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>약국 상세보기</h1>
<table border="1">

	<tr>
		<td>약국번호</td>
		<td>약국이름</td>
		<td>약국전화번호</td>
		<td>약국주소</td>
		<td>약국운영시간</td>
		<td>약국정보</td>
	</tr>
	
		<tr>
			<td><b>${pharmacyvo.phar_num }</b></td>
			<td>${pharmacyvo.phar_name }</td>
			<td>${pharmacyvo.phar_tel }</td>
			<td>${pharmacyvo.phar_addr }</td>
			<td>${pharmacyvo.phar_time }</td>
			<td>${pharmacyvo.phar_info }</td>
		</tr>
</table>

<a href="/DDOCDOC/pharmacy/pharmacyList.do">목록</a> <br>
 
<a href="/DDOCDOC/pharmacy/pharmacyUpdateForm.do?seq=${pharmacyvo.phar_num }">수정</a> <br>


<a href="/DDOCDOC/pharmacy/pharmacyDelete.do?seq=${pharmacyvo.phar_num }">삭제</a> 





</body>
</html>