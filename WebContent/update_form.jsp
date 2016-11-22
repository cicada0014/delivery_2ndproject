<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script type="text/javascript" src="script/member.js" ></script>
<title>update_from.jsp</title>
</head>
<body>
	<h2>회원정보수정</h2>
	<form action="member.do" method="post" name="frm" >
		<input type="hidden" name="action" value="update_get" >
		<table>
			<tr>
				<td>아이디 </td>
				<td><input type="text" name="userid" size="20" value="${mvo.userid}" readonly></td>
			</tr>
			
			<tr>
				<td>이메일</td>
				<td><input type="text" name="email" size="20" value="${mvo.email}"></td>
			</tr>
			
			<tr>
				<td>닉네임</td>
				<td> <input type="text" name="name" size="20" value="${mvo.name}" > </td>
			</tr>
			
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="pwd" size="21" ></td>
			</tr>
			
			<tr height="30">
				<td width="80" >암호확인</td>
				<td><input type="password" name="pwd_check" size="21" ></td>
			</tr>
			
			
			<tr>
				<td>휴대폰</td>
				<td><input type="text" name="phone" size="20" value="${mvo.phone}"></td>
			</tr>
			
			<tr>
			<td>생년월일       </td>
			<td><input type="text" name="brithday" size="30" value="${mvo.brithday}" ></td>
			</tr>
		
			
			
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="확인" onclick="return joinCheck()" >
				<input type="reset" value="취소" >
				</td>
				
			</tr>



		</table>
	</form>


</body>
</html>