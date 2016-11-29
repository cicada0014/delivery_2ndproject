<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<title>idcheck.jsp</title>
<script type="text/javascript" src="js/member.js"></script>
</head>
<body>
	<h2>이메일 중복확인</h2>
	<form action="member.do" method="get" name="frm" >
		이메일 <input type="text" name="email" >
				<input type="hidden" name="action" value="emailcheck" >
				<input type="submit" value="중복 체크" >
			<br>
			 <c:if test="${result == 1}">
				<script type="text/javascript">
					opener.document.frm.email.value="${email}";
				</script>
				${email}는 이미 사용 중인 이메일입니다.	
			 </c:if>
		 	
		  <c:if test="${result == -1}">
				${email}는 사용 가능한 이메일입니다.	
				<input type="button" value="사용"  onclick="use()" > 				
		<script type="text/javascript">		
		function use(){
		opener.frm.email.value="${email}";
		opener.frm.Repetitious.value="${email}";
		self.close();
		}
		</script>
		
		
				
		  </c:if>	
	</form>

</body>
</html>




