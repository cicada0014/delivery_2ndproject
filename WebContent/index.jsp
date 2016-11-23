<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<c:import url="bootstrapCDN.html" var="bootstrap"></c:import>
<%=pageContext.getAttribute("bootstrap") %>
<title>index.jsp</title>
</head>
<body>
<c:if test="${not empty sessionScope.userid}">
	  ${sessionScope.userid}님  
	  <a href="member.do?action=update&userid=${sessionScope.userid}"><button>정보수정</button></a>
	  <a href="member.do?action=logout"><button>로그아웃</button></a> 

</c:if>	



<div class="container">
	<div class="row">
		<div class="col-xs-1 col-sm-2 col-md-3 col-lg-4"></div>
		<div class="col-xs-10 col-sm-8 col-md-6 col-lg-4">
			<img src="images/indexImg.png" alt="indexImage" height="100px">
		</div>
		<div class="col-xs-1 col-sm-2 col-md-3 col-lg-4"></div>
	</div>

<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
${categoryList }<br>



화면 구성중 <br>

<a href="list?command=insertRestaurantInfoForm"><button>식당 정보 입력하기</button></a>

<c:if test="${empty sessionScope.userid}">
<a href="member.do?action=login"><button>로그인</button></a>

<a href="member.do?action=join"><button>회원가입</button></a>

</c:if>	


	

</div>
</body>

</html>