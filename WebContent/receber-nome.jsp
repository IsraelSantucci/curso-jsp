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
	</br></br></br>
	<%! int cont = 27; 
		
		public int soma(int a, int b){
			return a+b;
		}
	%>
	<%= cont %>
	<%=soma(5,9) %>
	
	<%
		out.println(" </br>");
		out.println("get caracterer enconding: "+request.getCharacterEncoding());
		out.println("</br> path: "+request.getContextPath()+" </br> session: "+request.getSession());
		out.println("</br> País: "+application.getInitParameter("pais"));
		out.println("</br> path: "+ application.getContextPath());
		out.println("</br> curso: " + session.getAttribute("curso"));
	%>
</body>
</html>