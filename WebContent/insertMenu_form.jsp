<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet"> -->
<!-- <link type="text/css" rel="stylesheet" href="template/css/materialize.min.css"  media="screen,projection"/> -->
<!-- <meta name="viewport" content="width=device-width, initial-scale=1.0"/> -->
<!-- <script src="//code.jquery.com/jquery-1.12.0.min.js"></script> -->
<!-- <script type="text/javascript" src="template/js/materialize.min.js"></script> -->
<title>insertMenu.jsp</title>
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>
<script type="text/javascript">
	$(function(){
		
		$(document).ready(function(){
			$('select').material_select();			//����Ʈ �ڽ�
			$('textarea').trigger('autoresize');	//�޴�����
			
			var menuCategoryValue = $('value').val(); //����Ʈ �ڽ� �� �����ͼ� ī�װ� �з�
		});
	})
</script>
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
				$('#categorySpan').find('#categoryCarousel').remove(); // categoryCarousel�� ����
			</script>
		</div>
	</div>
</div>
<div class="container">
	<div class="row">
		<form class="col s11 push-s2" method="post" action="menuList.do">
			<div class="row">
				<div class="input-field col s9">
					<input name="restaurantName" type="text" class="validate">
					<label for="restaurantName">�Ĵ��̸�</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s9">
					<select name="menuCategory">
						<option value="" disabled selected>ī�װ� ����</option>
						<option value="1">���θ޴�</option>
						<option value="2">���̵�޴�</option>
						<option value="3">����</option>
						<option value="4">��Ÿ</option>
					</select>
					<label>ī�װ�</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s9">
					<input name="menuName" type="text" class="validate">
					<label for="menuName">�޴��̸�</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s9">
					<input name="menuPrice" type="text" class="validate">
					<label for="menuPrice">�޴�����</label>
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s9">
					<textarea name="menuInfo" class="materialize-textarea" length="120"></textarea>
					<label for="menuInfo">�޴�����</label>
				</div>
			</div>
			
			<div class="row">
				
				<div class="file-field input-field">
					<div class="file-path-wrapper col s7">
					<input name="imgPath" class="file-path validate" type="text" placeholder="�޴�����" disabled>
					</div>
					<div class="btn">
						<input type="file" id="photoSelect">
						<span>��������</span>
					</div>
				</div>
			</div>
			
			<div class="row">
				<a href="/menuList.do?action=insertResult"><button class="btn waves-effect waves-light btn-large" id="submit" name="action" value="insertMenu">�޴����</button></a>
			</div>
		</form>
	</div>
</div>
</body>
</html>