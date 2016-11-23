<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>categoryList.jsp</title>

<script type="text/javascript">
	$(document).ready(function(){
			$('.carousel').carousel();
		})
</script>

<style>
/* .carousel-inner>.item>img, .carousel-inner>.item>button, .carousel-inner>.item>a */
/* 	{ */
/* 	width: 20%; */
/* 	height: 30%; */
/* 	margin: auto; */
/* } */
/* #inlineCategory > .eachCategoryImg */
/* 	{ */
/* 		border: solid white 10px; */
/* 		margin : 30; */
/* 	} */
</style>
</head>
<body>
	
		<div class="row" id="categoryCarousel">
			<div id="categoryCarousel" class="carousel">
				<!-- 				<ol class="carousel-indicators"> -->
				<%-- 					<c:forEach var="i" begin="1" end="${requestScope.categoryListSize}" --%>
				<%-- 						step="1"> --%>

				<%-- 						<li data-target="#categoryCarousel" data-slide-to="${i}"></li> --%>
				<%-- 					</c:forEach> --%>
				<!-- 				</ol> -->

				<c:forEach var="category" items="${requestScope.categoryList}"
					varStatus="status">
					<a class="carousel-item" href="#one"><img
						src="images/${pageScope.category.categoryImg}"
						alt="${pageScope.category.categoryName}"></a>
					<!-- 						 <a -->
					<%-- 							href="list?command=takeList&option=${pageScope.category.categoryName}"> --%>
					<%-- 							${pageScope.category.categoryName} </a> --%>
				</c:forEach>
			</div>
		</div>
	


	<div class="row" id="inlineCategory">
			<c:forEach var="category" items="${requestScope.categoryList}"
				varStatus="status">
				<div class="col s6 m4 l2 eachCategoryImg">
					<img class="img-circle" src="images/${pageScope.category.categoryImg}"
						alt="${pageScope.category.categoryName}" width="100" height="70" > <a
						href="list?command=takeList&option=${pageScope.category.categoryName}">
						${pageScope.category.categoryName} </a>

				</div>
			</c:forEach>
		</div>


	<!-- 	///// category 이미지에 대한 버튼 클릭 자바스크립트 -->
	<script type="text/javascript">
		$(function() {
			$("#inlineCategory > .eachCategoryImg > img").on(
					"click",
					function() {
						location.href = "list?command=takeList&option="
								+ this.getAttribute("alt");

					})
		})
	</script>

</body>
</html>