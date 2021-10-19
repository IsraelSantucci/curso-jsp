<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<link  rel="stylesheet" href="resources/css/estilo.css" />
</head>
<body>
	<div class="login-page">
		<div class="form">
			<form class="login-form"  action="LoginServlet" method="post">
				<input type="text" name="usuario" placeholder="usuario" /> <br><input
					type="password" name="senha" placeholder="senha"/> <br> 
					<input id="botao" type="submit"
					value="logar" />
			</form>
		</div>
	</div>
</body>
</html>