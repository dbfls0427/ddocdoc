<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
	예약번호 : ${res.hos_res_num }<br>
	예약고객 : ${cus_name }<br>
	진료종류 : ${res.hos_res_type }<br>
	진료증상 : ${res.hos_res_sym }<br>
	메모 : ${res.hos_res_memo }<br>
	예약날짜 : ${res.hos_res_date }<br>
	예약시간 : ${res.hos_res_time }<br>
	대기번호 : ${count}<br>
	<button><a href = "deleteRes.do?hos_res_num=${res.hos_res_num }&hos_num=${res.hos_num}">예약취소</a></button>
	<button><a href = "resWaitSms.do?count=${count}&hos_res_num=${res.hos_res_num}">대기 번호 문자로 받기</a></button>


</body>
</html>