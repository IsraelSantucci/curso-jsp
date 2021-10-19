<%@page import="beans.Aluno"%>
<jsp:useBean id="aluno" class="beans.Aluno" type="beans.Aluno" scope="request"></jsp:useBean>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:setProperty property="*" name="aluno"/>
	
	<h1>Dados aluno</h1>
	
	<h3>nome:<jsp:getProperty property="nome" name="aluno"/></h3>
	<h3>idade:<jsp:getProperty property="idade" name="aluno"/></h3>
	<h3>cpf:<jsp:getProperty property="cpf" name="aluno"/></h3>
	
</body>
</html>