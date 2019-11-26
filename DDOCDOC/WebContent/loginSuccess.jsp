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
                        <a href="success.do" >
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
                                <a href="success.do" >Home</a>
                            </li>
                             <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">병원찾기 <span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="map.do?cus_num=${customer.cus_num }">병원찾기</a></li>
                                        <li><a href="resList.do">예약내역</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li><a href="child/childPleaseLogin.do">아이관리</a></li>
                             <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">QR코드 <span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="detailCustomer.do">QR코드 발급</a></li>
                                    </ul>
                                </div>
                            </li>
							<li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">후기<span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="reviewInsertForm.do">후기 작성</a></li>
                                        <li><a href="reviewList.do">후기 목록</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">${customer.cus_name } 님 <span class="caret"></span></a>
                                <div class="dropdown-menu">
                                    <ul>
                                        <li><a href="myPageForm.do">마이페이지</a></li>
                                    </ul>
                                </div>
                            </li>
                            <li><a href="logout.do">로그아웃</a></li>
                        </ul>
                    </div>
                </nav>
                <!-- /main nav -->
            </div>
        </header>
        
        
<!--        
로그인 성공!



<form action="logout.do" method="post">
	<input type = "submit" value="로그아웃">
</form>

${customer.cus_name }

<form action="detailCustomer.do" method = "post">
	<input type = "submit" value="회원 상세정보">
</form>
<br>
<form action="map.do" method="post">
	<input type="hidden" name="cus_num" value="${customer.cus_num }">
	<input type = "submit" value="가까운 병원 찾기">
</form>

<form action="resList.do" method = "post">
	<input type = "submit" value = "예약 내역">
</form>

<br>

<form action="/DDOCDOC/child.index.html" method = "post">
	<input type = "submit" value="아이관리">
</form>

<form action="myPageForm.do" method="post">
	<input type = "submit" value = "마이페이지">
</form>

 --> 



<!-- 
================================================== 
    Works Section Start
================================================== -->
<section class="works service-page" style="margin-top:80px;">
    <div class="container">
    <h1>환영합니다!   ${customer.cus_name }님</h1>
        <h2 class="subtitle wow fadeInUp animated" data-wow-delay=".3s" data-wow-duration="500ms">Some Of Our Features Works</h2>
            <p class="subtitle-des wow fadeInUp animated" data-wow-delay=".5s" data-wow-duration="500ms">
                Aliquam lobortis. Maecenas vestibulum mollis diam. Pellentesque auctor neque nec urna. Nulla sit amet est. Aenean posuere <br> tortor sed cursus feugiat, nunc augue blandit nunc, eu sollicitudin urna dolor sagittis lacus.
            </p>
        <div class="row">
            <div class="col-sm-3">
                 <figure class="wow fadeInLeft animated portfolio-item" data-wow-duration="500ms" data-wow-delay="0ms">
                    <div class="img-wrapper">
                        <img src="../images/portfolio/item-1.jpg" class="img-responsive" alt="this is a title" >
                    </div>
                    <figcaption>
                        <h4>
                         	회원 상세정보
                        </h4>
                        <p>
                            Redesigne UI Concept
                        </p>
                        <form action="detailCustomer.do" method = "post">
							<input type = "submit" value="회원 상세정보" class="btn btn-primary">
						</form>
                    </figcaption>
                </figure>
            </div>

            <div class="col-sm-3">
                <figure class="wow fadeInLeft animated" data-wow-duration="500ms" data-wow-delay="300ms">
                    <div class="img-wrapper">
                        <img src="../images/portfolio/item-2.jpg" class="img-responsive" alt="this is a title" >
                    </div>
                    <figcaption>
                        <h4>
                         	예약 내역
                        </h4>
                        <p>
                            Lorem ipsum dolor sit.
                        </p>
                        <form action="resList.do" method = "post">
							<input type = "submit" value = "예약 내역" class="btn btn-success">
						</form>
                    </figcaption>
                </figure>
            </div>

            <div class="col-sm-3">
                <figure class="wow fadeInLeft animated" data-wow-duration="500ms" data-wow-delay="300ms">
                    <div class="img-wrapper">
                        <img src="../images/portfolio/item-3.jpg" class="img-responsive" alt="" >
                    </div>
                    <figcaption>
                        <h4>
                         	 아이관리
                        </h4>
                        <p>
                            Lorem ipsum dolor sit amet.
                        </p>
                        <form action="/DDOCDOC/child.index.html" method = "post">
							<input type = "submit" value="아이관리" class="btn btn-info">
						</form>
                    </figcaption>
                </figure>
            </div>

            <div class="col-sm-3">
                <figure class="wow fadeInLeft animated" data-wow-duration="500ms" data-wow-delay="600ms">
                    <div class="img-wrapper">
                        <img src="../images/portfolio/item-4.jpg" class="img-responsive" alt="" >
                    </div>
                    <figcaption>
                        <h4>
                           	 마이페이지
                        </h4>
                        <p>
                            Lorem ipsum dolor.
                        </p>
                        <form action="myPageForm.do" method="post">
							<input type = "submit" value = "마이페이지" class="btn btn-warning">
						</form>
                    </figcaption>
                </figure>
            </div>
        </div>
    </div>
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