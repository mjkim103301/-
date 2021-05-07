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

			<form id="search-using-word" onsubmit="searchPlaces(); return false;">
				<!-- <input type="hidden" name="action" id="action" value="listHouseDeal"> -->
				<div class="row mb-4">
				<!-- 	<select class="search-do-Condition mr-2" style="height: 40px;"
						name="city" id="city">
						<option value="all">광역시/도</option>
						<option>서울특별시</option>
						<option>경기도</option>
						<option>인천광역시</option>
					</select> <select class="search-gu-Condition mr-2" name="gugun" id="gugun">
						<option value="all">시/구/군</option>
						<option>강남구</option>
						<option>강북구</option>
						<option>용산구</option>
					</select> <select class="search-dong-Condition mr-2" name="dong" id="dong">
						<option value="all">동</option>
						<option>역삼동</option>
						<option>신당동</option>
					</select>  -->
					<input id="keyword" type="text" class="form-control mr-2"
						placeholder="지역, 아파트 검색" style="width: 200px;">
					<button  class="btn btn-success" type="button" >검색</button>

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

				<div id="list_wrap" class="col-sm-3" style="overflow: scroll; height: 650px;">
					<article id="place_list">

						<!-- =====검색결과 list===== -->
						<c:if test="${!empty list}">
							<c:forEach var="item" items="${list}">
								<div class="card border-left-primary shadow h-100 py-2">
									<div class="card-body">
										<div class="row no-gutters align-items-center">
											<div class="col-sm-4">
												<img class="img-fluid " src="img/apartment/apartimg01.jpg"
													alt="" />
											</div>
											<div class="col-sm-7 ml-4">

												<div
													class="h5 mb-0 font-weight-bold text-primary text-gray-800">${item.aptName}</div>
												<div class="text-xs mb-0 text-gray-800">거래금액 :
													${item.dealAmount}</div>
												<div class="text-xs mb-0  text-gray-800">면적:
													${item['area']}</div>
												<div class="text-xs mb-0  text-gray-800">
													거래날짜:
													${item['dealYear']}.${item['dealMonth']}.${item['dealDay']}
													<img src="${root}//img/view-more-arrow.png"
														class="btn-view-more" alt="btnImages"
														style="width: 12%; height: 12%">
												</div>

											</div>

											<!--  =====클릭하면 자세한 설명 나오게끔==== -->
										</div>

									</div>
								</div>

							</c:forEach>
						</c:if>

						<!-- =====검색결과 list가 비어있을 때 가져오는 기본 값===== -->
						<c:if test="${empty list}">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col-sm-4">
											<img class="img-fluid " src="img/apartment/apartimg01.jpg"
												alt="" />
										</div>
										<div class="col-sm-7 ml-4">

											<div
												class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초
												트라움 아파트</div>
											<div class="text-xs mb-0 text-gray-800">실거래가: 69억원</div>
											<div class="text-xs mb-0  text-gray-800">면적: 344m^2</div>
											<div class="text-xs mb-0  text-gray-800">
												거래날짜: 2020.12 <img src="${root}//img/view-more-arrow.png"
													class="btn-view-more" alt="btnImages"
													style="width: 12%; height: 12%">
											</div>
										</div>

										<!--  =====클릭하면 자세한 설명 나오게끔==== -->
									</div>
								</div>
							</div>

							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col-sm-4">
											<img class="img-fluid " src="img/apartment/apartimg02.jpg"
												alt="" />
										</div>
										<div class="col-sm-7 ml-4">

											<div
												class="h5 mb-0 font-weight-bold text-primary text-gray-800">강남
												삼성아이파크</div>
											<div class="text-xs mb-0 text-gray-800">실거래가: 51억원</div>
											<div class="text-xs mb-0  text-gray-800">면적: 209m^2</div>
											<div class="text-xs mb-0  text-gray-800">거래날짜: 2020.10</div>

										</div>

									</div>
								</div>
							</div>
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col-sm-4">
											<img class="img-fluid " src="img/apartment/apartimg03.jpg"
												alt="" />
										</div>
										<div class="col-sm-7 ml-4">

											<div
												class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초
												반포 아크로리버파크</div>
											<div class="text-xs mb-0 text-gray-800">실거래가: 39억원</div>
											<div class="text-xs mb-0  text-gray-800">면적: 149m^2</div>
											<div class="text-xs mb-0  text-gray-800">거래날짜: 2021.02</div>

										</div>

									</div>
								</div>
							</div>
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col-sm-4">
											<img class="img-fluid " src="img/apartment/apartimg03.jpg"
												alt="" />
										</div>
										<div class="col-sm-7 ml-4">

											<div
												class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초
												반포 아크로리버파크</div>
											<div class="text-xs mb-0 text-gray-800">실거래가: 39억원</div>
											<div class="text-xs mb-0  text-gray-800">면적: 149m^2</div>
											<div class="text-xs mb-0  text-gray-800">거래날짜: 2021.02</div>

										</div>

									</div>
								</div>
							</div>
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col-sm-4">
											<img class="img-fluid " src="img/apartment/apartimg03.jpg"
												alt="" />
										</div>
										<div class="col-sm-7 ml-4">

											<div
												class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초
												반포 아크로리버파크</div>
											<div class="text-xs mb-0 text-gray-800">실거래가: 39억원</div>
											<div class="text-xs mb-0  text-gray-800">면적: 149m^2</div>
											<div class="text-xs mb-0  text-gray-800">거래날짜: 2021.02</div>

										</div>

									</div>
								</div>
							</div>
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col-sm-4">
											<img class="img-fluid " src="img/apartment/apartimg03.jpg"
												alt="" />
										</div>
										<div class="col-sm-7 ml-4">

											<div
												class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초
												반포 아크로리버파크</div>
											<div class="text-xs mb-0 text-gray-800">실거래가: 39억원</div>
											<div class="text-xs mb-0  text-gray-800">면적: 149m^2</div>
											<div class="text-xs mb-0  text-gray-800">거래날짜: 2021.02</div>

										</div>

									</div>
								</div>
							</div>
						</c:if>
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

	<!-- 카카오 맵 js -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c4c8e04658a5aa22ab7e8258713d9b0e&libraries=services"></script>
	<script src="js/kakao_map.js"></script>
	

</body>

</html>