<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:forward page="/WEB-INF/paginas/forward.jsp" >
		<jsp:param value="curso de jsp" name="curso"/>
	</jsp:forward>
</body>
</html>