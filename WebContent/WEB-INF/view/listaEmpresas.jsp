<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>
	<c:import url="logout.jsp"></c:import>
	Login: ${usuarioLogado.login}
	<br>
	<br>
	<br>

	<c:if test="${ not empty empresa }">
		Empresa ${ empresa } cadastrada com sucesso!
	</c:if>
	<br><br>
	
	<c:url value="/entrada?acao=FormNovaEmpresa" var="nova"></c:url>
	<a href="${nova }">Nova empresa</a>
	
	<br><br>
	<b>Lista de Empresas:</b><br>
	
	<ul>
	<c:forEach items="${ empresas }" var="empresa">
		<li>
			${empresa.id } : ${ empresa.nome } - <fmt:formatDate value="${ empresa.dataAbertura }" pattern="dd/MM/yyyy" />
			<c:url value="/entrada?acao=DetalheEmpresa&id=${ empresa.id }" var="edit" />
			<c:url value="/entrada?acao=RemoveEmpresa&id=${ empresa.id }" var="remov" />
			<a href="${ edit }">Editar</a>
			<a href="${ remov }">Remover</a>	
		</li>
	</c:forEach>
	</ul>
	
</body>
</html>