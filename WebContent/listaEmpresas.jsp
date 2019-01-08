<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List, br.com.alura.gerenciador.modelo.Empresa" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Empresas</title>
</head>
<body>
	<b>Lista de Empresas:</b><br><br>
	<%
		List<Empresa> empresas = (List<Empresa>)request.getAttribute("empresas");
		
		for(Empresa empresa : empresas){
	%>
	
	<li><%= empresa.getNome() %></li>
	
	
	<%		
		}
	%>
</body>
</html>