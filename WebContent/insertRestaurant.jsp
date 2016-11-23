<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertRestaurant.jsp</title>
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>
<link type="text/css" href="bootstrap-timepicker/css/bootstrap-timepicker.min.css" />
<script type="text/javascript" src="bootstrap-timepicker/js/bootstrap-timepicker.min.js"></script>

</head>
<body>
<c:import url="projectHeader.html" var="header"></c:import>
		<%=pageContext.getAttribute("header")%>

<!-- 테스트중. 관리자 아이디인지 컨트롤러에서 먼저 확인하고, 칼럼추가할것 생각하기.   -->
<br><br><br>
	<div class="container">
		<div class="row">

			<form class="col s10 m10 l10" action="File" method="post"
				enctype="multipart/form-data">
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">store</i>
         			<input  id="restaurant_name" type="text" class="validate" name="restaurantName" >
          			<label for="restaurant_name">식당 이름</label>
        		</div>
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">play_for_work</i>
         			<input  id="restaurant_location" type="text" class="validate" name="restaurantLocation">
          			<label for="restaurant_location">식당 위치</label>
        		</div>
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">label_outline</i>
         			<input  id="restaurant_category" type="text" class="validate" name="restaurantCategory">
          			<label for="restaurant_category">식당 카테고리</label>
        		</div>
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">schedule</i>
         			<input " id="restaurant_opentime" type="text" class="form-control input-small"  name="restaurantOpenTime">
          			<label for="restaurant_opentime">영업 시간</label>
        		</div>
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">call</i>
         			<input  id="restaurant_phone" type="tel" class="validate" name="restaurantPhone">
          			<label for="restaurant_phone">식당 전화번호</label>
        		</div>
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">chat_bubble_outline</i>
         			<textarea id="textarea1" class="materialize-textarea" length="150" name="restaurantIntroduce"></textarea>
        		    <label for="textarea1">식당 소개</label>
        		</div>
				
				<div class="file-field input-field col s10 m10 l10">
					<div class="btn">
						<span>File</span> <input type="file" name="restaurantImg">
					</div>
					<div class="file-path-wrapper">
						<input class="file-path validate" type="text">
					</div>
				</div>
				<input type="hidden" name="command" value="insertRestaurantInfo">
				<button class="btn waves-effect waves-light" type="submit"
					name="action">
					식당정보 입력하기 <i class="material-icons right">tt</i>
				</button>

				입력이 된다. 프론트단에서 입력제한 걸어줘야함. 데이터베이스에 있는 정보를 가지고? 데이터베이스에서입력제한값 들고 가도록
				해야겠다/
			</form>
			
<!-- 			여기부터는 페이지의 두번째 칼럼,확인작업을 위한 컴포넌트들이 들어있다.  -->
			<div class="col s2 m2 l2" id="checkdiv">
				<br>
				<a class="waves-effect waves-light btn col s8 m8 8">중복확인</a>
				
			</div>
		</div>
	</div>
	
	
<!-- 	time 설정을 위한 자바스크립트  -->
	
	<script type="text/javascript">
			$('#restaurant_opentime').timepicker({
                template: false,
                showInputs: false,
                minuteStep: 5
            });
  </script>


	<c:import url="projectFooter.html" var="footer"></c:import>
<%=pageContext.getAttribute("footer")%>
</body>
</html>