<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>categoryList.jsp</title>
<style>
.carousel-inner>.item>img, .carousel-inner>.item>button, .carousel-inner>.item>a
	{
	width: 20%;
	height: 30%;
	margin: auto;
}
#inlineCategory > .eachCategoryImg
	{
		border: solid white 10px;
		margin : 30;
	}
</style>
</head>
<body>
	<div class="container">
		<div class="row" id="categoryCarousel">
			<div id="categoryCarousel" class="carousel slide"
				data-ride="carousel">
				<ol class="carousel-indicators">
					<c:forEach var="i" begin="1" end="${requestScope.categoryListSize}"
						step="1">

						<li data-target="#categoryCarousel" data-slide-to="${i}"></li>
					</c:forEach>
				</ol>

				<div class="carousel-inner" role="listbox">
					<c:forEach var="category" items="${requestScope.categoryList}"
						varStatus="status">

						<c:choose>
							<c:when test="${status.index eq 0}">

								<div class="item active">
									<img src="images/${pageScope.category.categoryImg}"
										alt="${pageScope.category.categoryName}">
									<input id="result" type="hidden"
										value="${pageScope.category.categoryName}"> <a
										id="targetedCategory"
										href="list?command=takeList&option=${pageScope.category.categoryName}">
										${pageScope.category.categoryName} </a>
								</div>
							</c:when>
							<c:otherwise>
								<div class="item">
									<img src="images/${pageScope.category.categoryImg}"
										alt="${pageScope.category.categoryName}"> <a
										href="list?command=takeList&option=${pageScope.category.categoryName}">
										${pageScope.category.categoryName} </a>
								</div>

							</c:otherwise>
						</c:choose>
					</c:forEach>
				</div>

				<a class="left carousel-control" href="#categoryCarousel"
					role="button" data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span> <span
					class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#categoryCarousel"
					role="button" data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>

			</div>
		</div>


		<div class="row" id="inlineCategory">
			<c:forEach var="category" items="${requestScope.categoryList}"
				varStatus="status">
				<div class="col-xs-12 col-sm-6 col-md-2 col-lg-2 eachCategoryImg">
					<img class="img-circle" src="images/${pageScope.category.categoryImg}"
						alt="${pageScope.category.categoryName}" width="100" height="70" > <a
						href="list?command=takeList&option=${pageScope.category.categoryName}">
						${pageScope.category.categoryName} </a>

				</div>
			</c:forEach>
		</div>
	</div>


	<!-- 	///// category 이미지에 대한 버튼 클릭 자바스크립트 -->
	<script type="text/javascript">
		$(function() {
			$(".carousel-inner > .item > img, .eachCategoryImg > img").on(
					"click",
					function() {
						location.href = "list?command=takeList&option="
								+ this.getAttribute("alt");

					})
		})
	</script>

</body>
</html>