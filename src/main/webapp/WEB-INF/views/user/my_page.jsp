<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="root" value="${pageContext.request.contextPath }" />

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
    </head>
    <script type="text/javascript">
        function updateUser() {
            if (document.getElementById("userpwd").value == "") {
                alert("변경할 비밀번호를 입력하세요!");
            } else if (document.getElementById("username").value == "") {
                alert("변경할 이름을 입력하세요!");
            } else if (document.getElementById("useremail").value == "") {
                alert("변경할 이메일을 입력하세요!");
            } else if (document.getElementById("useraddress").value == "") {
                alert("변경할 주소를 입력하세요!");
            } else {
                let userid = document.getElementById("userid").value;
                let username = document.getElementById("username").value;
                let email = document.getElementById("useremail").value;
                let userpwd = document.getElementById("userpwd").value;
                let address = document.getElementById("useraddress").value;
                let campus = document.getElementById("campus").value;
                console.log(userpwd + email + address + username);
                let data = {
                    userId: userid,
                    userName: username,
                    userPwd: userpwd,
                    email: email,
                    address: address,
                    campus: campus,
                };

                $.ajax({
                    url: "${root}/updateuser",
                    type: "PUT",
                    data: JSON.stringify(data),
                    contentType: "application/json; charset=UTF-8",
                    success: function (status) {
                        console.log("수정 성공 !" + status);
                        $("#updateModal").modal("hide");
                        location.href = "${root}/mypage";
                    },
                    error: function (request, status, error) {
                        $("#updateModal").modal("hide");
                        $("#failModal").modal("show");
                        console.log("수정 실패 !" + status);
                    },
                });
            }
        }
    
    </script>

    <body>
        <!-- ======= Header ======= -->
        <jsp:include page="/WEB-INF/views/include/header.jsp" />
        <!-- End Header -->
        <div class="jumbotron jumbotron-fluid">
            <picture>
                <img src="img/house.jpeg" class="jumbotron__background" />
            </picture>
            <div class="container text-white text-center">
                <h1 class="display-4">My Page</h1>
                <p class="lead"></p>
            </div>
        </div>
        <!-- /.jumbotron -->

        <main id="main">
            <section id="" class="p-1">
                <div class="container card-body">
                    <h2 class="card-title text-center">회원 정보</h2>
                    <table class="table mx-auto mb-5" style="width: 70%">
                        <tbody>
                            <tr>
                                <th>아이디</th>
                                <td>${user.userId}</td>
                            </tr>
                            <tr>
                                <th>비밀번호</th>
                                <td>***********</td>
                            </tr>
                            <tr>
                                <th>이름</th>
                                <td>${user.userName}</td>
                            </tr>
                            <tr>
                                <th>이메일</th>
                                <td>${user.email}</td>
                            </tr>
                            <tr>
                                <th>주소</th>
                                <td>${user.address}</td>
                            </tr>
                            <tr>
                                <th>SSAFY 캠퍼스</th>
                                <td>${user.campus}</td>
                            </tr>
                        </tbody>
                    </table>
                    <hr />
                    <div class="text-center">
                        <button
                            type="button"
                            class="btn btn-warning"
                            data-toggle="modal"
                            data-target="#updateModal"
                        >
                            회원정보 수정
                        </button>
                        <button
                            type="button"
                            class="btn btn-secondary"
                            data-toggle="modal"
                            data-target="#deleteModal"
                        >
                            탈퇴
                        </button>
                    </div>
                </div>
            </section>
            <!-- End About Section -->
        </main>
        <!-- End #main -->

        <!-- ======= Footer ======= -->
        <jsp:include page="../include/footer.jsp" />
        <!-- End Footer -->

        <!-- Update user info Modal -->
        <div class="modal" id="updateModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <article
                            class="card-body mx-auto"
                            style="max-width: 400px"
                        >
                            <h4 class="card-title text-center mt-3">
                                회원정보 수정
                            </h4>
                            <form id="updateform" method="post" action="post">
                                <input
                                    type="hidden"
                                    name="action"
                                    id="action"
                                    value="updateuser"
                                />
                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa fa-user"></i>
                                        </span>
                                    </div>

                                    <input
                                        id="userid"
                                        name="userid"
                                        class="form-control"
                                        value="${user.userId}"
                                        type="text"
                                        readonly
                                    />
                                </div>
                                <!-- form-group// -->
                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa fa-lock"></i>
                                        </span>
                                    </div>
                                    <input
                                        id="userpwd"
                                        name="userpwd"
                                        class="form-control"
                                        value=""
                                        type="password"
                                    />
                                </div>
                                <!-- form-group// -->
                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"
                                            ><i class="far fa-smile"></i
                                        ></span>
                                    </div>
                                    <input
                                        id="username"
                                        name="username"
                                        class="form-control"
                                        value="${user.userName }"
                                        type="text"
                                    />
                                </div>
                                <!-- form-group// -->
                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text">
                                            <i class="fa fa-envelope"></i>
                                        </span>
                                    </div>
                                    <input
                                        id="useremail"
                                        name="useremail"
                                        class="form-control"
                                        value="${user.email }"
                                        type="email"
                                    />
                                </div>
                                <!-- form-group// -->
                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"
                                            ><i
                                                class="fas fa-map-marker-alt"
                                            ></i
                                        ></span>
                                    </div>
                                    <input
                                        id="useraddress"
                                        name="useraddress"
                                        class="form-control"
                                        value="${user.address }"
                                        type="address2"
                                    />
                                </div>
                                <div class="form-group input-group">
                                    <div class="input-group-prepend">
                                        <span class="input-group-text"
                                            ><i
                                                class="fas fa-map-marker-alt"
                                            ></i
                                        ></span>
                                    </div>
                                    <select class="form-control" id="campus">
                                        <option selected value="">없음</option>
                                        <option value="서울">서울</option>
                                        <option value="대전">대전</option>
                                        <option value="광주">광주</option>
                                        <option value="구미">구미</option>
                                    </select>
                                </select>
                                </div>
                                <!-- form-group// -->
                                <div class="form-group">
                                    <button
                                        type="button"
                                        class="btn btn-primary btn-block"
                                        onclick="javascript:updateUser();"
                                    >
                                        수정하기
                                    </button>
                                </div>
                                <!-- form-group// -->
                            </form>
                        </article>
                    </div>
                </div>
            </div>
        </div>

        <!-- Delete Modal -->
        <div class="modal" id="deleteModal">
            <div class="modal-dialog">
                <div class="modal-content">
                    <div class="modal-body">
                        <h5 class="text-center mt-3">정말 탈퇴하시겠습니까?</h5>
                    </div>
                    <div class="modal-footer">
                        <button
                            type="button"
                            class="btn btn-danger logout-nav"
                            onclick="location.href='index.html'"
                        >
                            확인
                        </button>
                        <button
                            type="button"
                            class="btn btn-secondary"
                            data-dismiss="modal"
                        >
                            취소
                        </button>
                    </div>
                </div>
            </div>
        </div>

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
