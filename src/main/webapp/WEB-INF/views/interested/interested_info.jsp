<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html lang="ko">

<head>
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>HappyHouse</title>

<!-- Favicons -->
<link href="img/favicon.png" rel="icon">
<link href="img/apple-touch-icon.png" rel="apple-touch-icon">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="vendor/venobox/venobox.css" rel="stylesheet">
<link href="vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="css/style.css" rel="stylesheet">

</head>

<body>
	<!-- ======= Header ======= -->

	<jsp:include page="../include/header.jsp" />

	<div class="jumbotron text-center" style="height: 20vh">
		<h3 class="text-white">관심지역</h3>
		<button type="button" class="btn btn-outline-warning">상권정보</button>
		<button type="button" class="btn btn-outline-light">환경정보</button>

	</div>
	<!-- End Header -->

	<main id="main">

		<section id="" class="p-1">

			<div class="row">

				<div class="col-md-6 col-lg-6 ">

					<div class="">



						<div class="dropdown">
							<button type="button" class="btn btn-primary dropdown-toggle interested_area_select_left"
								data-toggle="dropdown"  onclick="getInterestedAreaListLeft()">
								관심지역 선택하기
							</button>
							<div class="dropdown-menu interested_area_menu_left">
								<a class="dropdown-item" href="#">서울시 00구 00동 </a> 
							</div>
						</div>


						<div id="interested_map_left" style="width: 100%; height: 500px"></div>





						<div class="mb-2">
							<ul class="nav nav-tabs">
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#left_hospital">코로나 안심 병원</a></li>
								<li class="nav-item"><a class="nav-link active"
									data-toggle="tab" href="#left_center">코로나 선별 진료소</a></li>

							</ul>
							<div class="tab-content mb-2">
								<div class="tab-pane fade" id="left_hospital">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>병원 이름</th>
												<th>주소</th>
												<th>연락처</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>John</td>
												<td>Doe</td>
												<td>john@example.com</td>
											</tr>
											<tr>
												<td>Mary</td>
												<td>Moe</td>
												<td>mary@example.com</td>
											</tr>
											<tr>
												<td>July</td>
												<td>Dooley</td>
												<td>july@example.com</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade show active" id="left_center">

									<table class="table table-striped">
										<thead>
											<tr>
												<th>진료소 이름</th>
												<th>주소</th>
												<th>운영시간</th>
												<th>연락처</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>John</td>
												<td>Doe</td>
												<td>john@example.com</td>
												<td>john@example.com</td>
											</tr>
											<tr>
												<td>Mary</td>
												<td>Moe</td>
												<td>mary@example.com</td>
												<td>john@example.com</td>
											</tr>
											<tr>
												<td>July</td>
												<td>Dooley</td>
												<td>july@example.com</td>
												<td>john@example.com</td>
											</tr>
										</tbody>
									</table>
								</div>

							</div>
						</div>
					</div>

				</div>

				<div class="col-md-6 col-lg-6 ">

					<div class="">



						<div class="dropdown">
							<button type="button" class="btn btn-primary dropdown-toggle interested_area_select_right"
								data-toggle="dropdown"  onclick="getInterestedAreaListRight()">
								관심지역 선택하기
								</button>
							<div class="dropdown-menu interested_area_menu_right" >
								<a class="dropdown-item" href="#">서울시 00구 00동</a> <a
									class="dropdown-item" href="#">용인시 00구 00동</a>
							</div>
						</div>


						<div id="interested_map_right" style="width: 100%; height: 500px"></div>





						<div class="mb-2">
							<ul class="nav nav-tabs">
								<li class="nav-item"><a class="nav-link" data-toggle="tab"
									href="#right_hospital">코로나 안심 병원</a></li>
								<li class="nav-item"><a class="nav-link active"
									data-toggle="tab" href="#right_center">코로나 선별 진료소</a></li>

							</ul>
							<div class="tab-content mb-2">
								<div class="tab-pane fade" id="right_hospital">
									<table class="table table-striped">
										<thead>
											<tr>
												<th>병원 이름</th>
												<th>주소</th>
												<th>연락처</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>John</td>
												<td>Doe</td>
												<td>john@example.com</td>
											</tr>
											<tr>
												<td>Mary</td>
												<td>Moe</td>
												<td>mary@example.com</td>
											</tr>
											<tr>
												<td>July</td>
												<td>Dooley</td>
												<td>july@example.com</td>
											</tr>
										</tbody>
									</table>
								</div>
								<div class="tab-pane fade show active" id="right_center">

									<table class="table table-striped">
										<thead>
											<tr>
												<th>진료소 이름</th>
												<th>주소</th>
												<th>운영시간</th>
												<th>연락처</th>
											</tr>
										</thead>
										<tbody>
											<tr>
												<td>John</td>
												<td>Doe</td>
												<td>john@example.com</td>
												<td>john@example.com</td>
											</tr>
											<tr>
												<td>Mary</td>
												<td>Moe</td>
												<td>mary@example.com</td>
												<td>john@example.com</td>
											</tr>
											<tr>
												<td>July</td>
												<td>Dooley</td>
												<td>july@example.com</td>
												<td>john@example.com</td>
											</tr>
										</tbody>
									</table>
								</div>

							</div>
						</div>
					</div>

				</div>
			</div>

		</section>
		<!-- End About Section  -->

	</main>
	<!-- End #main -->

	<!-- ======= Footer ======= -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	<!-- End Footer -->

	<a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

	<!-- Vendor JS Files -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="vendor/php-email-form/validate.js"></script>
	<script src="vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="vendor/venobox/venobox.min.js"></script>
	<script src="vendor/aos/aos.js"></script>

	<!-- Template Main JS File -->
	<script src="js/main.js"></script>
	<script src="js/user.js"></script>
	<script src="js/interested_area.js"></script>

	<!-- 카카오 맵 js -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c4c8e04658a5aa22ab7e8258713d9b0e&libraries=services"></script>
	<script src="js/interested_map_left.js"></script>
	<script src="js/interested_map_right.js"></script>

</body>

</html>