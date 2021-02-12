<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Cadastro de Produto</title>
	<link rel="stylesheet" href="resources/css/cadastro.css">
	<link rel="stylesheet" href="resources/css/table.css">
</head>
<body>
	<div class="form-style-6">
		<h1>Cadastrar Produto</h1>
		<form action="CadastrarProdutos" method="post">
			<label>Código</label>
			<input type="text" name="codigo" readonly="true" value = ${produto.codigo}>
		
			<label>Nome</label>
			<input type="text" name="nome" value=${produto.nome}>
		
			<label>Quantidade</label>
			<input type="text" name="quantidade" value=${produto.quantidade}>
		
			<label>Valor</label>
			<input type="text" name="valor" value=${produto.valor}>
		
			<input type="submit" value="Cadastrar">
		</form>
	</div>
	<div class="div-tabela">
		<h2>Produtos Cadastrados</h2>
		<div class="main">
			<table class="tabela">
				<thead>
					<th>Código</th>
					<th>Nome</th>
					<th>Quantidade</th>
					<th>Valor</th>	
					<th></th>
					<th></th>
				</thead>
				<tbody>
					<c:forEach items="${produtos }" var="produto">
						<tr>
							<td>${produto.codigo }</td>
							<td>${produto.nome }</td>
							<td>${produto.quantidade }</td>
							<td>${produto.valor }</td>
							<td><a href="CadastrarProdutos?acao=editar&codigo=${produto.codigo }">Editar</a></td>
							<td><a href="CadastrarProdutos?acao=excluir&codigo=${produto.codigo }">Excluir</a></td>
						</tr>
					</c:forEach>
			
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>