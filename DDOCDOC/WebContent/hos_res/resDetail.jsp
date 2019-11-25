<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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
					<h2>Detail Reservation</h2>
					<ol class="breadcrumb">
						<li><a href="success.do"> <i class="ion-ios-home"></i>
								Home
						</a></li>
						<li class="active">Detail Reservation</li>
					</ol>
				</div>
			</div>
		</div>
	</div>
	</section>
	
	<section class="company-description" id="wrapjoin" style="display: flex; justify-content: center;">
		<div>
		<p class = "p">Detail</p>
		<div class="panel panel-warning" style="width: 400px" >
			
			<div class="panel-heading" align="center">예약번호</div>
  				<div class="panel-body" align="center"> ${res.hos_res_num }</div>
  				<div class="panel-heading" align="center">예약고객</div>
  				<div class="panel-body" align="center"> ${cus_name } </div>
  				<div class="panel-heading" align="center">진료종류</div>
  				<div class="panel-body" align="center"> ${res.hos_res_type } </div>
  				<div class="panel-heading" align="center">진료증상</div>
  				<div class="panel-body" align="center"> ${res.hos_res_sym } </div>
  				<div class="panel-heading" align="center">메모</div>
  				<div class="panel-body" align="center"> ${res.hos_res_memo } </div>
  				<div class="panel-heading" align="center">예약날짜</div>
  				<div class="panel-body" align="center"> ${res.hos_res_date } </div>
  				<div class="panel-heading" align="center">예약시간</div>
  				<div class="panel-body" align="center"> ${res.hos_res_time } </div>
  				<div class="panel-heading" align="center">대기번호</div>
  				<div class="panel-body" align="center"> ${count}</div>
		</div><br>
			</div>
		
		
	</section>
	<section class="company-description" id="wrapjoin" style="display: flex; justify-content: center;">
	<div style="margin-left: 50px">
	<button type="button" class="btn btn-warning"><a href = "deleteRes.do?hos_res_num=${res.hos_res_num }&hos_num=${res.hos_num}">예약취소</a></button> &nbsp&nbsp&nbsp&nbsp
	<button type="button" class="btn btn-warning"><a href = "resWaitSms.do?count=${count}&hos_res_num=${res.hos_res_num}">대기 번호 문자로 받기</a></button>
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



<%-- 
<body>
	
	
	
	<div class = "led-group" align = "center">
	회원 아이디 : <h1 id = "let-text">${customer.cus_id }</h1><br>
	회원 이름 : ${customer.cus_name }<br>
	회원 주소 : ${customer.cus_addr }<br>
	회원  이메일 : ${customer.cus_email }<br>
	회원 생년월일 : ${customer.cus_birth }<br>
	
	
		<h1>고객 상세정보 QR코드</h1> 
		<textarea cols="18" rows="20" class = "autosize" onkeydown="resize(this)" onkeyup = "resize(this)" id = "led-text" charset = "UTF-8">고객 아이디 : ${customer.cus_id }     고객 이름 : ${customer.cus_name }       고객 주소 : ${customer.cus_addr }       고객 이메일 : ${customer.cus_email }     고객 생년월일 : ${customer.cus_birth }</textarea>
		<button type = button id = "led-button1" onclick="button1_click()">QR코드 발급</button>
		<div id = "qrcode" style = "width:100px; height:100px; margin-top:15px;"></div> 
	
	</div>
	
	<script>
		var qrcode = new QRCode(document.getElementById("qrcode"),{height : 100, width : 100});
	
		function makeCode(){
			var elText = document.getElementById("led-text");
			if(!elText.value){
				alert("Input a text");
				elText.focus();
				return;
			}
			alert(elText.value);
			
			qrcode.makeCode(elText.value);
		}
		function button1_click(){
			makeCode();
		}
		function resize(obj){
			obj.style.height = "1px";
			obj.style.height = (12 + obj.scrollHeight) + "px";
		}
	
	</script>
	

</body> --%>








<%-- <%@ page language="java" contentType="text/html; charset=EUC-KR"
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
</html> --%>