<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cadastro de empresa</title>
</head>
<body>
	<c:url value="/entrada?acao=Login" var="formLogin" />
	<form action="${ formLogin }" method="post">
		Login: <input type="text" name="login">&nbsp;&nbsp;&nbsp;
		Senha: <input type="password" name="senha" >&nbsp;&nbsp;&nbsp;
		<input type="submit" value="Entrar">
	</form>
</body>
</html>