<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" href="http://code.jquery.com/ui/1.10.0/themes/base/jquery-ui.css" />
<script src="http://code.jquery.com/jquery-1.8.3.js"></script>
<script src="http://code.jquery.com/ui/1.10.0/jquery-ui.js"></script>
<link rel="stylesheet" href="/resources/demos/style.css" />
<script>
 $(function() {
  $("#datepicker").datepicker();
 });
</script>
</head>
<body>
	<form action="hos_res_action.do" method = "post">
	진료 종류 : <select name="res_type">
		      <option value="일반진료">일반진료</option>
		      <option value="수액">수액</option>
	    </select><br>
	진료 증상 : <input type = "text" name = "res_sym"><br>
	메모 : <input type = "text" name = "res_memo"><br>
	<p>
  예약 날짜 : <input type="text" id="datepicker" name = "res_date"/>
 	</p>
	진료 시간 : <select name="res_time">
		      <option value="09:00">09:00</option>
		      <option value="09:30">09:00</option>
		      <option value="10:00">09:00</option>
		      <option value="10:30">09:00</option>
		      <option value="11:00">09:00</option>
		      <option value="11:30">09:00</option>
		      <option value="12:00">09:00</option>
		      <option value="12:30">09:00</option>
		      <option value="13:00">09:00</option>
		      <option value="13:30">09:00</option>
		      <option value="14:00">09:00</option>
		      <option value="14:30">09:00</option>
		      <option value="15:00">09:00</option>
		      <option value="15:30">09:00</option>
		      <option value="16:00">09:00</option>
		      <option value="16:30">09:00</option>
		      <option value="17:00">09:00</option>
		      <option value="17:30">09:00</option>
		      <option value="18:00">09:00</option>
	    </select><br>
	<input type = "text" name = "res_time"><br>
	<input type = "hidden" name = "cus_num" value = ${cus_num }><br>
	<input type = "hidden" name = "hos_name" value = ${hos_name }><br>

	<input type = "submit" name = "예약">
	</form>
</body>
</html>