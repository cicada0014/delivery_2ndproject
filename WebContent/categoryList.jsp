<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>categoryList.jsp</title>
</head>
<body>
<c:forEach var="category" items="${requestScope.categoryList}">
<a href="list?command=takeList&option=${pageScope.category.categoryName}"><button>
<img src="images/${pageScope.category.categoryImg}" alt="default">
${pageScope.category.categoryName}</button></a>
</c:forEach>


</body>
</html>