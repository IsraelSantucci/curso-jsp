<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<c:out value="bem vindo ao jstl" />
	<br />
	<c:out value="${'testando a tag out do jstl'}"></c:out>
	<br />
	<c:set var="soma" scope="page" value="${20+50 }" />

	Soma:
	<c:out value="${soma}" />
	<c:remove var="soma" />
	<br />

	<c:catch var="erro">
		<%
			int soma = 100 / 0;
		%>
	</c:catch>

	<c:if test="${erro!= null }">
	${erro.message}
</c:if>
	<br />
	<br />
	<br />

	<p>testando condição</p>

	<form action""> 
		idade:<input type="text" name="valor" /> <input
		type="submit" value="enviar" />
	</form>
	
	<c:set var="valor" value="${param.valor }"></c:set>
	idade:${valor }
	<br/>
	<c:if test="${param.valor != null }">
		<c:choose>
			<c:when test="${param.valor<18 && param.valor >12}">
				<c:out value="${'Você é adolecente'}"></c:out>
			</c:when>
			<c:when test="${param.valor > 18 }">
				<c:out value="${'Você é adulto'}" />
			</c:when>

			<c:otherwise>
				<c:out value="${'voce ainda é uma criança' }" />
			</c:otherwise>
		</c:choose>
	
	</c:if> 
	<br/>
	<br/><br/>
	Delimetador de tokens
	
	<c:forTokens items="ANA-FLAVIA-MARIA-ROSAGELA-PEDRO" delims="-" var="nome">
		nome:${nome} <br/>
	</c:forTokens>
	<br/><br/>
	montado url
	<c:url var="receber" value="/receber-nome.jsp">
		<c:param name="nome" value="Israel"></c:param>
		<c:param name="nome2" value="Santucci"></c:param>
	</c:url>
	${receber}
	<br/><br/>
	Ir pra onde
	<form action"">
		<input type="radio" name="site" value="google"/> google
		<input type="radio" name="site" value="youtube"/> youTube	
		<br> <input type="submit" value="ir" />
	</form>
	<c:if test="${param.site != null}">
	    
		p:${param.site }
		<c:choose>
			<c:when test="${param.site == 'google'}">
				${param.site }
				<c:redirect url="http://www.google.com"></c:redirect>
			</c:when>
			<c:when test="${param.site == 'youtube' }">
				<c:redirect url="http://www.youtube.com"></c:redirect>
			</c:when>
		</c:choose>
	</c:if>
	
	<br/><br/>
	<p>testando forEach</p>
	<c:forEach var="n" begin="0" step="2" end="10">
		item: ${n}
		<br/>
	</c:forEach>
		
	<br />
	<br />
	============================================================ <br />
	<br />
	<br />
	<c:import var="site" url="https://www.google.com"></c:import> <c:out
		value="${site}"></c:out>
</body>
</html>