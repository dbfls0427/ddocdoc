<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
function next(){
	 if(confirm("Ż���Ͻðڽ��ϱ�?"))
	 {
	   location.href="customerDelete.do?cus_num=${customer.cus_num}"; 
	 }
	 else
	 {
		location.href="myPageForm.do"; 
	 }
	}
	</script>
</head>
<body>

	<form action="customerUpdateForm.do" method="post">
		<input type = "hidden" name = "cus_num" value = "${customer.cus_num}">
		<input type = "submit" value = "���� ����"/>
	</form>
	
	<button onclick="next()">Ż���ϱ�</button>

</body>
</html>