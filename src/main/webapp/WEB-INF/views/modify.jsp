<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>내 정보 수정</title>
<!-- Favicons -->
<link href="assets/img/favicon.png" rel="icon">
<link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.0.8/css/all.css">

<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
	rel="stylesheet">

<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css"
	rel="stylesheet">
<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css"
	rel="stylesheet">
<link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css"
	rel="stylesheet">
<link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">

<!-- Template Main CSS File -->
<link href="assets/css/style.css" rel="stylesheet">
</head>
<body>
<header id="header" class="fixed-top">
		<div class="container d-flex">
			<div class="logo mr-auto">
				<h1 class="text-light d-inline-block">
					<a href="index.html">HappyHouse</a>
				</h1>
				<span class="ml-1"><a href="notice.html">공지사항</a></span>
			</div>
			<nav class="nav-menu d-none d-lg-block">
				<ul>
					<li class="active"><a href="index.html">Home</a></li>
					<li><a href="#about">About Us</a></li>
					<li><a href="#services">Services</a></li>
					<li><a href="#team">Team</a></li>

					<li><a id="login-nav" href=""
						class="login-nav font-weight-bold" data-toggle="modal"
						data-target="#loginModal">Login</a></li>
					<li><a id="signup-nav" href="register.jsp"
						class="signup-nav font-weight-bold" data-toggle="modal">SignUp</a></li>
					<li><a id="logout-nav" href=""
						class="logout-nav font-weight-bold d-none">Logout</a></li>
					<li><a id="mypage-nav" href="mypage.html"
						class="mypage-nav font-weight-bold d-none">MyPage</a></li>
					<!-- 관리자가 로그인했을 때만 -->
					<li><a id="admin-nav" href="userAdmin.html"
						class="admin-nav font-weight-bold d-none">Admin</a></li>
				</ul>
			</nav>
			<!-- .nav-menu -->
			  <h2 class="mt-4 mb-4">내 정보 수정</h2>
  <form action="modify_do.jsp" class="needs-validation" method="post" novalidate>
    <div class="form-group">
      <label class=" "for="uid">아이디 :</label>
      <input type="text" class="form-control" id="uid" placeholder="아이디 입력" name="uid" maxlength="20" required readonly value="">
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">아이디를 입력하세요!</div>
    </div>
    <div class="form-group">
      <label class=" "for="upassword">비밀번호 :</label>
      <input type="password" class="form-control" id="upassword" placeholder="비밀번호 입력" maxlength="20" name="upassword" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">비밀번호를 입력하세요!</div>
    </div>
    <div class="form-group">
      <label class=" "for="uname">이름 :</label>
      <input type="text" class="form-control" id="uname" placeholder="이름 입력" name="uname" maxlength="10" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">이름을 입력하세요!</div>
    </div>
    <div class="form-group">
      <label class=" "for="uadd">주소 :</label>
      <input type="text" class="form-control" id="uadd" placeholder="주소 입력" name="uadd" maxlength="80" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">주를 입력하세요!</div>
    </div>
    <div class="form-group">
      <label class=""for="utel">전화번호 :</label>
      <input type="text" class="form-control" id="utel" placeholder="전화번호 입력" name="utel" maxlength="20" required>
      <div class="valid-feedback">Valid.</div>
      <div class="invalid-feedback">전화번호를 입력하세요!</div>
    </div>
    <div class="form-group form-check">
      <label class="form-check-label">
        <input class="form-check-input" type="checkbox" name="remember" required> 개인정보 활용동의
        <div class="valid-feedback">Valid.</div>
        <div class="invalid-feedback">Check this checkbox to continue.</div>
      </label>
    </div>
    <div class="mb-4">
    <button type="submit" class="btn btn-primary">수정</button>
    <button type="button" class="btn btn-secondary ml-2" onclick="location.href='index.jsp'" >취소</button>
		</div>
</header>















</body>
</html>