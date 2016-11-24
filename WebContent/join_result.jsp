<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>

<title>join_result.jsp</title>
</head>
<body>
 <c:if test="${not empty email}">
 <script type="text/javascript">
 	alert("회원가입 성공");
 	location.href="member.do?action=main";
 </script>
</c:if>
 
<c:if test="${empty email}"> 
 <script type="text/javascript">
 	alert("회원가입 실패");
 	location.href="member.do?action=join";
 </script>
</c:if>


</body>
</html>