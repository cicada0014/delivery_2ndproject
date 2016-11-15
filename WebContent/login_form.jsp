<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>login_form.jsp</title>
<script type="text/javascript" src="script/member.js" ></script>
</head>
<body>
<h2>로그인</h2>
	<form action="member.do" method="post" name="frm" >
		<input type="hidden" name="action" value="login_check" >
		<table>
			<tr>		
				<td>아이디</td>	
				<td><input type="text" name="userid" value="${userid}"></td>		
			</tr>	
			<tr>		
				<td>비밀번호</td>	
				<td><input type="password" name="pwd" ></td>		
			</tr>
			<tr>		
				<td colspan="2" align="center" >	
				 <input type="submit" value="로그인" onclick="return loginCheck()">  
				 <input type="reset" value="취소">
			 							
				</td>		
			</tr>
				
		</table>
	</form>
</body>
</html>