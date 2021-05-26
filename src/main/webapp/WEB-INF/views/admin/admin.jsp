<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
    <head>
        <meta charset="utf-8" />
        <meta content="width=device-width, initial-scale=1.0" name="viewport" />

        <title>HappyHouse</title>

        <!-- Favicons -->
        <link href="img/favicon.png" rel="icon" />
        <link href="img/apple-touch-icon.png" rel="apple-touch-icon" />
        <link
            rel="stylesheet"
            href="https://use.fontawesome.com/releases/v5.0.8/css/all.css"
        />

        <!-- Google Fonts -->
        <link
            href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
            rel="stylesheet"
        />

        <!-- Vendor CSS Files -->
        <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet" />
        <link href="vendor/icofont/icofont.min.css" rel="stylesheet" />
        <link href="vendor/boxicons/css/boxicons.min.css" rel="stylesheet" />
        <link
            href="vendor/owl.carousel/assets/owl.carousel.min.css"
            rel="stylesheet"
        />
        <link href="vendor/venobox/venobox.css" rel="stylesheet" />
        <link href="vendor/aos/aos.css" rel="stylesheet" />

        <!-- Template Main CSS File -->
        <link href="css/style.css" rel="stylesheet" />

        <!-- Vue JS -->
        <link href="vue/notice/js/app.js" rel="preload" as="script" />
        <link href="vue/notice/js/chunk-vendors.js" rel="preload" as="script" />
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    </head>

    <body>
        <div class="jumbotron jumbotron-fluid">
            <picture>
                <img src="img/background/page.jpg" class="jumbotron__background" />
            </picture>
            <div class="container text-white text-center">
                <h1 class="display-4">회원 관리</h1>
                <p class="lead"></p>
            </div>
        </div>
        <!-- /.jumbotron -->
        <!-- ======= Header ======= -->
        <jsp:include page="/WEB-INF/views/include/header.jsp" />
        <!-- End Header -->
        <main id="main">
            <noscript>
                <strong
                    >We're sorry but notice doesn't work properly without
                    Javascript enabled.</strong
                >
            </noscript>
            <div id="app"></div>
            <script src="vue/notice/js/app.js"></script>
            <script src="vue/notice/js/chunk-vendors.js"></script>
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

        <script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>

        <!-- Template Main JS File -->
        <script src="js/main.js"></script>
        <script src="js/user.js"></script>
    </body>
</html>
