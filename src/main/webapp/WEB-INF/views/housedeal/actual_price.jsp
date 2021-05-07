<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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

<!-- Vendor CSS Files -->
<link rel="stylesheet" href="assets/css/kakaoMap.css" />

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
	function listHouseDeal() {
		document.getElementById("search-using-word").action = "${root}/main.do";
		document.getElementById("search-using-word").submit();
	}
	
	$(function(){
		// 시, 도 정보 불러오기
		$(document).on('click', '#city', function(){
			$.ajax({
				url:'main.do?action=citySearch',
				dataType:'json',
				success:processCityResult,
				error:function(err){
					console.log(err)
				}
			})
		})
		
		// 도시 정보 변경화면
		$('#city').change( function(){
			var city=$(this).val();
			console.log('city 선택', city)
			$.ajax({
				url:'main.do?action=gugunSearch',
				data:{
					local:city
				},
				dataType:'json',
				success:processGugunResult,
				error:function(err){
					console.log(err)
				}
			})
		})
	})
</script>
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

			<form id="search-using-word" method="post" action="">
				<input type="hidden" name="action" id="action" value="listHouseDeal">
				<div class="row mb-4">
					<select class="search-do-Condition mr-2"  style="height: 40px;" name="city" id="city">
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
					</select> <input id="word" name="word" type="text" class="form-control mr-2" placeholder="아파트 이름" style="width: 200px;">
					<button class="btn btn-success" type="button" id="searchHouseDeal" onclick="javascript:listHouseDeal();">검색</button>

				</div>
			</form>
		</div>
	</section>
	<!-- End 검색메뉴 -->


	<main id="main"> <!-- ======= MAP Section ======= -->
	<section id="features" class="page-section features" style="padding: 0">

		<div class="row">
			<!--===== 검색 결과 부분===== -->

			<div class="col-sm-3" style="overflow: scroll; height: 650px;">
				<article>

					<!-- =====검색결과 list===== -->
					<c:if test="${!empty list}">
						<c:forEach var="item" items="${list}">
							<div class="card border-left-primary shadow h-100 py-2">
								<div class="card-body">
									<div class="row no-gutters align-items-center">
										<div class="col-sm-4">
											<img class="img-fluid " src="assets/img/apartment/apartimg01.jpg" alt="" />
										</div>
										<div class="col-sm-7 ml-4">

											<div class="h5 mb-0 font-weight-bold text-primary text-gray-800">${item.aptName}</div>
											<div class="text-xs mb-0 text-gray-800">거래금액 : ${item.dealAmount}</div>
											<div class="text-xs mb-0  text-gray-800">면적: ${item['area']}</div>
											<div class="text-xs mb-0  text-gray-800">거래날짜: ${item['dealYear']}.${item['dealMonth']}.${item['dealDay']} 
												<img src="${root}/assets/img/view-more-arrow.png" class="btn-view-more" alt="btnImages" style="width: 12%; height: 12%">
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
										<img class="img-fluid " src="assets/img/apartment/apartimg01.jpg" alt="" />
									</div>
									<div class="col-sm-7 ml-4">

										<div class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초 트라움 아파트</div>
										<div class="text-xs mb-0 text-gray-800">실거래가: 69억원</div>
										<div class="text-xs mb-0  text-gray-800">면적: 344m^2</div>
										<div class="text-xs mb-0  text-gray-800">
											거래날짜: 2020.12 <img src="${root}/assets/img/view-more-arrow.png" class="btn-view-more" alt="btnImages" style="width: 12%; height: 12%">
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
										<img class="img-fluid " src="assets/img/apartment/apartimg02.jpg" alt="" />
									</div>
									<div class="col-sm-7 ml-4">

										<div class="h5 mb-0 font-weight-bold text-primary text-gray-800">강남 삼성아이파크</div>
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
										<img class="img-fluid " src="assets/img/apartment/apartimg03.jpg" alt="" />
									</div>
									<div class="col-sm-7 ml-4">

										<div class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초 반포 아크로리버파크</div>
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
										<img class="img-fluid " src="assets/img/apartment/apartimg03.jpg" alt="" />
									</div>
									<div class="col-sm-7 ml-4">

										<div class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초 반포 아크로리버파크</div>
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
										<img class="img-fluid " src="assets/img/apartment/apartimg03.jpg" alt="" />
									</div>
									<div class="col-sm-7 ml-4">

										<div class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초 반포 아크로리버파크</div>
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
										<img class="img-fluid " src="assets/img/apartment/apartimg03.jpg" alt="" />
									</div>
									<div class="col-sm-7 ml-4">

										<div class="h5 mb-0 font-weight-bold text-primary text-gray-800">서초 반포 아크로리버파크</div>
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
			<div id="actual-price-map" class="col-sm-9" style="width: 100%; height: 650px"></div>

		</div>


	</section>



	<!-- 	<div class="container">
		<div class="row">
			<div class="col-lg-4 mb-5 mb-lg-0" data-aos="fade-right">
				<ul class="nav nav-tabs flex-column">

					<li class="nav-item mt-2"><a class="nav-link" data-toggle="tab" href="#srcdong">
							<h4>아파트/주택 실거래가 검색</h4>
					</a></li>

				</ul>

			</div>
			<div class="col-lg-7 ml-auto" data-aos="fade-left">
				<div class="tab-content">

					<div class="tab-pane active show" id="srcdong">
						<div class="container mt-3">
							카카오 맵
							<div id="map" style="width: 500px; height: 400px;"></div>

							동 또는 아파트 이름으로 검색
							<form id="search-using-word" method="post" action="">
								<input type="hidden" name="action" id="action" value="listHouseDeal">
								<div class="input-group mb-3 mt-2">
									<select class="form-control" name="key" id="key">
										<option name="dong" value="dong" selected="selected">동</option>
										<option name="AptName" value="AptName" selected="selected">아파트</option>
									</select> <input id="word" name="word" type="text" class="form-control">

									<div class="input-group-append">

										<button class="btn btn-success" type="button" id="searchHouseDeal" onclick="javascript:listHouseDeal();">검색</button>
									</div>

								</div>
							</form>

						</div>
					</div>

				</div>
			</div>
		</div>
	</div> --> <%-- <!-- End Features Section -->
					<!-- Result Section -->
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

						</div>
					</section> --%> </main>

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

	<!-- 카카오 맵 js -->
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c4c8e04658a5aa22ab7e8258713d9b0e"></script>
	<script src="assets/js/kakaoMap.js"></script>

</body>

</html>