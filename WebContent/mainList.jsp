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
		$('#moreSearchBtn').on("click",function(){
			$.ajax({
				url:"list",
				type:"post",
				data:"command=listAjax&option="+$(".more").attr("id"),
				dataType:"json",
				success:function(restaurantList){
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
	<c:import url="projectHeader.html" var="header"></c:import>
		<%=pageContext.getAttribute("header")%>
	<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
	${categoryList } 선택된 카테고리 에 대한 식당리스트 표현. 카테고리를 가진 식당 리스트 보여주기
	<div class="container">
		<select name="alignment" mutiple="false">
			<option value="nameAl"></option>
			<option value="indexAl">인덱스 순으로 정렬</option>
		</select>
		<div class="row" id="firstLoadData">
			<c:forEach var="restaurant" items="${requestScope.restaurantList}">
				<div class="col s12 m6 l4">
					식당이름 <img src="images/${restaurant.restaurantImg }"
						alt="${restaurant.restaurantImg}">
					<!-- 				식당을 선택했을대 식당 메뉴값과 리뷰정보를 포함하고 있는 페이지를 가지고 올것 -->
					<a href="list?command="">${restaurant.restaurantName}</a> 식당 위치
					${restaurant.restaurantLocation}
				</div>
			</c:forEach>
		</div>
		<button type="button" class="btn btn-primary" id="moreSearchBtn">
			<span class="more" id="${requestScope.category}"></span> 더 많은 식당정보
			불러오기
		</button>
	</div>
<c:import url="projectFooter.html" var="footer"></c:import>
<%=pageContext.getAttribute("footer")%>
</body>
</html>