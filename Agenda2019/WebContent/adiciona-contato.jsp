<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<header>
		<c:import url="cabecalho.html"></c:import>
	</header>
	<h1>Adicionar Contato</h1>
	<hr>
	<form method="get" action="adicionarContato">
		<label>
			Nome: <input type="text" name="nome">
		</label>
		<br>
		<label>
			Email: <input type="email" name="email">
		</label>
		<br>
		<label>
			Endereço: <input type="text" name="endereco">
		</label>
		<br>
		<label>
			Data de Nascimento: <input type="date" max="2018-01-01" name="dataNascimento">
		</label>
		<br>
		<a href="index.html"><input type="button" value="Voltar"></a>
		<input type="submit" value="Adicionar">		
	</form>
	<footer>
		<c:import url="rodape.html"></c:import>
	</footer>
</body>
</html>