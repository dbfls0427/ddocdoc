
<%@page import="ddocdoc.vo.ConfirmVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
	ConfirmVO confirm = (ConfirmVO)request.getAttribute("confirm");
	request.setAttribute("confirm", confirm);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>

</head>
<body>
	<form action="Customer/confirmaction.do" method = "post">
	<input type = "submit" value = "인증번호 발급"> 
	</form>
	
	
	<form action="confirm.do" method = "post">
		<input type = "text" name = "confirm">
		<input type = "submit" value = "인증하기">
	
	</form>
	
	<%-- <c:choose>
		<c:when test="${confirm.isCheck() == true }">
		<script type="text/javascript">

		self.close();


		</script>
		</c:when>
		<c:otherwise>
			<script type="text/javascript">
				alert("인증번호가 틀렸습니다.");
			</script>
		</c:otherwise>
	
	</c:choose> --%>
	
	<c:if test="${confirm.isCheck() == true }">
	<script type="text/javascript">

	self.close();


	</script>
	
	</c:if>
	
</body>
</html>