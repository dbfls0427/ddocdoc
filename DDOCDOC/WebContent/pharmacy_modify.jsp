<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>약국 정보 수정</h1>
<form action="/DDOCDOC/pharmacy/pharmacyUpdate.do" method="post">
	약국번호<input type="hidden" value="${pharmacyvo.phar_num}" name="phar_num"><br>
	약국이름 <input type="text" value="${pharmacyvo.phar_name}" name="phar_name"><br>
	약국전화번호 <input type="text" value="${pharmacyvo.phar_tel}" name="phar_tel"><br>
	약국주소 <input type="text" value="${pharmacyvo.phar_addr}" name="phar_addr"><br>
	약국운영시간 <input type="text" value="${pharmacyvo.phar_time}" name="phar_time"><br> 
	약국정보사항 <textarea rows="5" cols="12" name="phar_info">${pharmacyvo.phar_info}</textarea> 
	

	&nbsp;&nbsp;<input type="submit" value="저장">    
	<br><br><br><a href="/DDOCDOC/pharmacy/pharmacyList.do">목록</a> <br>
</form>

</body>
</html>