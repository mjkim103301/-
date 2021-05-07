<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="root" value="${pageContext.request.contextPath }" />

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<title>아이디 중복 검사</title>
<!-- Vendor CSS Files -->
<link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
<link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
<link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
<link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
<link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
<link href="assets/vendor/aos/aos.css" rel="stylesheet">
</head>
<script type="text/javascript">


			//회원가입창의 아이디 input value 가져와서 중복검사 input 값 채우기
			function getPValue() {
				document.getElementById("id").value = opener.document.insertform.userid.value;
			}

			//아이디 특수문자, 한글인지 체크
			// 중복체크
			function idCheck() {
				var id = document.getElementById("id").value;
				var specialPattern= /[~!@#$%^&*()_+|<>?:{}]/; //특수문자
				var koreanPattern= /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/; // 한글

				if (!id) {
					alert("아이디를 입력하세요!")
					return false
				} else if (specialPattern.test(id) ||koreanPattern.test(id) ) {
					alert("한글 및 특수문자는 사용할 수 없습니다.")
					return false
				} else {
					document.getElementById("checkForm").action = "${root}/main.do"
					document.getElementById("checkForm").submit()

				}

			}


			//사용하기 버튼 클릭
			function useId() {
				
				opener.document.insertform.hiddenidcheck.value = "idChecked"
				opener.document.insertform.userid.value = document.getElementById("id").value
			
				if (opener != null) {
					opener.checkForm = null
					self.close()
				}
			}

		</script>

<body onload="javascript:getPValue();">

	<h2>아이디 중복 검사</h2>
	
	<form id="checkForm" class="form-inline" method="post" action="">
		<input type="hidden" name="action" value="idCheck" />

			<input type="text" class="form-control" placeholder="아이디 입력" id="id" name="id" value="  <c:if test="${not empty result }">  ${result.userid} </c:if>" />


		<button type="button" class="btn btn-primary" onclick="javascript:idCheck();">중복검사</button>
	</form>
	
	<button type="button" class="btn btn-primary" onclick="window.close();">취소</button>
	
	<c:if test="${ not empty result and (false eq result.canUseId) }">
		<div>이미 사용중인 아이디입니다.</div>
	</c:if>
	
	
	<c:if test="${ not empty result and ( true eq result.canUseId) }">
		<div>사용 가능한 아이디입니다.</div>
		<button id="btn_idUse" type="button" class="btn btn-primary" onclick="javascript:useId();">사용하기</button>
	</c:if>


</body>

</html>