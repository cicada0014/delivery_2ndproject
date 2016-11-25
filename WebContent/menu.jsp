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
<%=pageContext.getAttribute("bootstrap") %>
<%MenuVO vo = new MenuVO(); %>
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
	
	.row
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
<!-- 	header section -->
<c:import url="projectHeader.html" var="header"></c:import>
<%=pageContext.getAttribute("header")%>
	<div class="container">
		<div class="row">
			<div class="col s12" id="restaurants">
				<div class="card-panel teal lighten-2 col s6" id="restaurantsName">
				�Ĵ��̸�
				</div>
				<div class="card-panel teal lighten-2 col s6" id="restaurantsAddress">
				�Ĵ��ּ�
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
			<div id="mainMenu" class="card-panel teal lighten-2 col s8">���θ޴�</div>
			<div id="sideMenu" class="card-panel teal lighten-2 col s8">���̵�޴�</div>
			<div id="drinkMenu" class="card-panel teal lighten-2 col s8">����</div>
			<div id="etcMenu" class="card-panel teal lighten-2 col s8">��Ÿ</div>
			
			<div class="col s3 offset-s9">
				<div style="text-align:justify">��������</div>
				<br>
				<div style="text-align:center"><a class="waves-effect waves-light btn-large">��ٱ���</a></div><br>
				<div style="text-align:center"><a class="waves-effect waves-light btn-large">�����ϱ�</a></div>
			</div>
		</div>
		
		<div class="row">
			<div class="col s12" id="menuReply">
				<div class="card-panel teal lighten-2 col s12" style="text-align:center">�Ĵ���</div>
			</div>
			<div class="col s12">
				<div class="card-panel teal lighten-2 col s2">�ۼ��� �̸�&����</div>
				<div class="card-panel teal lighten-2 col s10">�� ����&����</div>
			</div>
		</div>
	</div>
</body>
</html>