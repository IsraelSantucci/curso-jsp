<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	
	<style type="text/css">
		div{
			width: 200px;
			height:200px;
			position: absolute;
			top:50%;
			left: 50%;
			
			margin-left:-100px;
			margin-top: -100px;
			
		}
		
		#logar{
			background-color: grey;
				margin: auto;
				text-align: center;
				border-radius: 10px;
				box-shadow: 1px 1px 1px black;
		}
	
	</style>
</head>
<body>
	<div>
		<form id="logar" action="LoginServlet" method="post">
			<h2>Login</h2>
			Nome<input type="text" name="usuario" /> </br>
			Senha<input type="text" name="senha" /> </br>
			<input type="submit" value="Logar" />
		</form>
	</div>
</body>
</html>