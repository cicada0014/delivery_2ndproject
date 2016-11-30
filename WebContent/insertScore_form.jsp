<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
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
<%
	String idStr = request.getParameter("restaurantId");
	int id = 0;
	
	if(idStr != null && idStr.length() > 0)
	{
		id = Integer.parseInt(idStr);
		System.out.println(id);
	}else{
		System.out.println("Error!");
	}
%>
<div class="container">
	<div class="row">
		<form class="col s12" method="post" action="menuList.do">
			<div class="row">
				<div class="input-field col s9">
					<input name="restaurantName" type="text" class="validate" value=<%=id %> readonly="readonly">
					<label for="restaurantName">식당이름</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s9">
					<input name="userName" type="text" class="validate">
					<label for="userName">사용자명</label>
				</div>
			</div>
			<div class="row">
				<div class="input-field col s9">
					<textarea name="restaurantComment" class="materialize-textarea" length="500"></textarea>
					<label for="restaurantComment">평가내용</label>
				</div>
			</div>
			<div class="row">
				<div class="file-field input-field">
					<div class="file-path-wrapper col s7">
					<input name="commentImgPath" class="file-path validate" type="text" placeholder="첨부사진" disabled>
					</div>
					<div class="btn">
						<input type="file" id="commentPhotoSelect">
						<span>사진선택</span>
					</div>
				</div>
			</div>
			
			<div class="row">
				<input type="hidden" name="restaurantId" value=<%=id %>>
				<a href="/menuList.do?action=insertScore"><button class="btn waves-effect waves-light btn-large" id="submit" name="action" value="insertScore">메뉴등록</button></a>
			</div>
		</form>
	</div>
</div>

</form>
</body>
</html>