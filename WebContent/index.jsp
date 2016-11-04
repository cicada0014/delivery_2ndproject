<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>
</head>
<body>



화면 구성중
<form action="list" >
<input type="submit" value="리스트화면으로">

</form>
<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
${categoryList }


</body>

</html>