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
	����ȣ : ${count}<br>
	<button><a href = "deleteRes.do?hos_res_num=${res.hos_res_num }&hos_num=${res.hos_num}">�������</a></button>
	<button><a href = "resWaitSms.do?count=${count}&hos_res_num=${res.hos_res_num}">��� ��ȣ ���ڷ� �ޱ�</a></button>


</body>
</html>