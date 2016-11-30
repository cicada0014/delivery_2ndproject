<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
<c:import url="design_reference.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap")%>
<script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
    Materialize.updateTextFields();
  });
</script>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
<title>idcheck.jsp</title>
<script type="text/javascript" src="js/member.js"></script>
</head>
<body>
	<h5>이메일 중복확인</h5>
	<div class="row">
	<form action="member.do" method="get" name="frm" >
		<div class="row">
    		<div class="input-field col s0">
      			<i class="medium material-icons">email</i>
			</div>
			<div class="input-field col s6">		 
			<input type="text" name="email" >
			</div>
				<input type="hidden" name="action" value="emailcheck" >
			<button class="btn waves-effect waves-light" type="submit">중복 체크
  			</button>
		
		</div>
			
			 <c:if test="${result == 1}">
				<script type="text/javascript">
					opener.document.frm.email.value="${email}";
				</script>
				${email}는 이미 사용 중인 이메일입니다.	
			 </c:if>
			
		 	
			
		     <c:if test="${result == -1}">
				${email}는 사용 가능한 이메일입니다.	
			
			 <button class="btn waves-effect waves-light" type="button" onclick="use()">사용
  			</button>
			
<!-- 			<input type="button" value="사용"  onclick="use()" > 				 -->
			
		<script type="text/javascript">		
		function use(){
		opener.frm.email.value="${email}";
		opener.frm.Repetitious.value="${email}";
		self.close();
		}
		</script>
		  	</c:if>	
		
		
				
	</form>
	</div>
</body>
</html>




