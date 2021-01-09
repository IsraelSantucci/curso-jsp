<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
		<h1>Bem vindo ao curso de JSP</h1>
		
		<%="o seu sucesso garantido agora" 
			//out.println("o seu sucesso garantido"); 
		%>
		
		<form action="receber-nome.jsp" method="get">
			<input type="text" id="nome" name="nome" />
			<input type="submit" value="Enviar" />
		</form>
		
		<%
			session.setAttribute("curso", "curso de JSP");
		%>
		</br>
		<h4><a href="redireciona.jsp">pagina que testar redirecionamento</a></h4>
		<h4><a href="testa-include.jsp">pagina para usar include jsp</a></h4>
		<h4><a href="usa-bean.jsp">pagina para usar a classe BeanCursoJsp</a></h4>
		<h4><a href="testando-cadastro-aluno.jsp">Cadastro aluno</a></h4>
		<h4><a href="testando-session-scope.jsp">Testando a passagem de parametro com Session</a></h4>
		<h4><a href="login-servlet.jsp">Fazendo o login passando pela servlet</a></h4>
</body>
</html>