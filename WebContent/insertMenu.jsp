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
	�Ĵ��̸�<input type="text" name="restaurantName" value="" disabled="disabled"><br>
	ī�װ�<select name="category">
			<option value="">ī�װ� ����</option>
			<option value="mainMenu">���θ޴�</option>
			<option value="sideMenu">���̵�޴�</option>
			<option value="drinkMenu">����</option>
			<option value="etcMenu">��Ÿ</option>
			</select><br>
	�޴��̸�<input type="text" name="menuName"><br>
	�޴�����<input type="text" name="menuPrice"><br>
	�޴�����<textarea rows="10"></textarea><br>
	�޴�����<input type="file" name="menuImgUpload"><br>
	<input type="hidden" name="command" value="">
	<input type="submit" value="�޴����">
</form>

</body>
</html>