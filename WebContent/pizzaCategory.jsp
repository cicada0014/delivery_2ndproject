<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>pizzaCategory.jsp</title>
</head>
<body>
	피자 카테고리를 가진 식당 리스트 보여주기
	<table border="2">
		<c:forEach var="restaurant" items="${requestScope.restaurantList}">
			<tr>
				<td>식당이름</td>
				<td>${restaurant.restaurantName}</td>
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