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
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<!-- Google Fonts -->
<link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function listHouseDeal() {
		document.getElementById("search-using-word").action = "${root}/main.do";
		document.getElementById("search-using-word").submit();
	}
	$(document).ready(function() {
		// Show the Modal on load
		<c:if test='${not empty msg}'>
		$("#failModal").modal("show");
		</c:if>
		<c:if test='${not empty pass}'>
		$("#showPWModal").modal("show");
		</c:if>
	});
	function login() {
		if (document.getElementById("id-input").value == "") {
			alert("아이디를 입력해주세요");
			return;
		} else if (document.getElementById("pw-input").value == "") {
			alert("비밀번호를 입력해주세요");
			return;
		} else {
			document.getElementById("loginform").action = "${root}/main.do";
			document.getElementById("loginform").submit();
		}
	}
	function findpw() {
		if (document.getElementById("checkid").value == "") {
			alert("아이디를 입력해주세요");
			return;
		} else if (document.getElementById("checkname").value == "") {
			alert("이름을 입력해주세요");
			return;
		} else if (document.getElementById("checkemail").value == "") {
			alert("이메일을 입력해주세요");
			return;
		} else {
			document.getElementById("findpwform").action = "${root}/main.do";
			document.getElementById("findpwform").submit();
		}
	}
</script>
</head>

