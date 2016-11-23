<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>

<title>index.jsp</title>

<!-- 네이버 지도 에이피아이 테스트 -->
<script type="text/javascript"
	src="https://openapi.map.naver.com/openapi/v3/maps.js?clientId=JKvjluyyeKcMUDL2j_l6"></script>

<script type="text/javascript">
	$(function() {
		var mapOptions = {
			center : new naver.maps.LatLng(37.3595704, 127.105399),
			zoom : 10
		}
		var mapdiv = document.getElementById("map");
		var map = new naver.maps.Map(mapdiv, mapOptions);
	})
</script>

<!-- 네이버 지도 에이피아이 테스트 끝  -->
</head>

<body>
<c:import url="projectHeader.html" var="header"></c:import>
		<%=pageContext.getAttribute("header")%>

	<div class="container">
		<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
		${categoryList }
		<br> 화면 구성중 <br> <a href="list?command=insertRestaurantInfoForm"><button>식당정보 입력하기</button></a>
		<c:if test="${empty sessionScope.userid}">
			<a href="member.do?action=login"><button>로그인</button></a>
			<a href="member.do?action=join"><button>회원가입</button></a>
		</c:if>
		<c:if test="${not empty sessionScope.userid}">
	  ${sessionScope.userid}님 어서오십시오. 
	  <a href="member.do?action=logout"><button>로그아웃</button></a>
		</c:if>


	</div>
	<!-- <div id="map" style="width:100%;height:400px;"></div>	 -->
	
<div class="section no-pad-bot" id="index-banner">
    <div class="container">
      <br><br>
      <h1 class="header center orange-text">Starter Template</h1>
      <div class="row center">
        <h5 class="header col s12 light">A modern responsive front-end framework based on Material Design</h5>
      </div>
      <div class="row center">
        <a href="http://materializecss.com/getting-started.html" id="download-button" class="btn-large waves-effect waves-light orange">Get Started</a>
      </div>
      <br><br>

    </div>
  </div>	

<c:import url="projectFooter.html" var="footer"></c:import>
<%=pageContext.getAttribute("footer")%>
</body>

</html>