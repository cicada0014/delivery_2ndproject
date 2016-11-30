<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="template/css/materialize.min.css"  media="screen,projection"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="template/js/materialize.min.js"></script>
<title>insertScore</title>
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>
</head>
<body>
<div class="container-fluid">
<!-- 	header section -->
<div class="row">
<c:import url="projectHeader.jsp" var="header"></c:import>
	<%=pageContext.getAttribute("header")%>
</div>
<!-- 	category section -->
	<div class="row">
		<div id="categorySection" class="grey darken-4">
			<br>
			<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
			<span id="categorySpan">${categoryList }</span> 
			<script type="text/javascript">
				$('#categorySpan').find('#categoryCarousel').remove(); // categoryCarousel만 지움
			</script>
		</div>
	</div>
</div>

<form action="File" method="post">
	메뉴이름<input type="text" name="menuName" value="" disabled="disabled"><br>
	

</form>
</body>
</html>