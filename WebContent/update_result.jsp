<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>

<title>update_result.jsp</title>
</head>
<body>

<c:if test="${not empty sessionScope.email}">
 <script type="text/javascript">
 	alert("�����Ǿ����ϴ�.");
 	location.href="member.do?action=main";
 </script>
</c:if>

</body>
</html>