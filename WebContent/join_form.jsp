<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>
<script type="text/javascript" src="js/member.js">
</script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
          
<script type="text/javascript">
$(document).ready(function() {
    Materialize.updateTextFields();
  });
</script>

        
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>Insert title here</title>
</head>
<body>
<div class="container">
	<h1>회원 가입</h1>
	<div class="row">
    	<form class="col s6 m12 l12" action="member.do" method="post" name="frm">					
	 		<input type="hidden" name="action" value="join_get">
	 		
<!--  	 	----------	 -->
 	 		<div class="row">
    			<div class="input-field col s0">
      				<i class="material-icons">email</i> 
      			</div>
      			<div class="input-field col s6">		
      				<input type="email" name="email"
						placeholder="hongildong@exeample.com" size="30"
							id="email" class="validate"> 
					<input type="hidden" name="Repetitious" size="30">
      			</div>
      				
      			<div class="input-field col s0">	
      				<a class="waves-effect waves-light btn">
      				<input type="button" value="중복체크" onclick="idCheck()">
      				</a>
      			</div>
      			
 	 		</div>
<!--  	 	----------	 -->
 	 		
 	 		<div class="row">
    			<div class="input-field col s0">
      				<i class="material-icons">contacts</i>
      			</div>
      			<div class="input-field col s6">
      				<input type="text" name="name" placeholder="닉네임을 입력해주세요."
					size="30" id="name"  class="validate">
    			</div>
 	 		</div>
      				
 	 					
<!-- 		------------		 -->
 	 		
 	 		
	 		
 	 		<div class="row">
    			<div class="input-field col s0">
      				<i class="material-icons">lock</i>
      			</div>
      			<div class="input-field col s6">	
      				<input type="password" name="pwd"
					placeholder="비밀번호를 6~20자로 입력해주세요." size="31" 
						id="pwd"  class="validate">
    			</div>
 	 		</div>
      				
 	 			 			
<!--  	----------				 -->
 	 		
 	 		
 	 		<div class="row">
    			<div class="input-field col s0">
      				<i class="material-icons">done</i>
				</div>
      			<div class="input-field col s6">
      				<input type="password" name="pwd_check"
					placeholder="비밀번호를 재입력해주세요." size="31" 
      					id="pwd_check"  class="validate">
    			</div>
 	 		</div>
      				
 	 	
<!--  	----------- 		 -->
	 	
 	 	
 	 		<div class="row">
    			<div class="input-field col s0">
      				<i class="material-icons">phone</i>
      			</div>
      			
      			<div class="input-field col s6">	
      				<input type="text" name="phone"
					placeholder="'-'를 제외하고 휴대폰 번호를 입력해주세요."  
     					id="phone" class="validate">
 	 			</div>
	 	 	 </div>
 	 				  
      			  			
 	 	
<!--  	 ----------	 -->
				
		 	
 	 	
	 	 	<div class="row">
    			<div class="input-field col s0">
      				생년월일
      			</div>
      			<div class="input-field col s6">
      				<input name="brithday" placeholder="8자리 입력(19900314)" size="30"
      					id="brithday" type="text" class="validate">
    			</div>
 	 		</div>	
 		 	
 		 	<input type="submit" value="가입"
					onclick="return joinCheck()" class="waves-effect waves-light btn">
      				
		</form>
	</div>     
 	 		 		
 	 		 		

	<a href="member.do?action=main" class="waves-effect waves-light btn">메인으로가기</a>

	
			

</div>

</body>
</html>