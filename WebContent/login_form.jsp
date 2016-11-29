<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<meta charset="UTF-8">
<title>login_form.jsp</title>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>

<script type="text/javascript" src="js/member.js" ></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    Materialize.updateTextFields();
  });
</script>
       
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

</head>
<body>
<div class="container">
<h4>로그인</h4>
	<div class="row">
		<form class="col s6 m12 l12" action="member.do" method="post" name="frm" >
			<input type="hidden" name="action" value="login_check" >
			
			<div class="row">
				<div class="input-field col s0">
				<i class="material-icons">email</i>	
				</div>
				<div class="input-field col s6">	
					<input type="text" name="email" 
					 placeholder="이메일을 입력해주세요."	value="${email}">		
				</div>
			</div>
			
			<div class="row">
				<div class="input-field col s0">
				<i class="material-icons">lock</i>	
				</div>
				<div class="input-field col s6">
						
					<input type="password" name="pwd" 
					 placeholder="비밀번호을 입력해주세요."	>		
				
				</div>		
			
			</div>	
						
				 <a class="waves-effect waves-light btn">
				 <input type="submit" value="로그인" onclick="return loginCheck()">  
				</a>	
				<a class="waves-effect waves-light btn">				
				 <input type="reset" value="취소">
				</a>				
			
		</form>
	</div>
</div>	
</body>
</html>


					