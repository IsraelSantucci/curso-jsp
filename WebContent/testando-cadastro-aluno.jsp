<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>CADASTRO ALUNO</h1>
	<form action="registra-aluno.jsp">
		<table>
			<tr>
				<td>nome:</td>
				<td><input type="text" name="nome" /></td>
			</tr>
			<tr>
				<td>cpf:</td> 
				<td><input type="text" name="cpf" /></td>
			</tr>
			<tr>
				<td>idade:</td> 
				<td><input type="text" name="idade" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="cadastrar" /></td>
			</tr>
		</table>
	</form>
</body>
</html>