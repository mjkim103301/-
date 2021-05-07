<%@page import="com.ssafy.happyhouse.dto.MemberDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c"    uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<%String root =request.getContextPath();
%>  

<html lang="ko">
<body>
  <!-- ======= login modal ======= --> 
  <jsp:include page="../member/login_modal.jsp" />

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top">
    <div class="container d-flex">

      <div class="logo mr-auto">
        <h1 class="text-light d-inline-block"><a href="<%=root%>/main.do?action=mvMain">HappyHouse</a></h1>
        <span class="ml-1"><a href="<%=root%>/main.do?action=mvNotice">공지사항</a></span>
      </div>

      <nav class="nav-menu d-lg-block" id="nav-menu">
        <ul>
          <li class="active"><a href="<%=root%>/main.do?action=mvMain">Home</a></li>
          <li><a href="#about">About Us</a></li>
          <li><a href="#services">Services</a></li>
          <li><a href="#team">Team</a></li>
     <c:choose>
     	<c:when test="${not empty member}">
          <li><a id="logout-nav" href="javascript:void(0);" onclick="javascript:logout();" class="logout-nav font-weight-bold">Logout</a></li>
          <li><a id="mypage-nav" href="<%=root%>/main.do?action=mvMyPage" class="mypage-nav font-weight-bold">MyPage</a></li>
          	<c:if test="${not empty admininfo}">
          <!-- 관리자가 로그인했을 때만 -->
          <li><a id="admin-nav" href="<%=root%>/main.do?action=mvUserAdmin" class="admin-nav font-weight-bold">Admin</a></li> 
          	</c:if>
        </c:when>
        <c:otherwise>
          <li><a id="login-nav" href="" class="login-nav font-weight-bold" data-toggle="modal" data-target="#loginModal">Login</a></li>
          <li><a id="signup-nav" href="<%=root%>/main.do?action=mvSignUp" class="signup-nav font-weight-bold" >SignUp</a></li>
        </c:otherwise>
	</c:choose>

        </ul>
      </nav><!-- .nav-menu -->

    </div>
  </header><!-- End Header -->


</html>