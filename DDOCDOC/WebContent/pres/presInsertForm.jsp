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
<h3>처방전 등록</h3>

<h1>약이름</h1>
<c:forEach var="med" items="${medicinevo }">
<span>${med.med_num }</span>&nbsp &nbsp<span>${med.med_name }</span><br>
</c:forEach>

<hr>
<h1>현재 처방전 약 등록 목록</h1>
<c:forEach var="medicine" items="${list}" varStatus="status">
	<span>${medicine.med_num } &nbsp ${medName[status.index] }</span><br>
</c:forEach>

<br>
<form action="/DDOCDOC/hospital/medInsert.do" method="post">
	${hos_res_num }
	<input type = "hidden" name = "hos_res_num" value = "${hos_res_num }">
	<input type = "hidden" name = "pres_num" value = "${pres_num}">
	
	<table border="1">
		<tr>
			<td>약 번호 입력</td>
			<td>약수량</td>
			<td>추가</td>
		</tr>
		<tr>
			<td><input type="text" name="med_num" placeholder="약 번호를 입력해주세요"></td>
			<td><input type="text" name="med_count"></td>
			<td><input type="submit" value="약 추가"></td>
		</tr>
	</table>
	
</form>
<br><br>


</body>
</html>