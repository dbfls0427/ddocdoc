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
<h3>처방전 상세보기 </h3>

	<table border = "1">
		<tr>
			<td>처방전번호</td>
			<td>발급일</td>
			<td>복용횟수</td>
			<td>고객이름</td>
			<td>병원이름</td>
			<td>예약번호</td>
			<td>결제여부</td>
		</tr>
		<tr>
			<td>${pres.pres_num }</td>
			<td>${pres.pres_date }</td>
			<td>${pres.pres_count }</td>
			<td>${cus_name }</td>
			<td>${hos_name }</td>
			<td>${pres.hos_res_num }</td>
			<td>${check }</td>
		</tr>
	</table>
	<h1>처방전 약 목록</h1>
	<c:forEach var="medicine" items="${list}" varStatus="status">
	<span>${medicine.med_num } &nbsp ${list2[status.index] }</span><br>
	</c:forEach>
	<hr>
	<span>약 총 가격 : ${price }</span>
	
	<form action="payAction.do" method="post">
		<input type="hidden" value = "${pres.pres_num }" name = "pres_num"><br>
		<select name = "pay_type">
			<option value="카드">카드</option>
			<option value="계좌이체">계좌이체</option>
		</select>
		<input type = "submit" value = "선 결제하기" onclick="check()">
		<script type="text/javascript">
		function check() {
			alert("결제가 완료되었습니다.");
		}
		</script>
	</form>
	
	<form action="/DDOCDOC/map/pharSearch.jsp" method="post">
		<input type = "submit" value="약국예약">
	</form>

</body>
</html>