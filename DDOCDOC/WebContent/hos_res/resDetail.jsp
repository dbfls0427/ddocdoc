<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	�����ȣ : ${res.hos_res_num }<br>
	����� : ${cus_name }<br>
	�������� : ${res.hos_res_type }<br>
	�������� : ${res.hos_res_sym }<br>
	�޸� : ${res.hos_res_memo }<br>
	���೯¥ : ${res.hos_res_date }<br>
	����ð� : ${res.hos_res_time }<br>
	<button><a href = "deleteRes.do?hos_res_num=${res.hos_res_num }">�������</a></button>
	


</body>
</html>