<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>insertMenu.jsp</title>
</head>
<body>

<form action="File" method="post" enctype="multipart/form-data">
	식당이름<input type="text" name="restaurantName" value="" disabled="disabled"><br>
	카테고리<select name="category">
			<option value="">카테고리 선택</option>
			<option value="mainMenu">메인메뉴</option>
			<option value="sideMenu">사이드메뉴</option>
			<option value="drinkMenu">음료</option>
			<option value="etcMenu">기타</option>
			</select><br>
	메뉴이름<input type="text" name="menuName"><br>
	메뉴가격<input type="text" name="menuPrice"><br>
	메뉴정보<textarea rows="10"></textarea><br>
	메뉴사진<input type="file" name="menuImgUpload"><br>
	<input type="hidden" name="command" value="">
	<input type="submit" value="메뉴등록">
</form>

</body>
</html>