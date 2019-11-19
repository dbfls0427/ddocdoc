<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
	<tr>
		<td>병원번호</td>
		<td>병원종류</td>
		<td>병원이름</td>
	</tr>
		
	
		<c:forEach var="hospitalvo" items="${list}">
			<tr>
				<tr>
				<td>${hospitalvo.hos_num }</td>
				<td>${hospitalvo.hos_type }</td>
				<td><a href="/DDOCDOC/hospital/hospitalDetail.do?seq=${hospitalvo.hos_num }">${hospitalvo.hos_name }</a></td>
		</c:forEach>


	</table>
</body>
</html>