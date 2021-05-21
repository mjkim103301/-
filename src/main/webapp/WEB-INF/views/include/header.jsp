<%@page import="com.ssafy.happyhouse.dto.UserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%String root =request.getContextPath();
%>  

<html lang="ko">
<body>
  <!-- ======= login modal ======= --> 
  <jsp:include page="../user/login_modal.jsp" />

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex">

      <div class="logo mr-auto">
     
        <h1 class="text-light d-inline-block"><a href="/happyhouse">HappyHouse</a></h1>
        <span class="ml-1"><a href="article">게시판</a></span>
      </div>

      <nav class="nav-menu d-lg-block" id="nav-menu">
        <ul>
          <li class="active"><a href="/happyhouse">Home</a></li>
          <li><a href="#services">Services</a></li>
          <li><a href="#about">About Us</a></li>
         
          <li><a href="#team">Team</a></li>
     <c:choose>
     	<c:when test="${not empty user}">
          <li><a id="logout-nav" href="javascript:void(0);" onclick="javascript:logout();" class="logout-nav font-weight-bold">Logout</a></li>
          <li><a id="mypage-nav" href="mypage" class="mypage-nav font-weight-bold">MyPage</a></li>
          	<c:if test="${not empty member.isAdmin && member.isAdmin eq true}">
          <!-- 관리자가 로그인했을 때만 -->
          <li><a id="admin-nav" href="user_admin" class="admin-nav font-weight-bold">Admin</a></li> 
          	</c:if>
        </c:when>
        <c:otherwise>
          <li><a id="login-nav" href="" class="login-nav font-weight-bold" data-toggle="modal" data-target="#loginModal">Login</a></li>
          <li><a id="signup-nav" href="register" class="signup-nav font-weight-bold" >SignUp</a></li>
        </c:otherwise>
	</c:choose>

        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->


</html>