<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String root = request.getContextPath();
	System.out.println(root + "regist.jsp");
%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta content="width=device-width, initial-scale=1.0" name="viewport">
<title>회원 등록</title>
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
</head>
<script type="text/javascript">
				function register() {
					//TODO:  아이디 중복검사 했는지 
					if(document.getElementById("hiddenidcheck").value=="idUncheck"){
						alert("아이디 중복검사 하세요!")
						return
					}else if(document.getElementById("userpwd")==""){
						alert("비밀번호를 입력하세요!")
						return
					}else if(document.getElementById("address")==""){
						alert("주소를 입력하세요!")
						return
					}
					else if(document.getElementById("email")==""){
						alert("이메일을 입력하세요!")
						return
					}else if(document.getElementById("userpwdCheck").value!=document.getElementById("userpwd").value){
						console.log('userpwdCheck>> ',document.getElementById("userpwdCheck").value)
						console.log('userpwd>> ',document.getElementById("userpwd").value)
						alert("비밀번호가 일치하지 않습니다!")
						return
					}else{
						document.getElementById("insertform").action = "<%=root%>/main.do"
						document.getElementById("insertform").submit()
					}
					
					
				}
				
				function idValid() {
					window.name="parentForm"
					window.open("id-check-form.jsp", "checkForm", "width=700, height=300, resizable=no, scorollbars=no") 
				}
				
				//아이디 입력값 변경했을 때
				function idChange(){
					document.insertform.hiddenidcheck.value="idUncheck"
				}
			</script>

<body>
	<jsp:include page="/header.jsp" />
	<div class="jumbotron jumbotron-fluid">
		<picture> <img src="assets/img/bg-index.jpg" class="jumbotron__background"> </picture>
		<div class="container text-white text-center">
			<h1 class="display-4">회원 가입</h1>
			<p class="lead"></p>
		</div>
	</div>
	<div class="container">
		<h2 class="mt-4 mb-4">회원 가입</h2>
		<form id="insertform" action="" method="post" name="insertform">
			<input type="hidden" name="action" value="regist">
			<div class="form-group">
				<label for="userid">아이디 :</label>

				<div class="row ml-0">
					<!-- <input type="hidden" name="action idValid" value="idUncheck"> -->
					<input type="hidden" id="hiddenidcheck" name="hiddenidcheck" value="idUncheck"> <input type="text" class="form-control col-sm-8 mr-3" id="userid" placeholder="아이디 입력" name="userid" onkeydown="idChange()">
					<button type="button" class="btn btn-primary col-sm-3" onclick="javascript:idValid();">중복 검사</button>
				</div>

				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">아이디를 입력하세요!</div>

			</div>
			<div class="form-group">
				<label class="" for="userpwd">비밀번호 :</label> <input type="password" class="form-control" id="userpwd" placeholder="비밀번호 입력" maxlength="20" name="userpwd">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">비밀번호를 입력하세요!</div>
			</div>
			<div class="form-group">
				<label class="" for="userpwd">비밀번호 확인 :</label> <input type="password" class="form-control" id="userpwdCheck" placeholder="비밀번호 입력" maxlength="20" name="userpwdCheck">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">비밀번호를 한번 더입력하세요!</div>
			</div>
			<div class="form-group">
				<label class=" " for="name">이름 :</label> <input type="text" class="form-control" id="name" placeholder="이름 입력" name="name">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">이름을 입력하세요!</div>
			</div>
			<div class="form-group">
				<label class=" " for="address">주소 :</label> <input type="text" class="form-control" id="address" placeholder="주소 입력" name="address">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">주소를 입력하세요!</div>
			</div>
			<div class="form-group">
				<label class="" for="email">이메일 :</label> <input type="text" class="form-control" id="email" placeholder="이메일 입력" name="email">
				<div class="valid-feedback">Valid.</div>
				<div class="invalid-feedback">이메일을 입력하세요!</div>
			</div>
			<div class="mb-4">
				<button id="regist" type="button" class="btn btn-primary" onclick="javascript:register();">등록</button>
				<button id="registX" type="button" class="btn btn-secondary ml-2" onclick="">취소</button>
			</div>
		</form>
	</div>
</body>

</html>