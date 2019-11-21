<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>약국 정보 등록</h1>
<form action="/DDOCDOC/pharmacy/pharmacyInsert.do" method="post">

	약국이름 <input type="text" name="phar_name"><br>
	약국전화번호 <input type="text" name="phar_tel"><br>
	약국주소 <input type="text" name="phar_addr"><br>
	약국운영시간 <input type="text" name="phar_time"><br>
	약국정보 <textarea rows="4" cols="10" name="phar_info"></textarea>


	<input type="submit" value="저장">









</form>

</body>
</html>