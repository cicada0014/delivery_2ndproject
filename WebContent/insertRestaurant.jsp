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

<script type="text/javascript">
	if(<%=request.getAttribute("result")%>>0){
			alert("식당정보 입력성공!")
		}
	else if(<%=request.getAttribute("result")%>==0){
		alert("식당정보 입력실패!")
		}
	

	$(document).ready(function(){
		
		$('#restaurant_opentime').timepicker({
            template: false,
            showInputs: false,
            minuteStep: 5
        });
		$('#restaurant_closetime').timepicker({
            template: false,
            showInputs: false,
            minuteStep: 5
        });
		$('select').material_select();
		$('.loSelec li').on("click", function(){
			var select= $(this).find('span').text();
			$('#locationLabel').text(select);
			$('#restaurant_location').val(select);
		})
		$('.caSelec li').on("click", function(){
			var select = $(this).find('span').text();
			$('#categoryLabel').text(select);
			$('#restaurant_category').val(select);
			
		})
		
		$("#restaurant_phone").on("keyup",function(){
			var regExp = /^[0-9]+$/;

			if(!regExp.test($(this).val())){
					$(this).addClass('invalid');
					$(this).removeClass('valid');
				}else{
					
					}
			})
	

		
	})
</script>
<style type="text/css">
	.selec{
		margin-top: 0.731cm;
	}
	.selec li{
		background-color: balck;
	}
</style>
	

</head>
<body>
<c:import url="projectHeader.jsp" var="header"></c:import>
		<%=pageContext.getAttribute("header")%>

<!-- 테스트중. 관리자 아이디인지 컨트롤러에서 먼저 확인하고, 칼럼추가할것 생각하기.   -->
<br><br><br>
	<div class="container">
		<div class="row">

			<form class="col s8 m8 l8" action="File" method="post"
				enctype="multipart/form-data">
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">store</i>
         			<input  id="restaurant_name" type="text" class="validate" name="restaurantName" >
          			<label for="restaurant_name">식당 이름</label>
        		</div>
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">play_for_work</i>
         			<input disabled  type="text" class="validate" >
         				<input type="hidden" name="restaurantLocation" id="restaurant_location">
          			<label for="restaurant_location" id="locationLabel">식당 위치</label>
        		</div>
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">label_outline</i>
         			<input disabled  type="text" class="validate" >
         			<input type="hidden" name="restaurantCategory" id="restaurant_category">
          			<label for="restaurant_category" id="categoryLabel">식당 카테고리</label>
        		</div>
				<div class="input-field col s5 m5 l5">
					<i class="material-icons prefix">schedule</i>
         			<input  id="restaurant_opentime" type="text" class="form-control input-small"  name="restaurantOpenTime">
          			<label for="restaurant_opentime">여는 시간</label>
        		</div>
        		<dliv class="col s2 m2 l2"><h5>~</h5></dliv>
        		
				<div class="input-field col s5 m5 l5">
					<i class="material-icons prefix">schedule</i>
         			<input " id="restaurant_closetime" type="text" class="form-control input-small"  name="restaurantCloseTime">
          			<label for="restaurant_opentime">닫는 시간</label>
        		</div>



				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">call</i>
         			<input  id="restaurant_phone" type="tel" class="validate" name="restaurantPhone">
          			<label for="restaurant_phone" data-error="wrong" data-success="right">식당 전화번호</label>
        		</div>
				<div class="input-field col s12 m12 l12">
					<i class="material-icons prefix">chat_bubble_outline</i>
         			<textarea id="textarea1" class="materialize-textarea" length="150" name="restaurantIntroduce"></textarea>
        		    <label for="textarea1">식당 소개</label>
        		</div>
				
				<div class="file-field input-field col s10 m10 l10">
					<div class="btn">
						<span>File</span> <input type="file" name="restaurantImgFile">
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

			</form>
			
<!-- 			여기부터는 페이지의 두번째 칼럼,확인작업을 위한 컴포넌트들이 들어있다.  -->
<!-- 				이럴거면 하나의 로우로 관리했으면더 깔 끔했을 것같다.  -->
			<div class="col s4 m4 4" id="checkdiv">
				<br>
				<a class="waves-effect waves-light btn col s6 m6 l6">중복확인</a>
				<br>
				<br>
				
				<div class="input-field col s12 m12 l12 loSelec">
    				<select id="locationSelect">
    					  <option value="" disabled selected>식당 위치 입력</option>
     					  <c:forEach var="location" items="${requestScope.locationList}">
	     					  <option value="${location}">${location}</option>
     					  </c:forEach>	
    				</select>
   					 <label></label>
  				</div>
				<div class="input-field col s12 m12 l12 caSelec">
    				<select id="locationSelect">
    					  <option value="" disabled selected>카테고리 입력</option>
     					  <c:forEach var="category" items="${requestScope.categoryList}">
	     					  <option value="${category.categoryName}">${category.categoryName}</option>
     					  </c:forEach>	
    				</select>
   					 <label></label>
  				</div>
				
			</div>
			
			
		</div>
	</div>
	
	
<!-- 	time 설정을 위한 자바스크립트  -->
	
	

	<c:import url="projectFooter.jsp" var="footer"></c:import>
<%=pageContext.getAttribute("footer")%>
</body>
</html>