<%@page import="ddocdoc.vo.ChildVO" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% String cus_name = request.getParameter("cus_name");
    	request.setAttribute("cus_name", cus_name);
    %>
<!DOCTYPE html>
<html>
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
        <link href="https://fonts.googleapis.com/css?family=Stylish&display=swap&subset=korean" rel="stylesheet"> 
        <link href="https://fonts.googleapis.com/css?family=Sunflower:300&display=swap&subset=korean" rel="stylesheet">      
        <link href="https://fonts.googleapis.com/css?family=Jua&display=swap&subset=korean" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css?family=Do+Hyeon&display=swap" rel="stylesheet">
<style type="text/css">
 a:link { color : black; text-decoration: none;}
 a:visited { color: black; text-decoration: none;}
#childIntro, #btn{
	 /* font-family: 'Jua', sans-serif;  */
	 /* font-family: 'Sunflower', sans-serif;  */
	/* font-family: 'Do Hyeon', sans-serif; */
	font-family: 'Sunflower', sans-serif;
}

 .btn-default{
 	border-color: #e68f1f;
    border-width: 2px;
 }
 
 .panel-default {
    border-color: #48310c;
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
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    </button>
                    <!-- /responsive nav button -->
                    
                    <!-- logo -->
                    <div class="navbar-brand">
                        <a href="/DDOCDOC/Customer/success.do" >
                            <img src="../images/logo.png" alt="">
                        </a>
                    </div>
                    <!-- /logo -->
                </div>
                <!-- main menu -->
                <nav class="collapse navbar-collapse navbar-right" role="navigation">
                    <div class="main-menu">
                        <ul class="nav navbar-nav navbar-right">
                            <li>
                                <a href="/DDOCDOC/Customer/success.do" >Home</a>
                            </li>
                             <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">병원찾기 <span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="/DDOCDOC/Customer/map.do?cus_num=${customer.cus_num }">병원찾기</a></li>
                                        <li><a href="../Customer/resList.do">예약내역</a></li>
                                    </ul>
                                </div>
                            </li>
                             <li><a href="/DDOCDOC/child.index.jsp?cus_name=${customer.cus_name } ">아이관리</a></li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">QR코드 <span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="/DDOCDOC/Customer/detailCustomer.do">QR코드 발급</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">후기<span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="../Customer/reviewInsertForm.do">후기 작성</a></li>
                                        <li><a href="../Customer/reviewList.do">후기 목록</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${cus_name } 님 <span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="../Customer/myPageForm.do">마이페이지</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li><a href="../Customer/logout.do">로그아웃</a></li>
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
        <section class="global-page-header">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <div class="block">
                            <h2>아이관리</h2>
                            <ol class="breadcrumb">
                                <li>
                                    <a href="/DDOCDOC/Customer/success.do">
                                        <i class="ion-ios-home"></i>
                                        Home
                                    </a>
                                </li>
                            </ol>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        
		<section id="btn" class="company-description" style="display: flex; justify-content: flex-end; padding-right: 700px; margin-top: 60px; margin-bottom: 0;">
			<button class="btn btn-default"><a href="/DDOCDOC/child/childList.do" style="font-size: 18px;">목록으로 돌아가기</a></button>&nbsp
			<button class="btn btn-default"><a href="/DDOCDOC/child/childUpdateForm.do?ch_num=${childVO.ch_num}&cus_name=${cus_name }" style="font-size: 18px;">수정</a></button>&nbsp
			<button class="btn btn-default"><a href="/DDOCDOC/child/childDelete.do?ch_num=${childVO.ch_num}" style="font-size: 18px;">삭제</a></button>
		</section>
		<br>
        <section  class="company-description" style="margin-top: 0;">
		 <div style="display: flex; justify-content: center; width: 500px; padding: 30px; margin-left: 37%;" class="panel panel-default">
			 <img alt="" src="../images/dechild.jpg" style="width: 180px; height: 150px;">
			  <div style="font-size: 25px; margin-left: 20px; font-weight: 500;" id="childIntro">
						이름 : ${childVO.ch_name} <br>
						나이 : ${childVO.ch_age} <br>
						생일 : ${childVO.ch_birth}<br>
						성별 : ${childVO.ch_gender}<br>
			  </div>
		 </div>
        </section>

		<section id="btn" class="company-description" style="display: flex; justify-content: center; margin-bottom: 80px; margin-top: 50px; margin-left: 30px;">
		
			<form action="/DDOCDOC/Height/HeightList.do" method="post">
				<input type="hidden" name="cus_name" value="${cus_name}">
				<input type="hidden" name="ch_num" value="${childVO.ch_num}">
				<input type="hidden" name="ch_name" value="${childVO.ch_name}">
				<input type = "submit" value="키 관리" class="btn btn-default btn-lg" style="font-size: 30px; margin-right: 30px; width: 140px;">
			</form>
			
			<form action="/DDOCDOC/Inject/InjectListAction.do" method="post">
				<input type="hidden" name="cus_name" value="${cus_name}">
				<input type="hidden" name="ch_num" value="${childVO.ch_num}">
				<input type="hidden" name="ch_name" value="${childVO.ch_name}">
				<input type = "submit" value="접종관리" class="btn btn-default btn-lg" style="font-size: 30px; margin-right: 20px; width: 140px;">
			</form>
		
		</section>
<!--
            ==================================================
            Footer Section Start
            ================================================== -->
            <footer id="footer">
                <div class="container">
                    <div class="col-md-8">
                        <p class="copyright">Copyright: <span><script>document.write(new Date().getFullYear())</script></span> Design and Developed by <a href="mailto:amydreamsyou@gmail.com" target="_blank">Lee Min-hye</a>. <br> 
                            Get More 
                            <a href="https://themefisher.com/free-bootstrap-templates/" target="_blank">
                                Free Bootstrap Templates
                            </a>
                        </p>
                    </div>
                    <div class="col-md-4">
                        <!-- Social Media -->
                        <ul class="social">
                            <li>
                                <a href="http://wwww.fb.com/themefisher" class="Facebook">
                                    <i class="ion-social-facebook"></i>
                                </a>
                            </li>
                            <li>
                                <a href="http://wwww.twitter.com/themefisher" class="Twitter">
                                    <i class="ion-social-twitter"></i>
                                </a>
                            </li>
                            <li>
                                <a href="#" class="Linkedin">
                                    <i class="ion-social-linkedin"></i>
                                </a>
                            </li>
                            <li>
                                <a href="http://wwww.fb.com/themefisher" class="Google Plus">
                                    <i class="ion-social-googleplus"></i>
                                </a>
                            </li>
                        </ul>
                    </div>
                </div>
            </footer> <!-- /#footer -->

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