<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nova Empresa Criada!!!</title>
</head>
<body>

	<% 
		String nomeEmpresa = (String) request.getAttribute("empresa");
		System.out.println(nomeEmpresa);
	%>
	
	
<%-- 	<% out.println(nomeEmpresa); %> --%>
	Empresa <%= nomeEmpresa %> cadastrada com sucesso!

</body>
</html>