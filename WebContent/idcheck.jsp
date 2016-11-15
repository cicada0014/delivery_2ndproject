<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<title>idcheck.jsp</title>
<script type="text/javascript" src="script/member.js"></script>
</head>
<body>
	<h2>아이디 중복확인</h2>
	<form action="member.do" method="get" name="frm" >
		아이디 <input type="text" name="userid" >
				<input type="hidden" name="action" value="idcheck" >
				<input type="submit" value="중복 체크" >
			<br>
			 <c:if test="${result == 1}">
				<script type="text/javascript">
					opener.document.frm.userid.value="";
				</script>
				${userid}는 이미 사용 중인 아이디입니다.	
			 </c:if>
		 	
		  <c:if test="${result == -1}">
				${userid}는 사용 가능한 아이디입니다.	
				<input type="button" value="사용"  onclick="use()" > 				
		<script type="text/javascript">		
		function use(){
		opener.frm.userid.value="${userid}";
		opener.frm.Repetitious.value="${userid}";
		self.close();
		}
		</script>
		
		
				
		  </c:if>	
	</form>

</body>
</html>




