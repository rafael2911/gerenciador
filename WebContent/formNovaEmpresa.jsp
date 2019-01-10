<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de empresa</title>
</head>
<body>
	<c:url value="/novaEmpresa" var="formNovaEmpresa" />
	<form action="${ formNovaEmpresa }" method="post">
		<input type="hidden" value="${ empresa.id }" name="id">
		Nome: <input type="text" name="nome" value="${ empresa.nome }">&nbsp;&nbsp;&nbsp;
		<fmt:formatDate value="${empresa.dataAbertura }" pattern="dd/MM/yyyy" var="data" />
		Data: <input type="text" name="data" value="${ data }">&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Salvar">
	</form>
</body>
</html>