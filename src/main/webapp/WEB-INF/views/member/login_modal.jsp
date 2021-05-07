<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link href="css/style.css" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script type="text/javascript">
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
			let userid = document.getElementById("id-input").value;
			let userpwd = document.getElementById("pw-input").value;
			let data = ({
				userid	: 	userid,
				userpwd	:	userpwd,
			});
			$.ajax({
		        url : '${root}/login' 
		        , type : 'POST' 
		        , data : JSON.stringify(data)
		        , dataType : 'json' 
		        , contentType : "application/json; charset=UTF-8" 
		        , success: 	function (result) {
					alert("로그인 성공");
					location.href="${root}";
		        }
		       , error:		function(request,status,error){
					alert("로그인 실패" +  status);
		            console.log("error");		 
		        }
		    });
			//document.getElementById("loginform").action = "${root}/main.do";
			//document.getElementById("loginform").submit();
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
<body>

</body>
</html>