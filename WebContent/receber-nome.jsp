<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<% 
		String nome = "nome recebido: " + request.getParameter("nome");
		out.print(nome); 
	%>
	</br>
	<%! int cont = 27; 
		
		public int soma(int a, int b){
			return a+b;
		}
	%>
	<%= cont %>
	<%=soma(5,9) %>
</body>
</html>