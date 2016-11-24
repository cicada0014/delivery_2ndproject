<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mainList.jsp</title>
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap") %>
<script type="text/javascript">
	$(function(){
		var count=1;



		
		$('#moreSearchBtn').on("click",function(){
			$.ajax({
				url:"list",
				type:"post",
				data:"command=listAjax&option="+$(".more").attr("id")+"&&count="+count,
				dataType:"json",
				success:function(restaurantList){
						count++;
						$(restaurantList).each(function(index, rsVO){
									var rsName = rsVO.restaurantName;
									var rsLocation = rsVO.restaurantLocation;
									var rsCategory = rsVO.restaurantCategory;
									var rsImg = rsVO.restaurantImg;
									var rsOpenTime = rsVO.restaurantOpenTime;
									var rsCloseTime = rsVO.restaurantCloseTime;
									var rsIntro =rsVO.restaurantIntro;
									var rsPhone = rsVO.restaurnatPhone;
									var result = "<tr>";
									result +="<td>";
									result +=rsName;
									result +="</td>";
									$('#firstLoadData').append(result);
							})
							},
				error:function(exception){
					alert(exception.message);
						}
				})
			})
		})

</script>


</head>
<body>
<div class="container-fluid">
	<div class="row">

	<!-- 	header section -->
	<c:import url="projectHeader.html" var="header"></c:import>
	<%=pageContext.getAttribute("header")%>
	
	</div>
<!-- 	category section -->
	<div class="row">
		<div id="categorySection" class="grey darken-3">
			<br>
			<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
			<span id="categorySpan">${categoryList }</span> 선택된 카테고리 에 대한 식당리스트
			표현. 카테고리를 가진 식당 리스트 보여주기
			<script type="text/javascript">
				$('#categorySpan').find('#categoryCarousel').remove(); // categoryCarousel만 지움
			</script>
		</div>
	</div>
<!-- 	list section -->
<div class="container">
			<div class="row" id="firstLoadData">
				<c:forEach var="restaurant" items="${requestScope.restaurantList}">
					<div class="col s12 m6 l4">	
						<a href="list?command="">
							<div class="card horizontal">
								<div class="card-image">
									<img src="images/${restaurant.restaurantImg }">
								</div>
								<div class="card-stacked">
									<div class="card-content">
										<p>식당에 대한 정보가 들어간다.</p>
									</div>

									<div class="card-action">${restaurant.restaurantName} 식당
										위치</div>
								</div>
							</div>
						</a>
						<!-- 				<a -->
						<%-- 					href="list?command=takeList&option=${pageScope.category.categoryName}"> --%>
						<%-- 					${pageScope.category.categoryName} </a> --%>
					</div>
				</c:forEach>
			</div>

		</div>



	<div class="container">
		<select name="alignment" mutiple="false">
			<option value="nameAl"></option>
			<option value="indexAl">인덱스 순으로 정렬</option>
		</select>
		
		
		<a href="#!" id="moreSearchBtn" class="btn">더 많은 식당정보
			불러오기 <span class="more" id="${requestScope.category}"></span></a>
<!-- 		<button type="button" class="btn btn-primary" > -->
<!-- 		</button> -->
		
	</div>
	
<!-- 	footer section -->
<c:import url="projectFooter.html" var="footer"></c:import>
<%=pageContext.getAttribute("footer")%>
</body>
</html>