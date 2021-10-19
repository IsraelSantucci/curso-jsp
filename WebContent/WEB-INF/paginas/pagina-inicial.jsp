<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Pagina principal</h1>
	<jsp:include page="cabecalho.jsp"></jsp:include>
	<p> Essa pagina serve para testar o uso da tag jsp:include.</p>
	<p>Com o uso dela é possivel adicionar dados de outras paginas o que facilita a manutençao do site</p>
	<jsp:include page="rodape.jsp"></jsp:include>
</body>
</html>