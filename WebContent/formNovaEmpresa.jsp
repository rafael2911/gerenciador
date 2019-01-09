<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de empresa</title>
</head>
<body>
	<c:url value="/novaEmpresa" var="formNovaEmpresa" />
	<form action="${ formNovaEmpresa }" method="post">
		Nome: <input type="text" name="nome"><br><br>
		<input type="submit" value="Salvar">
	</form>
</body>
</html>