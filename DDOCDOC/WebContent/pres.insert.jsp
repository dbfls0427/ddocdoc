<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>똑닥</title>
</head>
<body>

<h3>처방전 등록</h3>

<form action="/DDOCDOC/hospital/presInsert.do" method="post">
	발급일 <input type="date" name="pres_date"><br>
	<table border="1">
		<tr>
			<td></td>
			<td>약수량</td>
		</tr>
		<tr>
			<td><input type="text" name="pres_num"></td>
			<td><input type="int" name="pres_count"></td>
		</tr>
	</table>
	복용횟수 <input type="text" name="hos_tel"><br>
	약이름<input type="text" name="hos_addr"><br>
	약수량<input type="text" name="hos_addr"><br>
	<input type="submit" value="저장">
</form>



</body>
</html>