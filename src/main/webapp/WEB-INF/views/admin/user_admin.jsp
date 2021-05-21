<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>HappyHouse</title>

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
  <script type="text/javascript">
  function searchMember() {
		if(document.getElementById("word").value == "") {
			alert("모든 목록 조회!!");
		}
		document.getElementById("searchform").action = "";
		document.getElementById("searchform").submit();
	}
  </script>
</head>

<body>
    <!-- ======= Header ======= -->
<jsp:include page="/WEB-INF/views/include/header.jsp"/>
<!-- End Header -->

  <div class="jumbotron jumbotron-fluid">
    <picture >
      <img src="assets/img/bg-index.jpg" class="jumbotron__background">
    </picture>
    <div class="container text-white text-center">
      <h1 class="display-4">Administration</h1>
      <p class="lead"></p>
    </div>
  </div>
  <!-- /.jumbotron -->

  <main id="main">
    <section id="" class="">
      <div class="container">
        <div class="row">
          <div class="col-12 mb-3">
            <form id="searchform" method="get" class="form-inline" action="">
	  <input type="hidden" name="action" id="action" value="list">
	  <table class="table table-borderless">
	  	<tr>
	  		<td align="right">
		  	  <select class="form-control" name="key" id="key" value="${key}">
			    <option value="userid" selected="selected">아이디</option>
			    <option value="username">이름</option>
			    <option value="email">이메일</option>
			  </select>
			  <input type="text" class="form-control" placeholder="검색어 입력." name="word" id="word" value="${word}">
			  <button type="button" class="btn btn-primary" onclick="javascript:searchMember();">검색</button>
			</td>
	  	</tr>
	  </table>
	  </form>
          <div class="col-12 mb-3">
            <!-- <div class="d-inline-block">
              <button id="all-select" type="button" class="btn btn-secondary">전체선택</button>
              <button type="button" class="btn btn-danger">선택삭제</button>
            </div> -->
            </div>
          </div>
          <div class="col-12">
    <c:if test="${not empty members}">
	  <!-- 등록된 회원이 있을경우 목록출력 -->
	  <c:set var="t" value="1"></c:set>
	  <table class="table table-bordered">
              <thead>
                <tr>
                  <th scope="col">No</th>
                  <th scope="col">ID</th>
                  <th scope="col">이름</th>
                  <th scope="col">이메일</th>
                  <th scope="col">주소</th>
                </tr>
              </thead>
              <tbody>
	  <c:forEach var='member' items='${members}'>
                <tr>
                  <td>
                    <div class="custom-control custom-checkbox user-select">
                        <input type="checkbox" class="custom-control-input" id="customCheck1" checked>
                        <label class="custom-control-label" for="customCheck1">${t}</label>
                    </div>
                  </td>
                  <td>${member.userId}</td>
                  <td>${member.userName}</td>
                  <td>${member.email}</td>
                  <td>${member.address}</td>
                </tr>
	  </c:forEach>
              </tbody>
            </table>
            <input type="hidden" value="${t=t+1}">
		
	  	</c:if>
	  <!-- 등록된 회원이 없을경우 출력 -->
	  <c:if test="${empty members}">
	  <table class="table table-active">
	    <tbody>
	      <tr class="table-info" align="center">
	        <td>등록된 회원이 없습니다.</td>
	      </tr>
	    </tbody>
	  </table>
	</c:if>
	  </div>
	</div>
          <div class="col-12 mt-3">
            <ul class="pagination justify-content-center">
              <li class="page-item"><a class="page-link" href="#">Previous</a></li>
              <li class="page-item"><a class="page-link" href="#">1</a></li>
              <li class="page-item active"><a class="page-link" href="#">2</a></li>
              <li class="page-item"><a class="page-link" href="#">3</a></li>
              <li class="page-item"><a class="page-link" href="#">Next</a></li>
            </ul>
          </div>
        </div>
      </div>  
    
    </section><!-- End About Section -->
    
  </main><!-- End #main -->

	<!-- ======= Footer ======= -->
	<jsp:include page="/WEB-INF/views/include/footer.jsp" />
	<!-- End Footer -->

  <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>


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