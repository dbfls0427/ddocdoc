<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="ddocdoc.vo.ChildHeightVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%
	List<ChildHeightVO> h_list =(ArrayList<ChildHeightVO>)request.getAttribute("height_list"); 
	int size = h_list.size();
	String ch_name = request.getParameter("ch_name");
	
	//표준키
	float st_height = Float.parseFloat(request.getParameter("st_height"));
	
	SimpleDateFormat transFormat = new SimpleDateFormat("yyyy-MM-dd");

	String[] date = new String[size];
	Double[] height = new Double[size];

	for(int i=0; i <h_list.size(); i++){
		date[i] = transFormat.format(h_list.get(i).getHe_date());
		height[i] = h_list.get(i).getHe_height();
	}

	request.setAttribute("height", height);
%>
<!DOCTYPE html>
<html>
<head>
 <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <script type="text/javascript">
    var height = new Array();
	var date = new Array();
	
	<%for(int i=0; i<height.length; i++){%>
		height.push('<%=height[i]%>')
		date.push('<%=date[i]%>')
	<%}%>
	
    // 성장그래프
    if(height.length > 0){
	    google.charts.load('current', {'packages':['line']});
	    google.charts.setOnLoadCallback(drawChart);
    }


    function drawChart() {
      var data = new google.visualization.DataTable();

      data.addColumn('string', 'Day');
      data.addColumn('number', '키');

		
      for(var i=0; i<height.length; i++){
 		 
	      	data.addRows([
	      		[date[i], parseFloat(height[i])]
	      	]);
	      	
  		} 
      var options = {
		
        chart: {
          title: '우리아이 성장속도 한눈에 보기'
        },
        width: 900,
        height: 500,
        axes: {
          x: {
            0: {side: 'top'}
          }
        }
      };

      var chart = new google.charts.Line(document.getElementById('line_top_x'));

      chart.draw(data, google.charts.Line.convertOptions(options));
    }
    
    //빅데이터 그래프
    if(height.length > 0){
    google.charts.load('current', {'packages':['bar']});
    google.charts.setOnLoadCallback(drawChart2);
    }
 
    function drawChart2() {
	  var ch_name = '<%=ch_name%>';
      var data = google.visualization.arrayToDataTable([
        ['또래의 평균 키', ch_name, '평균 키'],
        ['키 분석', height[height.length-1], <%=st_height%>]
      ]);

      var options = {
        chart: {
          title: ch_name+'의 또래 평균 키는 ' + <%=st_height%> + ' cm입니다',
          subtitle: '',
        }
      };

      var chart = new google.charts.Bar(document.getElementById('columnchart_material'));

      chart.draw(data, google.charts.Bar.convertOptions(options));
    }
  </script>
  
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% String ch_num = request.getParameter("ch_num"); %>
	<br><br>
	<button><a href="HeightInsertFormAction.do?ch_num=<%=ch_num%>">키 등록</a></button>
	<table border="1">
		<tr>
			<td>입력 키</td>
			<td>등록 날짜</td>
		</tr>
		<c:forEach var="height" items="${list }">
			<tr>
				<td><a href="detailHeight.do?he_num=${height.he_num }&ch_name=<%=ch_name%>">${height.he_height }</a></td>
				<td>${height.he_date }</td>
			</tr>
		</c:forEach>
	</table>
	<br><br>
	<div id="line_top_x"></div>
	<br><br>
	<div id="columnchart_material" style="width: 400px; height: 500px;"></div>
</body>
</html>