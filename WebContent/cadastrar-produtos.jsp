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
		<h3 id="msg-login-repetido">${msg}</h3>
		<form action="CadastrarProdutos" method="post" autocomplete="off" id="formulario">
			<label>Código</label>
			<input type="text" name="codigo" readonly="true" value = "${produto.codigo}">
		
			<label>Nome</label>
			<input type="text" name="nome" value="${produto.nome}">
			<p style="color:red">${ErroNomeProduto}</p>
		
			<label>Quantidade</label>
			<input type="text" name="quantidade" value="${produto.quantidade}">
		
			<label>Valor</label>
			<input type="text" name="valor" value="${produto.valor}">
		
			<input type="submit" value="Cadastrar"> 
			<input type="submit" value="Cancelar" onclick="document.getElementById('formulario').action='CadastrarProdutos?acao=reset'">
			
		</form>
	</div>
	<a href="LoginServlet"><img alt="voltar" src="resources/img/voltar.png" title="voltar" width="20px" height="20px">Voltar</a>
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
							<td><a href="CadastrarProdutos?acao=editar&codigo=${produto.codigo }"><img src="resources/img/editar.png" width="30px" height="30px" alt="Editar" title="Editar"></a></td>
							<td><a href="CadastrarProdutos?acao=excluir&codigo=${produto.codigo }"><img src="resources/img/excluir.png" width="30px" height="30px" alt="Excluir" title="Excluir"></a></td>
						</tr>
					</c:forEach>
			
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>