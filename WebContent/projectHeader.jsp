<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script> -->
<!-- 이 쿼리가 정말 필요한지? 캐로우셀은 3.1.0.버전만 먹히므로 충돌 발생함. -->


<title>Insert title here</title>

</head>
<body>
	<div class="row">
	<nav class="nav-extended navbar-fixed white ">
		<div class="nav-wrapper container ">
			<a id="logo-container" href="./index.jsp" class="brand-logo center">
				<img src="images/indexImg.png" alt="indexImage" height="60px">
			</a>
			<ul class="right hide-on-med-and-down">

				<c:if test="${empty sessionScope.nick}">
					<li><a class="grey-text" href="member.do?action=login">로그인</a></li>

					<li><a class="grey-text" href="member.do?action=join">회원가입</a></li>

				</c:if>


				<c:if test="${not empty sessionScope.nick}">
					<ul id="dropdownList" class="dropdown-content">
						<li><a class="grey-text" href="member.do?action=logout">로그아웃</a></li>
						<li><a class="grey-text"
							href="member.do?action=update&email=${sessionScope.email}">정보수정</a></li>
						<!-- 			jstl 써서 관리자 입장시에만 보이도록 할 -->
						<li><a class="grey-text"
							href="list?command=insertRestaurantInfoForm">식당정보 입력하기</a></li>
						<li><a class="grey-text" href="menuList.do?action=insertMenuForm">메뉴정보 입력하기</a></li>	

					</ul>
					<li class="grey-text">${sessionScope.nick}님어서오십시오.</li>
					<li class="grey-text"> point :${sessionScope.point}</li>
					<li><a class="dropdown-button grey-text" href="#!"
						data-activates="dropdownList">설정<i
							class="material-icons right">arrow_drop_down</i></a></li>
				</c:if>



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

	<div class='' id="currentUserLocation"></div>
</div>
</body>
</html>