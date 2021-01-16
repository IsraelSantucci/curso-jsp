<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginServlet" method="post">
		Usuario: <input type="text" name="usuario"/> <br>
		Senha: <input type="password" name="senha" /> <br>
		<input type="submit" value="logar" />
	</form>
</body>
</html>