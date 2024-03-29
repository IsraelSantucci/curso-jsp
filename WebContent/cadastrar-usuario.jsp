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

	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
            integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
            crossorigin="anonymous"></script>

  

</head>
<body>

	<h3>usuario: ${usuarioLogado.nome}</h3>
	<div class="form-style-6">
		<h1>Cadastrar Usuarios</h1>
		
		<h3 id="msg-login-repetido">${msg}</h3>
		<form id="formCadastro" action="CadastrarUsuario" method="post" autocomplete="off" onsubmit="return validarCampos()">
		
			<label for="id">Id: </label> 
			<input type="text" name="id" readonly="readonly" value="${usuario.id }" /> 
			
			<label for="login">Login:</label>	
			<input type="text"  id="login" name="login" value="${usuario.login }" />
			
			<label for="nome">Nome:</label> 
			<input type="text" id="nome" name="nome" value="${usuario.nome }">
			
			<label for="telefone">Telefone:</label>
			<input type="text" id="telefone" name="telefone" value="${usuario.telefone }">
			
			<label>Cep:</label>
			<input type="text" id="cep" name="cep" onblur="consultarCep()" value="${usuario.cep }">
			
			<label>Rua:</label>
			<input type="text" id="rua" name="rua" value="${usuario.rua }">
			
			<label>Bairro:</label>
			<input type="text" id="bairro" name="bairro" value="${usuario.bairro }">
			
			<label>Cidade:</label>
			<input type="text" id="cidade" name="cidade" value="${usuario.cidade }">

			<label>Estado:</label>
			<input type="text" id="estado" name="estado" value="${usuario.estado }">	
				
			<label for="senha"> Senha:</label> 
			<input id="senha" type="password" name="senha" value="${usuario.senha }"  /> 
			<input type="checkbox" onclick="exibirSenha()">
					
			<input type="submit" value="Cadastrar"> 
			<input type="submit" value="Cancelar" onclick="document.getElementById('formCadastro').action='CadastrarUsuario?acao=reset'">
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
						<th>Cep</th>
						<th>Rua</th>
						<th>Bairro</th>
						<th>Cidade</th>
						<th>Estado</th>
						<th></th>
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
							<td data-title="Cpf"><c:out value="${usuario.cep }"></c:out></td>
							<td data-title="Rua"><c:out value="${usuario.rua }"></c:out></td>
							<td data-title="Bairro"><c:out value="${usuario.bairro }"></c:out></td>
							<td data-title="Cidade"><c:out value="${usuario.cidade }"></c:out></td>
							<td data-title="Estado"><c:out value="${usuario.estado }"></c:out></td>
							<td class="select" ><a class="button-editar"
								href="CadastrarUsuario?acao=editar&id=${usuario.id}"><img src="resources/img/editar.png" width="20px" height="20px" alt="Editar" title="Editar"></a></td>
							<td class="select" ><a class="button-excluir"
								href="CadastrarUsuario?acao=delete&id=${usuario.id}"><img src="resources/img/excluir.png" width="20px" height="20px" alt="Excluir" title="Excluir"></a></td>
							<td><a href="cadastrarTelefones"><img  src="resources/img/telefone.png" title="telefones" width="20px" height="20px"></a></td>
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
		
		function consultarCep(){
			var cep = $("#cep").val();
			$.getJSON("https://viacep.com.br/ws/"+ cep +"/json/?callback=?", function(dados) {

                if (!("erro" in dados)) {
               
                    $("#rua").val(dados.logradouro);
                    $("#bairro").val(dados.bairro);
                    $("#cidade").val(dados.localidade);
                    $("#estado").val(dados.uf);
                    
                }else {     
                    alert("CEP n�o encontrado.");
                }
            });
			
		}
	</script>
</body>
</html>