<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cadastro de Telefones</title>
<link rel="stylesheet" href="resources/css/cadastro.css">
<link rel="stylesheet" href="resources/css/table.css">
</head>
<body>
	<h3>usuario:${usuario.nome }</h3>
	<div class="form-style-6">
		<h1>Cadastrar Telefone</h1>
		<form>
			<label>Telefone</label> <input type="text" name="telefone"> <input
				type="submit" value="Cadastrar"> <input type="submit"
				value="Cancelar">
		</form>
	</div>

	<div class="div-tabela">
		<h2>Telefones Cadastrados</h2>
		<div class="main">
			<table class="tabela">
				<thead>
					<th>telefone</th>
				</thead>
				<tbody>
					<c:forEach items="${telefones }" var="telefone">


					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>