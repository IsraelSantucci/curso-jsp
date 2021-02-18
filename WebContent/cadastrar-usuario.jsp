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

	<h3>usuario: ${sessionScope.usuarioLogado.nome}</h3>
	<div class="form-style-6">
		<h1>Cadastrar Usuarios</h1>
		
		<h3 id="msg-login-repetido">${msg}</h3>
		
		<form id="formCadastro" action="CadastrarUsuario" method="post" autocomplete="off" onsubmit="return validarCampos() ? true : false">
		
			<label for="id">Id: </label> 
			<input type="text" name="id" readonly="readonly" value="${usuario.id }" /> 
			
			<label for="login">Login:</label>	
			<input type="text"  id="login" name="login" value="${usuario.login }" />
			
			<label for="nome">Nome:</label> 
			<input type="text" id="nome" name="nome" value="${usuario.nome }">
			
			<label for="telefone">Telefone:</label>
			<input type="text" id="telefone" name="telefone" value="${usuario.telefone }">
			
			<label for="senha"> Senha:</label> 
			<input id="senha" type="password" name="senha" value="${usuario.senha }"  /> 
			<input type="checkbox" onclick="exibirSenha()">
			<input type="submit" value="Cadastrar"> <input type="submit" value="Cancelar" onclick="document.getElementById('formCadastro').action='CadastrarUsuario?acao=reset'">
		</form>
	</div>
	<br>
	<a href="LoginServlet"><img alt="voltar" src="resources/img/voltar.png" title="voltar" width="20px" height="20px">Voltar</a>
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
						<th>Telefone</th>
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
							<td data-title="Telefone"><c:out value="${usuario.telefone }"></c:out></td>
							<td class="select" ><a class="button-editar"
								href="CadastrarUsuario?acao=editar&id=${usuario.id}"><img src="resources/img/editar.png" width="30px" height="30px" alt="Editar" title="Editar"></a></td>
							<td class="select" ><a class="button-excluir"
								href="CadastrarUsuario?acao=delete&id=${usuario.id}"><img src="resources/img/excluir.png" width="30px" height="30px" alt="Excluir" title="Excluir"></a></td>
						</tr>

					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
	
	<script>
		function exibirSenha(){
			var senha = document.getElementById("senha");
			
			if(senha.type === "password"){
				senha.type = "text";
			}else{
				senha.type = "password"
			}
			
		}
		
		function  validarCampos(){
			if(document.getElementById("login").value === ""){
				alert("Login deve ser informado");
				return false;
			}else if(document.getElementById("nome").value === ""){
				alert("O nome deve ser informado");
				return false;
			}else if(document.getElementById("telefone").value === ""){
				alert("O telefone deve ser informado");
				return false;
			}else if(document.getElementById("senha").value === ""){
				alert("A senha deve ser informada");
				return false
			}else{
				return true;
			}
		}
	</script>
</body>
</html>