<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>categoryList.jsp</title>

<script type="text/javascript">
var sessionLocation = sessionStorage.getItem('userCurrentLocation');
	$(document).ready(function(){
		$('.carousel').carousel();
		
		})
</script>

<style>
.carousel-item > img
	{
	width: 40%;
}

#inlineCategory img {
	width:120px;
	height:120px;
}
</style>
</head>
<body>
		
		<div class="row" id="categoryCarousel">
			<div  class="carousel">
				<c:forEach var="category" items="${requestScope.categoryList}"
					varStatus="status">
					<a class="carousel-item " 
					href="list?command=takeList&option=${pageScope.category.categoryName}&sessionLocation=${sessionScope.sessionLocation}" ><img
						src="images/${pageScope.category.categoryImg}"
						alt="${pageScope.category.categoryName}" class='circle' ></a>
					<!-- 						 <a -->
					<%-- 							href="list?command=takeList&option=${pageScope.category.categoryName}"> --%>
					<%-- 							${pageScope.category.categoryName} </a> --%>
				</c:forEach>
			</div>
		</div>

	<c:set value="${requestScope.categoryList}" var="categoryListData" scope="session"/>
	<div class="row" id="inlineCategory">
		<div class="container" id="uselessIndex">
		<c:forEach var="category" items="${requestScope.categoryList}"
			varStatus="status">
			<div class="col s6 m4 l2 ">
			<a href="list?command=takeList&option=${pageScope.category.categoryName}&sessionLocation=${sessionScope.sessionLocation} ">
						<img class="circle" src="images/${pageScope.category.categoryImg}">
				</a>
<!-- 				<a -->
<%-- 					href="list?command=takeList&option=${pageScope.category.categoryName}"> --%>
<%-- 					${pageScope.category.categoryName} </a> --%>
			</div>
		</c:forEach>
	</div>
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