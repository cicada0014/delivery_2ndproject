<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertRestaurant.jsp</title>
</head>
<body>
테스트중. 
<form action="File" method="post" enctype="multipart/form-data">
레스토랑 이름<input type="text" name="restaurantName"><br>
레스토랑 위치<input type="text" name="restaurantLocation"><br>
레스토랑 카테고리<input type="text" name="restaurantCategory"><br>

<input type="file" name="restaurantImgFile" >
<input type="hidden" name="command" value="insertRestaurantInfo">
<input type="submit" value="레스토랑 값 입력하기">


</form>



</body>
</html>