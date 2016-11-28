<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<link type="text/css" rel="stylesheet" href="template/css/materialize.min.css"  media="screen,projection"/>
<meta name="viewport" content="width=device-width, initial-scale=1.0"/>
<script src="//code.jquery.com/jquery-1.12.0.min.js"></script>
<script type="text/javascript" src="template/js/materialize.min.js"></script>
<title>menu.jsp</title>
<style type="text/css">
	table
	{
 		margin:auto;
	}
	#panel
	{
		margin:auto;
	}
	html
	{
		height:100%;
	}
	body
	{
		height:100%;
	}
	
	.row
	{
		height:100%;
		position: relative;
		top:20px;
	}
	
</style>
<script type="text/javascript">
	$(function(){
		$(document).ready(function(){
// 			$('ul.tabs').tabs('select_tab','tab_id');
			$('ul.tabs').tabs();
		});
	})
</script>
</head>
<body>
<div class="card-panel teal lighten-2" id="panel">menu</div>
	<div class="container">
		<div class="row">	
			<div class="col s9">
				<ul class="tabs">
					<li class="tab col s2"><a href="#mainMenu">메인메뉴</a></li>
					<li class="tab col s2"><a href="#sideMenu">사이드메뉴</a></li>
					<li class="tab col s2"><a href="#drinkMenu">음료</a></li>
					<li class="tab col s2"><a href="#etcMenu">기타</a></li>
				</ul>
			</div>
			<div id="mainMenu" class="col s9">메인메뉴</div>
			<div id="sideMenu" class="col s9">사이드메뉴</div>
			<div id="drinkMenu" class="col s9">음료</div>
			<div id="etcMenu" class="col s9">기타</div>
			
			<div class="col s3">
				<div>매장정보</div>
				<hr/>
				<div>장바구니</div>
				<hr/>
				<div>결제하기</div>
				<hr/>
			</div>
		</div>
	</div>
</body>
</html>