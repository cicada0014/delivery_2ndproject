<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
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
<title>update_from.jsp</title>
</head>
<body>
<div class="container">
	<h2>회원정보수정</h2>
	<form class="col s6 m12 l12" action="member.do" method="post" name="frm" >
		<input type="hidden" name="action" value="update_get" >
		
						
			<div class="row">
    			<div class="input-field col s0">
      				<i class="material-icons">email</i> 
      			</div>
      			<div class="input-field col s6"> 		
      				<input type="email" name="email" value="${mvo.email}" size="30" 
							id="email" class="validate" readonly> 
				</div>
			</div>
			
			<div class="row">
    			<div class="input-field col s0">
      				<i class="material-icons">contacts</i>
      			</div>
      			<div class="input-field col s6">
      				<input type="text" name="name" value="${mvo.name}"
					size="30" id="name"  class="validate">
    			</div>
 	 		</div>
			
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
							
			<div class="row">
    			<div class="input-field col s0">
      				<i class="material-icons">phone</i>
      			</div>
      			
      			<div class="input-field col s6">	
      				<input type="text" name="phone"
					value="${mvo.phone}"  
     					id="phone" class="validate">
 	 			</div>
	 	 	 </div>	
		
			
	 	 	<div class="row">
    			<div class="input-field col s0">
      				생년월일
      			</div>
      			<div class="input-field col s6">
      				<input name="brithday" value="${mvo.brithday}" size="30"
      					id="brithday" type="text" class="validate">
    			</div>
 	 		</div>	
 		
				
			
			
			
				<input type="submit" value="확인" onclick="return joinCheck()" class="waves-effect waves-light btn" >
				<input type="reset" value="취소" class="waves-effect waves-light btn" >
	
	</form>

</div>
</body>
</html>
