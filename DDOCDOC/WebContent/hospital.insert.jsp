<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>똑닥</title>
</head>
<body>
<h3>병원정보등록</h3>

<form action="/DDOCDOC/hospital/hospitalInsert.do" method="post">
	병원종류 <select name="hos_type">
		      <option value="내과">내과</option>
		      <option value="정형외과">정형외과</option>
		      <option value="이빈인후과">이비인후과</option>
		      <option value="치과">치과</option>
		      <option value="피부과">피부과</option>
		      <option value="안과">안과</option>
		      <option value="소아과">소아과</option>
	    </select><br>
	병원이름 <input type="text" name="hos_name"><br>
	병원전화번호 <input type="text" name="hos_tel"><br>
	병원주소 <input type="text" name="hos_addr"><br>
	운영시간 <input type="text" name="hos_time"><br>
	병원정보사항 <textarea rows="4" cols="10" name="hos_info"></textarea>


	<input type="submit" value="저장">
</form>
</body>
</html>