<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%session.setAttribute("curso", "curso java Web") ;%>
	<jsp:forward page="/WEB-INF/paginas/redirecionamento-session.jsp" >
		<jsp:param value="" name=""/>
	</jsp:forward>
	
</body>
</html>