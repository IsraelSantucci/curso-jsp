<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Usuarios</title>
</head>
<body>
	<h1>Cadastrar Usuarios</h1>

	<form action="CadastrarUsuario" method="post">
		<table>
			<tr>
				<td>Id:</td>
				<td><input type="text" name="id" readonly="readonly" value="${usuario.id }"/></td>
			</tr>
			<tr>
				<td>Login:</td>
				<td><input type="text" name="login" value="${usuario.login }"/></td>
			</tr>
			<tr>
				<td>Senha:</td>
				<td><input type="password" name="senha" value="${usuario.senha }"/></td>
			</tr>
			<tr>
				<td><input type="submit" value="cadastrar"></td>
			</tr>
		</table>
	</form>
	<br>
	<a href="index.jsp">voltar para inicio</a>
	<br>
	<br>
	<h2>Usuarios Cadastrados</h2>
	<table >

		<c:forEach items="${usuarios}" var="usuario">
			<tr>
				<td style="width:100px"><c:out value="${usuario.id }"></c:out></td>
				<td style="width:100px"><c:out value="${usuario.login }"></c:out></td>
				<td> <c:out value="${usuario.senha }"></c:out></td>
				<td><a
					href="CadastrarUsuario?acao=editar&login=${usuario.login}">Editar</a></td>
				<td><a
					href="CadastrarUsuario?acao=delete&login=${usuario.login}">Excluir</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>