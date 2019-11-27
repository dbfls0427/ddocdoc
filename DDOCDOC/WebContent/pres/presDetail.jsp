<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html class="no-js">
<head>
<!-- Basic Page Needs
        ================================================== -->
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="icon" href="favicon.ico">
<title>똑딱</title>
<meta name="description" content="">
<meta name="keywords" content="">
<meta name="author" content="">
<!-- Mobile Specific Metas
        ================================================== -->
<meta name="format-detection" content="telephone=no">
<meta name="viewport" content="width=device-width, initial-scale=1">


<!-- Template CSS Files
        ================================================== -->
<!-- Twitter Bootstrs CSS -->
<link rel="stylesheet" href="../plugins/bootstrap/bootstrap.min.css">
<!-- Ionicons Fonts Css -->
<link rel="stylesheet" href="../plugins/ionicons/ionicons.min.css">
<!-- animate css -->
<link rel="stylesheet" href="../plugins/animate-css/animate.css">
<!-- Hero area slider css-->
<link rel="stylesheet" href="../plugins/slider/slider.css">
<!-- owl craousel css -->
<link rel="stylesheet" href="../plugins/owl-carousel/owl.carousel.css">
<link rel="stylesheet" href="../plugins/owl-carousel/owl.theme.css">
<!-- Fancybox -->
<link rel="stylesheet" href="../plugins/facncybox/jquery.fancybox.css">
<!-- template main css file -->
<link rel="stylesheet" href="../css/style.css">

<style type="text/css">
	a{
		text-decoration: none;
		color: #FFFFFF;
	}
	
	button{
		color:#FFFF1C;
	}
	
	.p{
	font-family: fantasy;
	font-size: 26px;
	color : #ffe307;
	}
	

</style>

