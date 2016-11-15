<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page isErrorPage="true" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>errorPage.jsp</title>
</head>
<body>

	우리프로젝트에서 임의로 지정한 예외 페이지이며 web.xml파일에 등록된 500,404 에러에 대한 처리입니다. <br>
	좀더 다양한 에러처리를 하고싶은경우 에러타입을 추가하세요<br>
	이곳은 에러페이지 입니다.<br>
	다음과 같은 에러가 발생하였습니다<br>
	에러메세지 : <%=exception.getMessage() %>
	에러 경로 : <%=exception.getStackTrace() %>
	에러 타입 : <%=exception.getClass().getName() %>
	
</body>
</html>