<body>
	<!-- ======= Header ======= -->
	<jsp:include page="/header.jsp" />
	<!-- End Header -->

	<!-- ======= Hero Section ======= -->
	<section id="hero" class="d-flex flex-column justify-content-center align-items-center">
		<div class="container text-center text-md-left" data-aos="fade-up">
			<h1>Welcome to HappyHouse</h1>
			<h2>HappyHouse에서 주택 실거래가를 검색하고 상권 정보와 환경 정보를 볼 수 있어요!</h2>
			<a href="${root }/main.do?action=mvActualPrice" class="btn-get-started scrollto">실거래가 검색하러 가기</a>
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
						<a href="${root }/main.do?action=mvActualPrice" class="text-dark">
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
					<img src="assets/img/about-bg.jpeg" class="img-fluid" alt="">
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
	<!-- End About Section --> <%-- <!-- End Services Section --> <!-- ======= Features Section ======= -->
	<section id="features" class="features">
		<div class="container">
			<div class="row">
				<div class="col-lg-4 mb-5 mb-lg-0" data-aos="fade-right">
					<ul class="nav nav-tabs flex-column">
						<li class="nav-item"><a class="nav-link active show" data-toggle="tab" href="#map">
								<h4>아파트/주택 실거래가 검색</h4>
						</a></li>
						<li class="nav-item mt-2"><a class="nav-link" data-toggle="tab" href="#detail">
								<h4>실거래가 상세 검색</h4>
						</a></li>
						<li class="nav-item mt-2"><a class="nav-link" data-toggle="tab" href="#srcdong">
								<h4>동 또는 아파트 이름으로 검색해보세요.</h4>
						</a></li>
						<li class="nav-item mt-2"><a class="nav-link" data-toggle="tab" href="#srcapt">
								<h4>아파트 이름으로 검색해보세요.</h4>
						</a></li>
					</ul>
				
				</div>
				<div class="col-lg-7 ml-auto" data-aos="fade-left">
					<div class="tab-content">
						<div class="tab-pane active show" id="map">

							<form>
								<div class="form-group d-inline-block">
									<select class="form-control" id="sel1">
										<option disabled selected>시/도</option>
										<option>서울시</option>
										<option>경기도</option>
										<option>인천시</option>
									</select>
								</div>
								<div class="form-group d-inline-block">
									<select class="form-control" id="sel2">
										<option disabled selected>시/구/군</option>
										<option>종로구</option>
										<option>용산구</option>
										<option>마포구</option>
									</select>
								</div>
								<div class="form-group d-inline-block">
									<select class="form-control" id="sel3">
										<option disabled selected>동</option>
										<option>청운동</option>
										<option>안국동</option>
										<option>돈의동</option>
									</select>
								</div>
								<div class="form-group d-inline-block">
									<button type="submit" class="btn btn-primary mb-1">검색</button>
								</div>
							</form>
							<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.5607561223096!2d126.74783201543875!3d37.423855740043976!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b7b13aab9ed93%3A0x3abb0d0829c86fdb!2z7Iqk7YOA67KF7IqkIOyduOyynOyEnOywveygkA!5e0!3m2!1sko!2skr!4v1615476247568!5m2!1sko!2skr" width="600" height="450" style="border: 0;"> </iframe>
						</div>
						<div class="tab-pane" id="detail">
							<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.5607561223096!2d126.74783201543875!3d37.423855740043976!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b7b13aab9ed93%3A0x3abb0d0829c86fdb!2z7Iqk7YOA67KF7IqkIOyduOyynOyEnOywveygkA!5e0!3m2!1sko!2skr!4v1615476247568!5m2!1sko!2skr" width="600" height="450" style="border: 0;"> </iframe>
						</div>
						<div class="tab-pane" id="srcdong">
							<div class="container mt-3">
								<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.5607561223096!2d126.74783201543875!3d37.423855740043976!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b7b13aab9ed93%3A0x3abb0d0829c86fdb!2z7Iqk7YOA67KF7IqkIOyduOyynOyEnOywveygkA!5e0!3m2!1sko!2skr!4v1615476247568!5m2!1sko!2skr" width="600" height="300" style="border: 0;"> </iframe>


								<!-- 동 또는 아파트 이름으로 검색 -->
								<form id="search-using-word" method="post" action="">
									<input type="hidden" name="action" id="action" value="listHouseDeal">
									<div class="input-group mb-3 mt-2">
										<select class="form-control" name="key" id="key">
											<option name="dong" value="dong" selected="selected">동</option>
											<option name="AptName" value="AptName" selected="selected">아파트</option>
										</select><input id="word" name="word" type="text" class="form-control">

										<div class="input-group-append">
											<!-- <button class="btn btn-success" type="button" id="searchHouseDeal">검색</button> -->
											<button class="btn btn-success" type="button" id="searchHouseDeal" onclick="javascript:listHouseDeal();">검색</button>
										</div>

									</div>
								</form>
								<select multiple class="form-control" id="sel2" name="sellist2">
									<option>경상남동 양산시 서창동</option>
									<option>광주광역시 서구 서창동</option>
									<option>인천광역시 남동구 장수서창동</option>
								</select>
							</div>
						</div>
						<div class="tab-pane" id="srcapt">
							<div class="container mt-3">
								<iframe src="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3168.5607561223096!2d126.74783201543875!3d37.423855740043976!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x357b7b13aab9ed93%3A0x3abb0d0829c86fdb!2z7Iqk7YOA67KF7IqkIOyduOyynOyEnOywveygkA!5e0!3m2!1sko!2skr!4v1615476247568!5m2!1sko!2skr" width="600" height="300" style="border: 0;"> </iframe>
								<!-- 아파트 이름으로 검색 -->
								<form id="search-using-dong" method="post" action="">

									<input type="hidden" name="action" id="action" value="listHouseDeal">
									<div class="input-group mb-3 mt-2">
										<select class="form-control" name="key" id="key">
											<option name="AptName" value="AptName" selected="selected">아파트 이름</option>
										</select> <input id="word" name="word" type="text" class="form-control" placeholder="아파트 이름으로 검색하세요.">
										<div class="input-group-append">
											<button class="btn btn-success" type="button">검색</button>
										</div>
									</div>
								</form>
								<select multiple class="form-control" id="sel2" name="sellist2">
									<option>역곡4차E편한세상아파트</option>
									<option>역곡대림e편한세상5차아파트</option>
									<option>역곡대림e편한세상3차아파트</option>
									<option>E편한세상2차.예원아파트</option>
									<option>역곡5차E편한세상 입주자대표회의</option>
								</select>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>
	<!-- End Features Section --> <!-- Result Section -->
	<section class="features section-bg">
		<div class="container">
			<div class="section-title" data-aos="fade-up">
				<h2>검색 결과</h2>
			</div>
			<div class="sidebar" id="dealinfo">
				<div class="block clearfix" id="houseInfo">
					<h3 class="title">거래 정보</h3>
					<div class="separator-2"></div>


					<!-- 거래정보가 있을 경우 목록 출력  -->
					<c:if test="${not empty list}">
						<c:forEach var="item" items="${list}">

							<div class="media margin-clear">
								<div class="media-body">
									<h4>
										<a href="javascript:moveMap(37.601645,127.024854,17);">${item.aptName}</a>
									</h4>
									<h6 class="media-heading" id="deal">거래금액 : ${item.dealAmount}</h6>
									<h6 class="media-heading" id="deal">면적: ${item['area']}</h6>
									<p class="small margin-clear">
										<i class="fa fa-calendar pr-10"></i>${item['dealYear']} - ${item['dealMonth']} -${item['dealDay']}
									</p>
								</div>
							</div>
							<hr>
						</c:forEach>
					</c:if>
					<!-- 거래 정보가 없을 경우 출력  -->
					<c:if test="${empty list}">
						<table class="table table-active">
							<tbody>
								<tr class="table-info" align="center">
									<td>검색 조건에 맞는 거래 정보가 없습니다.</td>
								</tr>
							</tbody>
						</table>
					</c:if>
				</div>
			</div>
			<div class="sidebar" id="detailinfo" style="display: none">
				<div class="block clearfix" id="detailhouseInfo">
					<h3 class="title">상세 거래 정보</h3>
					<div class="separator-2"></div>
					<div class="media margin-clear">
						<div class="media-body">
							<h4>
								<a href="javascript:moveMap(37.601645,127.024854,17);">구현대</a>
							</h4>
							<h6 class="media-heading" id="deal">거래금액 : 32,750만원</h6>
							<h6 class="media-heading" id="deal">면적: 66.02</h6>
							<p class="small margin-clear">
								<i class="fa fa-calendar pr-10"></i>2019. 12. 5
							</p>
						</div>
					</div>
					<hr>
					<div class="media margin-clear">
						<div class="media-body">
							<h4>
								<a href="javascript:moveMap(37.6005277,127.023636,17);">길음역금호어울림센터힐</a>
							</h4>
							<h6 class="media-heading" id="deal">거래금액 : 98,000만원</h6>
							<h6 class="media-heading" id="deal">면적: 119.56</h6>
							<p class="small margin-clear">
								<i class="fa fa-calendar pr-10"></i>2019. 12. 16
							</p>
						</div>
					</div>
					<hr>
					<div class="media margin-clear">
						<div class="media-body">
							<h4>
								<a href="javascript:moveMap(37.5972816,127.0208682,17);">대성유니드(641-0)</a>
							</h4>
							<h6 class="media-heading" id="deal">거래금액 : 56,400만원</h6>
							<h6 class="media-heading" id="deal">면적: 84.93</h6>
							<p class="small margin-clear">
								<i class="fa fa-calendar pr-10"></i>2019. 12. 10
							</p>
						</div>
					</div>
					<hr>
					<div class="media margin-clear">
						<div class="media-body">
							<h4>
								<a href="javascript:moveMap(37.5960076,127.0231576,17);">돈암동 풍림아파트 101~105동</a>
							</h4>
							<h6 class="media-heading" id="deal">거래금액 : 49,900만원</h6>
							<h6 class="media-heading" id="deal">면적: 84.68</h6>
							<p class="small margin-clear">
								<i class="fa fa-calendar pr-10"></i>2019. 12. 19
							</p>
						</div>
					</div>
				</div>
			</div>

		</div>
	</section> --%> <!-- ======= Team Section ======= -->
	<section id="team" class="team">
		<div class="container">

			<div class="section-title" data-aos="fade-up">
				<h2>Team</h2>
				<p>서울 8반 4조 박재준 김민지 진미령 입니다.</p>
			</div>

			<div class="row">

				<div class="col" data-aos="fade-up">
					<div class="member">
						<img src="assets/img/team/박재준.jpg" class="img-fluid" alt="">
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
						<img src="assets/img/team/김민지.jpg" class="img-fluid" alt="">
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
						<img src="assets/img/team/진미령.jpg" class="img-fluid" alt="">
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
	<!-- Login Modal -->
	<div class="modal" id="loginModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title text-center mt-3">Login</h4>
						<form id="loginform" method="post" action="">
							<input type="hidden" name="action" id="action" value="login">
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-user"></i>
									</span>
								</div>
								<input name="userid" id="id-input" class="form-control" placeholder="ID" type="text">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-lock"></i>
									</span>
								</div>
								<input name="userpwd" id="pw-input" class="form-control" placeholder="Password" type="password">
							</div>
							<!-- form-group// -->
							<div class="form-group">
								<button type="submit" id="login-btn" class="btn btn-primary btn-block" onclick="javascript:login();" data-dismiss="modal">로그인</button>
							</div>
							<!-- form-group// -->
							<p class="text-center">
								비밀번호를 잊어버리셨나요? <a data-dismiss="modal" data-toggle="modal" href="#findPWModal">비밀번호 찾기</a>
							</p>
						</form>
					</article>
				</div>
			</div>
		</div>
	</div>

	<!-- Find Password Modal -->
	<div class="modal" id="findPWModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title text-center mt-3">비밀번호 찾기</h4>
						<form id="findpwform" method="post" action="">
							<input type="hidden" name="action" id="action" value="findpw">
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-user"></i>
									</span>
								</div>
								<input name="checkid" id="checkid" class="form-control" placeholder="ID" type="text">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"><i class="far fa-smile"></i></span>
								</div>
								<input name="checkname" id="checkname" class="form-control" placeholder="Name" type="text">
							</div>
							<!-- form-group// -->
							<div class="form-group input-group">
								<div class="input-group-prepend">
									<span class="input-group-text"> <i class="fa fa-envelope"></i>
									</span>
								</div>
								<input name="checkemail" id="checkemail" class="form-control" placeholder="Email address" type="email">
							</div>
							<!-- form-group// -->
							<div class="form-group">
								<button type="submit" class="btn btn-primary btn-block" onclick="javascript:findpw();">회원정보 확인</button>
							</div>
							<!-- form-group// -->
							<p class="text-center">회원정보 일치 시 비밀번호가 출력됩니다.</p>
						</form>
					</article>
				</div>
			</div>
		</div>
	</div>
	<!-- Fail Login Modal -->
	<div class="modal" id="failModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title text-center mt-3">${msg}</h4>
					</article>
					<div class="form-group" align="center">
						<button type="submit" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Show PW Modal -->
	<div class="modal" id="showPWModal">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-body">
					<article class="card-body mx-auto" style="max-width: 400px;">
						<h4 class="card-title text-center mt-3">비밀번호는 ${pass} 입니다.</h4>
					</article>
					<div class="form-group" align="center">
						<button type="submit" class="btn btn-primary" data-dismiss="modal">확인</button>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Vendor JS Files -->
	<script src="assets/vendor/jquery/jquery.min.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="assets/vendor/php-email-form/validate.js"></script>
	<script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="assets/vendor/venobox/venobox.min.js"></script>
	<script src="assets/vendor/aos/aos.js"></script>

	<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	<!-- Template Main JS File -->
	<script src="assets/js/main.js"></script>
	<script src="assets/js/user.js"></script>

</body>

</html>