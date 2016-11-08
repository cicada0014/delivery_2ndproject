<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>mainList.jsp</title>
</head>
<body>
<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
${categoryList }



선택된 카테고리 에 대한 식당리스트 표현.
카테고리를 가진 식당 리스트 보여주기
<!-- 	list?command=takeList&option=${requestScope.category } -->
		<select name="alignment" mutiple="false">
			<option value="nameAl" > </option>
			<option value="indexAl" >인덱스 순으로 정렬</option>
		
		</select>
	<table border="2">
		<c:forEach var="restaurant" items="${requestScope.restaurantList}">
			<tr>
				<td>식당이름
			<img src="images/${restaurant.restaurantImg }" alt="${restaurant.restaurantImg}">
		</td>
      <!-- 				식당을 선택했을대 식당 메뉴값과 리뷰정보를 포함하고 있는 페이지를 가지고 올것 -->
				<td><a href="list?command="">${restaurant.restaurantName}</a>
				
				</td>
			</tr>
			<tr>
				<td>식당 위치</td>
				<td>${restaurant.restaurantLocation}</td>
			</tr>
			
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		<tr></tr>
		</c:forEach>

	</table>


</body>
</html>