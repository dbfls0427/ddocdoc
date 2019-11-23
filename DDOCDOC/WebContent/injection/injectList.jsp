<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<% String ch_num = request.getParameter("ch_num"); 
	request.setAttribute("ch_num", ch_num);
	String pc = String.valueOf(request.getAttribute("pc"));
%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	#chart_div{
		padding-left: 0
	}
</style>
  <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
  <script type="text/javascript">
	   var percent = <%=pc%>;
  
  		if(percent > 0){
  			google.charts.load('current', {packages: ['corechart', 'bar']});
  			google.charts.setOnLoadCallback(drawMultSeries);
	    }
	  function drawMultSeries() {
		  var data = google.visualization.arrayToDataTable([
	        [' ', '접종률', { role: 'style' },'전체달성',{ role: 'style' }],
	        [' ', percent, 'fill-color: #FA5882', 100, 'fill-color: #A4A4A4']
	      ]);
	
	      
	      var options = {
	        chartArea: {width: '30%'},
	        hAxis: {
	          title: '접종달성 현황',
	          minValue: 0
	        }
	      };
	
	      var chart = new google.visualization.BarChart(document.getElementById('chart_div'));
	      chart.draw(data, options);
	    }
  </script>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<span>현재 총</span>&nbsp<span>2</span><span>&nbsp건의 접종기간입니다.</span><br>
<br><br>

<button><a href="../map/injSearch.jsp">가까운 소아과 예약</a></button>
<br><br>

<span>접종률 : ${percent }<div id="chart_div"></div></span>
<br>
<button><a>전체</a></button> <button><a>미접종</a></button> <button><a>접종완료</a></button> 
<br><br>

<c:forEach var="list" items="${list }">
	<table border="1">
		<tr>
			<td colspan="2">${list.inj_info_name }</td>
			<td rowspan="2">
				<c:set var="loop_flag" value="false"/>
				<c:set var="answer" value="미접종"/>
				<c:forEach var="inj" items="${injList }">
					<c:if test="${not loop_flag }">
						<c:choose>
							<c:when test="${inj eq list.inj_info_num}">
								<c:set var="answer" value="접종완료"/>
								<a href="InjectDetailAction.do?ch_num=${ch_num }&inj_content=${list.inj_info_num}&inj_info_name=${list.inj_info_name}&inj_info_date=${list.inj_info_date }"><c:out value="${answer }"/></a>
								<c:set var="loop_flag" value="true"/>
							</c:when>
						</c:choose>
					</c:if>
				</c:forEach>
				<c:if test="${answer ne '접종완료' }">
					<a href="InjectInsertFormAction.do?ch_num=${ch_num }&inj_content=${list.inj_info_num}&inj_info_name=${list.inj_info_name}&inj_info_date=${list.inj_info_date }"><c:out value="${answer }"/></a>
				</c:if>
				
				
			</td>
		</tr>
		<tr>
			<td>${list.inj_info_price }</td>
			<td>${list.inj_info_date }</td>
		</tr>
	</table>
	<br>
</c:forEach>

</body>
</html>