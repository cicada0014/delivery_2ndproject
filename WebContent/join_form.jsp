<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<script type="text/javascript" src="script/member.js"></script>
<title>Insert title here</title>
</head>
<body>
<h1>회원 가입</h1>	

<form action="member.do" method="post" name="frm" >
	<input type="hidden" name="action" value="join_get" >	
	<input type="hidden" name="admin" value="1" >
	<table>
		
		<tr>
			<td>아이디 </td>
			<td><input type="text" name="userid" 
			placeholder="4글자 이상의 아이디를 입력해 주세요." size="30" >
				<input type="hidden" name="Repetitious" size="30" >
				<input type="button" value="중복체크" onclick="idCheck()" >
			</td>
		</tr>
		
		<tr>
			<td>이메일       </td>
			<td><input type="email" name="email" 
			placeholder="hongildong@exeample.com" size="30"></td>
		</tr>
		
		<tr>
			<td>닉네임       </td>
			<td><input type="text" name="name" 
			placeholder="닉네임을 입력해주세요." size="30"></td>
		</tr>
		<tr>
			<td>비밀번호       </td>
			<td><input type="password" name="pwd" 
			placeholder="6~20자로 입력해주세요." size="31" ></td>
		</tr>
		
		<tr height="30" >
			<td width="80">비밀번호 확인       </td>
			<td><input type="password" name="pwd_check" 
			placeholder="비밀번호를 재입력해주세요." size="31"></td>
		</tr>
		
				
		<tr>
			<td>휴대폰       </td>
			<td><input type="text" name="phone" 
			placeholder="'-'를 제외하고 입력해주세요." size="30"></td>
		</tr>
		
		<tr>
			<td>생년월일       </td>
			<td><input type="text" name="brithday" 
			placeholder="8자리 입력(19900314)" size="30"></td>
		</tr>
		
	
		<tr>
			<td colspan="2" align="center">
			<input type="submit" value="가입" onclick="return joinCheck()">
				
			</td>
		</tr>
	</table>
</form>
		<a href="member.do?action=main"><button>메인으로가기</button></a>
		
</body>
</html>