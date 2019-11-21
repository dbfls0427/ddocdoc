<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String ch_name=request.getParameter("ch_name");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>키 : ${height.he_height }</h1>
	<br><br>
	<button><a href="updateHeightForm.do?he_num=${height.he_num }&ch_num=${height.ch_num}&ch_name=<%=ch_name%>">수정</a></button>
	<button><a href="deleteHeight.do?he_num=${height.he_num }&ch_num=${height.ch_num}&ch_name=<%=ch_name%>">삭제</a></button>

</body>
</html>