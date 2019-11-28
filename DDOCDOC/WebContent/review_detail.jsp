<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>리뷰 상세보기</h1>
<table border="1">

	<tr>
		<td>리뷰번호</td>
		<td>리뷰제목</td>
		<td>작성자</td>
		<td>내용</td>
		<td>날짜</td>
		<td>조회수</td>
		<!-- <td>고객번호</td> -->
	</tr>
	
	<tr>
		<td><b>${reviewvo.rv_num }</b></td>
		<td>${reviewvo.rv_title }</td>
		<td>${reviewvo.rv_writer }</td>
		<td>${reviewvo.rv_content }</td>
		<td>${reviewvo.rv_date }</td>
		<td>${reviewvo.rv_count }</td>
		<%-- <td>${coustomer.cus_num }</td> --%>
	</tr>

</table>

<a href="/DDOCDOC/review/reviewList.do">목록</a>
<a href="/DDOCDOC/review/reviewUpdateForm.do?seq=${reviewvo.rv_num }">수정</a>
<a href="/DDOCDOC/review/reviewDelete.do?seq=${reviewvo.rv_num }">삭제</a>
</body>
</html>