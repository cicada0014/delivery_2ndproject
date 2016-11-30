<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">


<title>insertMenu.jsp</title>
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>
<script type="text/javascript">
	$(function(){
		
		$(document).ready(function(){
			$('select').material_select();			//셀렉트 박스
			$('textarea').trigger('autoresize');	//메뉴정보
			
			var menuCategoryValue = $('value').val(); //셀렉트 박스 값 가져와서 카테고리 분류
		});
	})
</script>
</head>
<body>
<div class="container-fluid">
<!-- 	header section -->
<div class="row">
<c:import url="projectHeader.jsp" var="header"></c:import>
	<%=pageContext.getAttribute("header")%>
</div>
<!-- 	category section -->
	<div class="row">
		<div id="categorySection" class="grey darken-4">
			<br>
			<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
			<span id="categorySpan">${categoryList }</span> 
			<script type="text/javascript">
				$('#categorySpan').find('#categoryCarousel').remove(); // categoryCarousel만 지움
			</script>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<form class="col s11 push-s2" method="post" action="menuList.do">
			<div class="row">
				<div class="input-field col s9">
					<input name="restaurantName" type="text" class="validate">
					<label for="restaurantName">식당이름</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s9">
					<select name="menuCategory">
						<option value="" disabled selected>카테고리 선택</option>
						<option value="1">메인메뉴</option>
						<option value="2">사이드메뉴</option>
						<option value="3">음료</option>
						<option value="4">기타</option>
					</select>
					<label>카테고리</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s9">
					<input name="menuName" type="text" class="validate">
					<label for="menuName">메뉴이름</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s9">
					<input name="menuPrice" type="text" class="validate">
					<label for="menuPrice">메뉴가격</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s9">
					<textarea name="menuInfo" class="materialize-textarea" length="120"></textarea>
					<label for="menuInfo">메뉴정보</label>
				</div>
			</div>
			
			<div class="row">
				<div class="file-field input-field">
					<div class="file-path-wrapper col s7">
					<input name="menuImgPath" class="file-path validate" type="text" placeholder="메뉴사진" disabled>
					</div>
					<div class="btn">
						<input type="file" id="menuPhotoSelect">
						<span>사진선택</span>
					</div>
				</div>
			</div>
			
			<div class="row">
				<a href="/menuList.do?action=insertResult"><button class="btn waves-effect waves-light btn-large" id="submit" name="action" value="insertMenu">메뉴등록</button></a>
			</div>
		</form>
	</div>
</div>
</body>
</html>