</head>
<body>

	<!--
        ==================================================
       MENU: Header Section Start
        ================================================== -->
	<header id="top-bar" class="navbar-fixed-top animated-header">
	<div class="container">
		<div class="navbar-header">
			<!-- responsive nav button -->
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<!-- /responsive nav button -->

			<!-- logo -->
			<div class="navbar-brand">
				<a href="success.do"> <img src="../images/logo.png" alt="">
				</a>
			</div>
			<!-- /logo -->
		</div>
		<!-- main menu -->
		<nav class="collapse navbar-collapse navbar-right" role="navigation">
		<div class="main-menu">
			<ul class="nav navbar-nav navbar-right">
				<li><a href="success.do">Home</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">병원찾기 <span class="caret"></span></a>
					<div class="dropdown-menu">
						<ul>
							<li><a href="map.do?cus_num=${customer.cus_num }">병원찾기</a></li>
							<li><a href="resList.do">예약내역</a></li>
						</ul>
					</div></li>
				<li><a href="/DDOCDOC/child.index.jsp?cus_name=${customer.cus_name }">아이관리</a></li>
				<li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">QR코드 <span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="detailCustomer.do">QR코드 발급</a></li>
                                    </ul>
                                </div>
                            </li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">${customer.cus_name } 님 <span
						class="caret"></span></a>
					<div class="dropdown-menu">
						<ul>
							<li><a href="myPageForm.do">마이페이지</a></li>
						</ul>
					</div></li>
				<li><a href="logout.do">로그아웃</a></li>
			</ul>
		</div>
		</nav>
		<!-- /main nav -->
	</div>
	</header>

	<!-- 
        ================================================== 
            TITLE: Global Page Section Start
        ================================================== -->
	<section class="global-page-header" style="background: #ffe307;">
	<div class="container">
		<div class="row">
			<div class="col-md-12">
				<div class="block">
					<h2>Detail Prescription</h2>
					<ol class="breadcrumb">
						<li><a href="success.do"> <i class="ion-ios-home"></i>
								Home
						</a></li>
						<li class="active">Detail Prescription</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	<section class="company-description" style="display: flex; justify-content: center;">
		<div>
		<p class = "p">Detail</p>
		<br>
		<div>
			<table class="table table-condensed" align="center">
				  <tr>
					<td>처방전번호</td>
					<td>발급일</td>
					<td>복용횟수</td>
					<td>고객이름</td>
					<td>병원이름</td>
					<td>예약번호</td>
					<td>결제여부</td>
				 </tr>
				  <tr>
					<td>${pres.pres_num }</td>
					<td>${pres.pres_date }</td>
					<td>${pres.pres_count }</td>
					<td>${cus_name }</td>
					<td>${hos_name }</td>
					<td>${pres.hos_res_num }</td>
					<td>${check }</td>
				  </tr>
		  		
			</table>
		</div>
		</div>
		<div style="margin-left: 100px; border: 1; width: 400px; border-color: #ffe307;" class="panel panel-default" >
		<div class="panel-body" id="div1">
		<p class = "p">처방전 약 목록</p>
		<br>
		<c:forEach var="medicine" items="${list}" varStatus="status">
		<span>${medicine.med_num } &nbsp ${list2[status.index] }</span><br>
		</c:forEach>
		<hr>
		<span>약 총 가격 : ${price }</span>
		</div>
		
		</div>
		
	</section>

	
	
	<section class="company-description" style="display: flex; justify-content: center;">
		<div style="margin-left: 850px; margin-bottom: 100px">
		<form action="payAction.do" method="post" style="display: flex; justify-content: center;">
			<input type="hidden" value = "${pres.pres_num }" name = "pres_num"><br>
			<select name = "pay_type" class="form-control">
				<option value="카드">카드</option>
				<option value="계좌이체">계좌이체</option>
			</select>&nbsp&nbsp
			<input type = "submit" value = "선 결제하기" onclick="check()" class="btn btn-warning">
			<script type="text/javascript">
			function check() {
				alert("결제가 완료되었습니다.");
			}
			</script>
	</form>
	<form action="/DDOCDOC/map/pharSearch.jsp" method="post" style="float: right; margin-top: 10px">
		<input type = "submit" value="약국예약" class="btn btn-warning">
	</form>	
		
		
		</div>
	
	</section>

	<footer id="footer">
	<div class="container">
		<div class="col-md-8">
			<p class="copyright">
				Copyright: <span><script>document.write(new Date().getFullYear())</script></span>
				Design and Developed by <a href="mailto:amydreamsyou@gmail.com"
					target="_blank">Lee Min-hye</a>. <br> Get More <a
					href="https://themefisher.com/free-bootstrap-templates/"
					target="_blank"> Free Bootstrap Templates </a>
			</p>
		</div>
		<div class="col-md-4">
			<!-- Social Media -->
			<ul class="social">
				<li><a href="http://wwww.fb.com/themefisher" class="Facebook">
						<i class="ion-social-facebook"></i>
				</a></li>
				<li><a href="http://wwww.twitter.com/themefisher"
					class="Twitter"> <i class="ion-social-twitter"></i>
				</a></li>
				<li><a href="#" class="Linkedin"> <i
						class="ion-social-linkedin"></i>
				</a></li>
				<li><a href="http://wwww.fb.com/themefisher"
					class="Google Plus"> <i class="ion-social-googleplus"></i>
				</a></li>
			</ul>
		</div>
	</div>
	</footer>
	<!-- /#footer -->

	<!-- Template Javascript Files
	================================================== -->
	<!-- jquery -->
	<script src="../plugins/jQurey/jquery.min.js"></script>
	<!-- Form Validation -->
	<script src="../plugins/form-validation/jquery.form.js"></script>
	<script src="../plugins/form-validation/jquery.validate.min.js"></script>
	<!-- owl carouserl js -->
	<script src="../plugins/owl-carousel/owl.carousel.min.js"></script>
	<!-- bootstrap js -->
	<script src="../plugins/bootstrap/bootstrap.min.js"></script>
	<!-- wow js -->
	<script src="../plugins/wow-js/wow.min.js"></script>
	<!-- slider js -->
	<script src="../plugins/slider/slider.js"></script>
	<!-- Fancybox -->
	<script src="../plugins/facncybox/jquery.fancybox.js"></script>
	<!-- template main js -->
	<script src="../js/main.js"></script>
</body>
	
	
</html>



