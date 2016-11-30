<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>insertScore_result</title>
</head>
<body>
<%
	String idStr = request.getParameter("restaurantId");
	int id = 0;
	
	if(idStr != null && idStr.length() > 0)
	{
		id = Integer.parseInt(idStr);
		System.out.println(id);
	}else{
		System.out.println("Error!");
	}
%>
<script type="text/javascript">
	alert("평가가 등록되었습니다.");
	location.href="/delivery_2ndproject/menuList.do?action=menuList&restaurantId=<%=id%>";
</script>
</body>
</html>