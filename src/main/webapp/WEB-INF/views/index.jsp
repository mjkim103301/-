<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html lang="ko">

<head>
<meta charset="utf-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>HappyHouse</title>
<!-- push  -->
<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="vendor/venobox/venobox.css" rel="stylesheet">
<link href="vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="css/style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>
	<!-- ======= Header ======= -->
	<jsp:include page="include/header.jsp" />
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<section id="hero" class="d-flex flex-column justify-content-center align-items-center">
		<div class="container text-center text-md-left" data-aos="fade-up">
			<h1>Welcome to HappyHouse</h1>
			<h2>HappyHouse에서 주택 실거래가를 검색하고 상권 정보와 환경 정보를 볼 수 있어요!</h2>
			<a href="housedeal" class="btn-get-started scrollto">실거래가 검색하러 가기</a>
		</div>
		<div class="container text-center text-md-left" data-aos="fade-up" style="padding-top:10%">
			<div class="NewsTables row text-white">
				<!-- 최고 거래가 Article Start  -->
				<article class="article_price col ">
					<h3>이번주 거래가 순위</h3>
					<table class="table table_striped text-white">
						<thead >
							<tr>
								<th class="title">아파트이름</th>
								<th>가격</th>
							</tr>
						</thead>
						<tbody>
							<tr>
								<td>헤라팰리스</td>
								<td>00억</td>
							</tr>
							<tr>
								<td>A아파트</td>
								<td>00억</td>
							</tr>
							<tr>
								<td>B아파트</td>
								<td>00억</td>
							</tr>
						</tbody>
					</table>
				</article>
				<!-- 인기글 Article End  -->

				<!-- 뉴스 Article Start  -->
				<article class="article_news col ">
					<h3>부동산 뉴스</h3>
					<table class="table table_bordered table_hover text-white">
						<thead>
							<tr>
								<th class="title">기사 제목</th>
							</tr>
						</thead>
						<tbody >
							<tr>
								<td><a href="http://www.m-i.kr/news/articleView.html?idxno=805952" class="text-white">LH 직원 20명 투기 의심…“부동산 투기와의 전쟁 선포”</a></td>
							</tr>
							<tr>
								<td><a href="http://www.segye.com/newsView/20210311516931?OutUrl=naver" class="text-white">지난해 집값 9.3% ‘껑충’…주요국 중 상승률 최고</a></td>

							</tr>
							<tr>
								<td><a href="http://www.newstomato.com/ReadNews.aspx?no=1029110" class="text-white">전세난, 임대주택으로 해법 찾는다</a></td>
							</tr>
						</tbody>
					</table>
					
				</article>
			</div>
			</div>
	</section>



	<!-- End Hero -->

	<main id="main"> <!-- ======= Services Section ======= -->
	<section id="services" class="services section-bg">
		<div class="container">

			<div class="section-title" data-aos="fade-up">
				<h2>Services</h2>
				<p>저희 HappyHouse에서 제공하는 서비스들은 아래와 같습니다.</p>
			</div>

			<div class="row">

				<div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up">

					<div class="icon-box icon-box-pink">
						<a href="housedeal" class="text-dark">
							<div class="icon">
								<i class="bx bx-tachometer"></i>
							</div>
							<h4 class="title">실거래가 검색</h4>
							<p class="description">선택한 지역의 아파트 실거래가를 동별로 그리고 아파트별로 검색할 수 있습니다.</p>
						</a>
					</div>

				</div>

				<div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="100">

					<div class="icon-box icon-box-cyan">
						<a href="${root }/main.do?action=mvShopInfo" class="text-dark">
							<div class="icon">
								<i class="bx bxl-dribbble"></i>
							</div>
							<h4 class="title">주변 상권 정보</h4>
							<p class="description">선택한 아파트 주변 동네업종 정보를 확인할 수 있습니다.</p>
						</a>
					</div>

				</div>

				<div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="200">


					<div class="icon-box icon-box-green">
						<a href="${root }/main.do?action=mvPollutionInfo" class="text-dark">
							<div class="icon">
								<i class="bx bx-world"></i>
							</div>
							<h4 class="title">대기오염 정보</h4>
							<p class="description">선택한 지역의 미세먼지 농도 등의 대기오염 정보를 확인할 수 있습니다.</p>
						</a>
					</div>

				</div>

				<div class="col-md-6 col-lg-3 d-flex align-items-stretch mb-5 mb-lg-0" data-aos="fade-up" data-aos-delay="300">

					<div class="icon-box icon-box-blue">
						<a href="${root }/main.do?action=mvNotice" class="text-dark">
							<div class="icon">
								<i class="bx bx-file"></i>
							</div>
							<h4 class="title">공지사항</h4>
							<p class="description">관리자는 공지사항을 작성, 수정, 삭제, 검색할 수 있습니다.</p>
						</a>
					</div>
				</div>

			</div>

		</div>
	</section>

	<!-- ======= About Section ======= -->
	<section id="about" class="about">
		<div class="container">

			<div class="row">
				<div class="col-xl-6 col-lg-7" data-aos="fade-right">
					<img src="img/about-bg.jpeg" class="img-fluid" alt="">
				</div>
				<div class="col-xl-6 col-lg-5 pt-5 pt-lg-0">
					<h3 data-aos="fade-up">About Happy House</h3>
					<p data-aos="fade-up">SSAFY 5기 8반 김민지 박재준 진미령 Backend Project 입니다.</p>
					<div class="icon-box" data-aos="fade-up">
						<i class="bx bx-receipt"></i>
						<h4>관리자 아이디와 비밀번호</h4>
						<p>관리자 아이디는 'admin'이고 비밀번호도 'admin'입니다.</p>
					</div>

					<div class="icon-box" data-aos="fade-up" data-aos-delay="100">
						<i class="bx bx-cube-alt"></i>
						<h4>Servlet과 JSP</h4>
						<p>Servlet과 JSP를 사용한 웹 백엔드 프로젝트입니다.</p>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!-- ======= Team Section ======= -->
	<section id="team" class="team">
		<div class="container">

			<div class="section-title" data-aos="fade-up">
				<h2>Team</h2>
				<p>서울 8반 4조 박재준 김민지 진미령 입니다.</p>
			</div>

			<div class="row">

				<div class="col" data-aos="fade-up">
					<div class="member">
						<img src="img/team/박재준.jpg" class="img-fluid" alt="">
						<div class="member-info">
							<div class="member-info-content">
								<h4>박재준</h4>
							</div>
							<div class="social">
								<a href="https://www.instagram.com/jjoonjjoonii/"><i class="icofont-facebook"></i></a> <a href="https://www.instagram.com/jjoonjjoonii/"><i class="icofont-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>

				<div class="col" data-aos="fade-up" data-aos-delay="100">
					<div class="member">
						<img src="img/team/김민지.jpg" class="img-fluid" alt="">
						<div class="member-info">
							<div class="member-info-content">
								<h4>김민지</h4>
							</div>
							<div class="social">
								<a href="https://www.instagram.com/_minzikim/"><i class="icofont-facebook"></i></a> <a href="https://www.instagram.com/_minzikim/"><i class="icofont-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>

				<div class="col" data-aos="fade-up" data-aos-delay="100">
					<div class="member">
						<img src="img/team/진미령.jpg" class="img-fluid" alt="">
						<div class="member-info">
							<div class="member-info-content">
								<h4>진미령</h4>
							</div>
							<div class="social">
								<a href="https://www.instagram.com/mirrrong__jj/"><i class="icofont-facebook"></i></a> <a href="https://www.instagram.com/mirrrong__jj/"><i class="icofont-instagram"></i></a>
							</div>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section>
	<!-- End Team Section --> </main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<footer id="footer">
		<div class="footer-top">
			<div class="container">
				<div class="row">

					<div class="col-lg-3 col-md-6">
						<div class="footer-info">
							<h3>HappyHouse</h3>
							<h5>SSAFY 5th 서울 8반</h5>
							<h5>박재준 김민지 진미령</h5>
						</div>
					</div>

					<div class="col-lg-2 col-md-6 footer-links">
						<h4>Links</h4>
						<ul>
							<li><i class="bx bx-chevron-right"></i> <a href="#">Home</a></li>
							<li><i class="bx bx-chevron-right"></i> <a href="#">About us</a></li>
						</ul>
					</div>
				</div>
			</div>
		</div>

		<div class="container">
			<div class="copyright">
				&copy; Copyright <strong><span>Maxim</span></strong>. All Rights Reserved
			</div>
			<div class="credits">
				Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
			</div>
		</div>
	</footer>
	<!-- End Footer -->

	<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

	<!-- SignUp Modal -->
	<div class="modal" id="signupModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title text-center mt-3">Create Account</h4>
						<form>
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-user"></i>
									</span>
								</div>
								<input name="" class="form-control" placeholder="ID" type="text">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>
								<input class="form-control" placeholder="Create password" type="password">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>
								<input class="form-control" placeholder="Repeat password" type="password">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="far fa-smile"></i></span>
								</div>
								<input name="" class="form-control" placeholder="Name" type="text">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-envelope"></i>
									</span>
								</div>
								<input name="" class="form-control" placeholder="Email address" type="email">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="far fa-address-card"></i></span>
								</div>
								<button type="address" class="form-control text-left bg-light" id="address-pop">Click to input Address</button>
								<input type="address" class="form-control" id="address" style="display: none;">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="fas fa-map-marker-alt"></i></span>
								</div>
								<input name="" class="form-control" placeholder="상세 주소" type="address2">
							</div>
							<!-- form-group// -->
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block" data-dismiss="modal">가입하기</button>
							</div>
							<!-- form-group// -->
							<p class="text-center">
								Have an account? <a data-dismiss="modal" data-toggle="modal" href="#loginModal">Log In</a>
							</p>
						</form>
					</article>
				</div>
			</div>
		</div>
	</div>			
	
	<!-- Vendor JS Files -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="vendor/php-email-form/validate.js"></script>
	<script src="vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="vendor/venobox/venobox.min.js"></script>
	<script src="vendor/aos/aos.js"></script>

	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	<!-- Template Main JS File -->
	<script src="js/main.js"></script>
	<script src="js/user.js"></script>

</body>

</html>