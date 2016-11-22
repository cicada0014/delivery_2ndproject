<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>index.jsp</title>
</head>
<body>



화면 구성중<br>

<c:import url="list?command=selectCategoryList" var="categoryList"></c:import>
${categoryList }<br>



화면 구성중 <br>

<a href="list?command=insertRestaurantInfoForm"><button>식당 정보 입력하기</button></a>

<c:if test="${empty sessionScope.userid}">
<a href="member.do?action=login"><button>로그인</button></a>

<a href="member.do?action=join"><button>회원가입</button></a>

</c:if>	


<c:if test="${not empty sessionScope.userid}">
	  ${sessionScope.userid}님 어서오십시오. 
	  <a href="member.do?action=update&userid=${sessionScope.userid}"><button>정보수정</button></a>
	  <a href="member.do?action=logout"><button>로그아웃</button></a> 

</c:if>	
	


</body>

</html>