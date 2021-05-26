<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">

<title>HappyHouse</title>
<!-- push  -->
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

<!-- Vendor CSS Files -->
<link rel="stylesheet" href="css/kakao_map.css" />

<!-- Template Main CSS File -->
<link href="css/style.css" rel="stylesheet">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
</head>

<body>

	<!-- ======= Header ======= -->

	<jsp:include page="/WEB-INF/views/include/header.jsp" />

	<!-- End Header start-->

	<!-- ======= 검색 메뉴 start ======= -->
	<div style="margin-top: 3%"></div>
	<section class="features section-bg">
		<div class="container">
			<h4>아파트/주택 실거래가 검색</h4>
			<!-- onsubmit="searchPlaces(); return false;" -->
			<form id="search-using-word" >
				<!-- <input type="hidden" name="action" id="action" value="listHouseDeal"> -->
				<div class="row mb-4">

					<input id="keyword" type="text" class="form-control mr-2"
						placeholder="지역, 아파트 검색" style="width: 200px;">
					<button class="btn btn-success" type="submit">검색</button>
					<button class="btn btn-success" type="submit" style="visibility:hidden"></button>
					<button class="btn btn-warning" type="button" onclick="interestedAreaRegister()">관심지역 등록</button>
				</div>
			</form>
		</div>
	</section>
	<!-- End 검색메뉴 -->


	<main id="main">
		<!-- ======= MAP Section ======= -->
		<section id="features" class="page-section features"
			style="padding: 0">

			<div class="row">
				<!--===== 검색 결과 부분===== -->

				<div id="list_wrap" class="col-sm-3"
					style="overflow: scroll; height: 650px;">
					<article id="place_list">

						<!-- =====검색결과 list===== -->					
					</article>

				</div>
				<div id="actual_price_map" class="col-sm-9"
					style="width: 100%; height: 650px"></div>

			</div>


		</section>



	</main>

	<!-- Vendor JS Files -->
	<script src="vendor/jquery/jquery.min.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
	<script src="vendor/jquery.easing/jquery.easing.min.js"></script>
	<script src="vendor/php-email-form/validate.js"></script>
	<script src="vendor/owl.carousel/owl.carousel.min.js"></script>
	<script src="vendor/isotope-layout/isotope.pkgd.min.js"></script>
	<script src="vendor/venobox/venobox.min.js"></script>
	<script src="vendor/aos/aos.js"></script>

	<script
		src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

	<!-- Template Main JS File -->
	<script src="js/main.js"></script>
	<script src="js/user.js"></script>
	<script src="js/interested_area.js"></script>

	<!-- 카카오 맵 js -->
	<script type="text/javascript"
		src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c4c8e04658a5aa22ab7e8258713d9b0e&libraries=services"></script>
	<script src="js/actual_price_map.js"></script>


</body>

</html>