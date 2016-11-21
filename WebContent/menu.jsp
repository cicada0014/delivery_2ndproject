<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>menu.jsp</title>
<style type="text/css">
	table
	{
		margin:auto;
	}
	#address
	{
		font-size:12px;
	}
</style>
</head>
<body>
	<form>
		<table border="2" width="80%" height="10%" style="table-layout:fixed">
		<tr>
			<td>식당이름</td>
			<td id="address">식당주소</td>
		</tr>
		</table>
		<br>
		<table border="2" width="80%" height="80%" style="table-layout:fixed">
			<tr>
				<td rowspan="3" width="70%">메인메뉴</td>
				<td height="70%">매장정보</td>
			</tr>
			<tr>
				<td>장바구니</td>
			</tr>
			<tr>
				<td>결제하기</td>
			</tr>
		</table>
	</form>
</body>
</html>