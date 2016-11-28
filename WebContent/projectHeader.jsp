<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav  class="nav-extended white">
	<div class="nav-wrapper container">
		<a id="logo-container" href="./index.jsp" class="brand-logo center">
		<img src="images/indexImg.png" alt="indexImage" height="80px"> 
		</a>
		<ul class="right hide-on-med-and-down">
			<c:if test="${empty sessionScope.email}">
			<li ><a class="grey-text" href="member.do?action=login">로그인</a></li>
			<li ><a class="grey-text" href="member.do?action=join">회원가입</a></li>
			</c:if>
			
			<c:if test="${not empty sessionScope.email}">
	   		 <li class="grey-text"  >
	   		 ${sessionScope.email}님 어서오십시오. </li>
	   		 <li><a class="grey-text" href="member.do?action=logout">로그아웃</a></li>
			</c:if>
			
<!-- 			jstl 써서 관리자 입장시에만 보이도록 할 -->
			<li><a class="grey-text" href="list?command=insertRestaurantInfoForm">식당정보
				입력하기</a></li>
			
		</ul>
		
		<ul id="nav-mobile" class="side-nav">
			<li><a href="#">Navbar Link</a></li>
		</ul>
		<a href="#" data-activates="nav-mobile" class="button-collapse"><i
			class="material-icons">menu</i></a>
<!-- 			<ul class="tabs tabs-transparent"> -->
<!--       		</ul> -->
	</div>
	
	</nav>
	
<div class='row' id="currentUserLocation" > </div>

</body>
</html>