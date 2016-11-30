<%@page import="com.mc.delivery.vo.RestaurantsScoreVO"%>
<%@page import="java.util.List"%>
<%@page import="com.mc.delivery.service.MenuService"%>
<%@page import="com.mc.delivery.vo.MenuVO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="template/css/materialize.min.css"  media="screen,projection"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="template/js/materialize.min.js"></script>
<title>menu.jsp</title>
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>
<style type="text/css">
	table
	{
 		margin:auto;
	}
	#restaurants
	{
		font-size: 20px;
	}
	#restaurantsAddress
	{
		font-style: italic;
	}
	#menuReply
	{
		font-size: 20px;
	}
/* 	�ο�Ŭ���� �ǵ帮�� ��ü�� ������ ��Ʋ���ϴ�. */
	.menuScreen     
	{
/* 		height:100%; */
		position: relative;
		top:20px;
	}
</style>
<script type="text/javascript">
	$(function(){
		$(document).ready(function(){
			$('ul.tabs').tabs();
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

<%
	String idStr = request.getParameter("restaurantId");
	int id = 0;
	
	if(idStr != null && idStr.length() > 0)
	{
		id = Integer.parseInt(idStr);
		System.out.println(id);
	}else{
		System.out.println("����");
		
	}
	
	MenuService service = MenuService.getInstance();
	List<MenuVO> menuList = service.readList(id);
	List<RestaurantsScoreVO> scoreList = service.readReply(id);
	System.out.println(scoreList);
%>
	<div class="container">
		<div class="row menuScreen">
			<div class="col s12" id="restaurants">
				<div class="card-panel teal lighten-2 col s6" id="restaurantsName">
					${restaurant.restaurantName}
				</div>
				<div class="card-panel teal lighten-2 col s6" id="restaurantsAddress">
					${restaurant.restaurantLocation}
				</div>
			</div>
			<div class="col s9">
				<ul class="tabs">
					<li class="tab col s2"><a href="#mainMenu">���θ޴�</a></li>
					<li class="tab col s3"><a href="#sideMenu">���̵�޴�</a></li>
					<li class="tab col s2"><a href="#drinkMenu">����</a></li>
					<li class="tab col s2"><a href="#etcMenu">��Ÿ</a></li>
				</ul>
			</div>
			<div id="mainMenu" class="card-panel col s8">
				<ul class="collection">
				<%for(int i=0; i<menuList.size(); i++) {
					if(menuList.get(i).getMenuCategory() == 1)
							{%>
						<a href="#"><li class="collection-item avatar">
						<img src="images/default_img.png" alt="" class="circle">
						<span class="title"><%=menuList.get(i).getMenuName() %></span>
						<p><%=menuList.get(i).getMenuPrice() %>��</p>
						<p><%=menuList.get(i).getMenuInfo() %></p>
						<%} %>
					</li>
					</a>
				<%} %>
				</ul>
			</div>
			<div id="sideMenu" class="card-panel col s8">
				<ul class="collection">
				<%for(int i=0; i<menuList.size(); i++) {
					if(menuList.get(i).getMenuCategory() == 2)
							{%>
						<a href="#"><li class="collection-item avatar">
						<img src="images/default_img.png" alt="" class="circle">
						<span class="title"><%=menuList.get(i).getMenuName() %></span>
						<p><%=menuList.get(i).getMenuPrice() %>��</p>
						<p><%=menuList.get(i).getMenuInfo() %></p>
						<%} %>
					</li>
					</a>
				<%} %>
				</ul>
			</div>
			<div id="drinkMenu" class="card-panel col s8">
				<ul class="collection">
				<%for(int i=0; i<menuList.size(); i++) {
					if(menuList.get(i).getMenuCategory() == 3)
							{%>
						<a href="#"><li class="collection-item avatar">
						<img src="images/default_img.png" alt="" class="circle">
						<span class="title"><%=menuList.get(i).getMenuName() %></span>
						<p><%=menuList.get(i).getMenuPrice() %>��</p>
						<p><%=menuList.get(i).getMenuInfo() %></p>
						<%} %>
					</li>
					</a>
				<%} %>
				</ul>
			</div>
			<div id="etcMenu" class="card-panel col s8">
				<ul class="collection">
				<%for(int i=0; i<menuList.size(); i++) {
					if(menuList.get(i).getMenuCategory() == 4)
						{%>
						<a href="#"><li class="collection-item avatar">
						<img src="images/default_img.png" alt="" class="circle">
						<span class="title"><%=menuList.get(i).getMenuName() %></span>
						<p><%=menuList.get(i).getMenuPrice() %>��</p>
						<p><%=menuList.get(i).getMenuInfo() %></p>
						<%} %>
					</li>
					</a>
				<%} %>
				</ul>
			</div>

			<div class="col s4 ">
				<div class="card white">
					<div class="card-content black-text">
						<span class="card-title">���������</span>
						<p>
						�����ð�:	 ${restaurant.restaurantOpenTime} ~ ${restaurant.restaurantCloseTime}<br>
						��������: ${restaurant.restaurantPhone}
						
 						</p>
					</div>
					<div class="card-action">
<!-- 						<a href="#">This is a link</a> <a href="#">This is a link</a> -->
					</div>
				</div>
				<div style="text-align:center"><a class="waves-effect waves-light btn-large">��ٱ���</a></div><br>
				<div style="text-align:center"><a class="waves-effect waves-light btn-large">�����ϱ�</a></div>
			</div>
		</div>
		
		<div class="row menuScreen">
			<div class="col s12" id="menuReply">
				<div class="card-panel teal lighten-2 col s9" style="text-align:center">�Ĵ���</div>
				<a class="waves-effect waves-light btn col s2 push-s1" href="menuList.do?action=insertScoreForm">�򰡳����</a>
			</div>
			<%for(int i=0; i<scoreList.size(); i++) { %>
			<div class="col s12">
				<div class="card-panel teal lighten-2 col s2"><%=scoreList.get(i).getUserName() %></div>
				<div class="card-panel teal lighten-2 col s10">
				<%=scoreList.get(i).getRestaurantComment() %>
				<%if(scoreList.get(i).getCommentImgPath() != null) { %>
					<img src="<%=scoreList.get(i).getCommentImgPath()%>">
				<%} %>
				</div>
			</div>
			<%} %>
		</div>
	</div>
	
	
<!-- �̺κ��� ������Ʈ���� ���̴� Ǫ�ͺκ��Դϴ�. ����� ���� �ϴܿ� �����ִ� ���� ����̳� ȸ���������� ������ ��Ÿ���� �ִ� ���Դϴ�. ���� ���������� �и��Ͽ����ϴ�.  -->
<c:import url="projectFooter.jsp" var="footer"></c:import>
<%=pageContext.getAttribute("footer")%>

</body>


</html>