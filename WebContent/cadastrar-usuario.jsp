<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastrar Usuarios</title>
<link rel="stylesheet" href="resources/css/cadastro.css">
<link rel="stylesheet" href="resources/css/table.css">
</head>
<body>


	<div class="form-style-6">
		<h1>Cadastrar Usuarios</h1>
		<form action="CadastrarUsuario" method="post">
			<label for="id">Id: </label> <input type="text" name="id"
				readonly="readonly" value="${usuario.id }" /> <label for="login">Login:</label>
			<input type="text" name="login" value="${usuario.login }" />
			<label for="nome">Nome:</label> <input type="text" name="nome" value="${usuario.nome }">
			<label for="senha"> Senha:</label> <input type="password"
				name="senha" value="${usuario.senha }" /> <input type="submit"
				value="Cadastrar">
		</form>
	</div>
	<br>
	<a href="index.jsp">voltar para inicio</a>
	<br>
	<br>
	<div class="div-tabela">
		<h2>Usuarios Cadastrados</h2>

		<div class="main">
			<table class="tabela">
				<thead>
					<tr>
						<th>Id</th>
						<th>Login</th>
						<th>Nome</th>
						<th></th>
						<th></th>

					</tr>
				</thead>
				<tfoot>
				<tfoot>
				<tbody>
					<c:forEach items="${usuarios}" var="usuario">
						<tr>
							<td data-title="Id"><c:out value="${usuario.id }"></c:out></td>
							<td data-title="Login"><c:out value="${usuario.login }"></c:out></td>
							<td data-title="Nome"><c:out value="${usuario.nome }"></c:out></td>
							<td class="select" ><a class="button-editar"
								href="CadastrarUsuario?acao=editar&login=${usuario.login}">Editar</a></td>
							<td class="select" ><a class="button-excluir"
								href="CadastrarUsuario?acao=delete&login=${usuario.login}">Excluir</a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>