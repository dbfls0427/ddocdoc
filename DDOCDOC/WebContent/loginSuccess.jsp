<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>

�α��� ����!
<form action="logout.do" method="post">
	<input type = "submit" value="�α׾ƿ�">
</form>

${customer.cus_name }

<form action="detailCustomer.do" method = "post">
	<input type = "submit" value="ȸ�� ������">
</form>
<br>
<form action="/DDOCDOC2/map/hosSearch.jsp" method="post">
	<input type="hidden" name="cus_num" value="${customer.cus_num }">
	<input type = "submit" value="����� ���� ã��">
</form>

<form action="resList.do" method = "post">
	<input type = "submit" value = "���� ����">

</form>


</body>
</html>