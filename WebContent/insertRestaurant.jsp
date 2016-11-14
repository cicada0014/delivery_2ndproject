<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertRestaurant.jsp</title>
</head>
<body>

<!-- 테스트중. 관리자 아이디인지 컨트롤러에서 먼저 확인하고, 칼럼추가할것 생각하기.   -->
<form action="File" method="post" enctype="multipart/form-data">
레스토랑 이름<input type="text" name="restaurantName"><br>
레스토랑 위치<input type="text" name="restaurantLocation"><br>
레스토랑 카테고리<input type="text" name="restaurantCategory"><br>
레스토랑 전화번호<input type="tel" name="restaurantPhone"><br>
레스토랑 영업시간<input type="time" name="restaurantOpenTime"><br>
			<input type="time" name="restaurantCloseTime"><br>
			
<input type="file" name="restaurantImg" >
<input type="hidden" name="command" value="insertRestaurantInfo">
<input type="submit" value="레스토랑 값 입력하기">


</form>



</body>
</html>