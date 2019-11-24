<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String phar_name =request.getParameter("phar_name");
    request.setAttribute("phar_name", phar_name);
    %>
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
	<form action="phar_res_action.do" method = "post">
	메모 : <input type = "text" name = "phar_res_memo"><br>
	<p>
	진료 시간 : <select name="phar_res_time">
		      <option value="09:00">09:00</option>
		      <option value="09:30">09:30</option>
		      <option value="10:00">10:00</option>
		      <option value="10:30">10:30</option>
		      <option value="11:00">11:00</option>
		      <option value="11:30">11:30</option>
		      <option value="12:00">12:00</option>
		      <option value="12:30">12:30</option>
		      <option value="13:00">13:00</option>
		      <option value="13:30">13:30</option>
		      <option value="14:00">14:00</option>
		      <option value="14:30">14:30</option>
		      <option value="15:00">15:00</option>
		      <option value="15:30">15:30</option>
		      <option value="16:00">16:00</option>
		      <option value="16:30">16:30</option>
		      <option value="17:00">17:00</option>
		      <option value="17:30">17:30</option>
		      <option value="18:00">18:00</option>
	    </select><br>
	<input type = "hidden" name = "cus_num" value = ${cus_num }><br>
	<input type = "hidden" name = "phar_name" value = ${phar_name }><br>
	<input type = "submit" value = "예약">
	</form>
</body>

</html>