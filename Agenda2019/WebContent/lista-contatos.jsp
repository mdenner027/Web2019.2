<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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
	<jsp:useBean id="dao" class="br.com.agenda.bd.ContatoDAO" />
	<h1>Lista de Contatos</h1>
	<table border="1">
		<thead>
			<tr>
				<th>Código</th>
				<th>Nome</th>
				<th>Email</th>
				<th>Endereço</th>
				<th>Data de Nascimento</th>
				<th>Alterar</th>
				<th>Excluir</th>
			</tr>
		</thead>
		<c:forEach var="contato" items="${dao.listaContatos}">
			<tr>
				<td align="center">${contato.id}</td>
				<td align="center">${contato.nome}</td>
				<td align="center">${contato.email}</td>
				<td align="center">${contato.endereco}</td>
				<td align="center"><fmt:formatDate
						value="${contato.dataNascimento.time}" pattern="dd/MM/yyyy" /></td>
				<td align="center"><a
					href="alterar-contato.jsp?id=${contato.id}">Alterar</a></td>
				<td align="center"><a href="excluirContato?id=${contato.id}">Excluir</a></td>

			</tr>
		</c:forEach>
	</table>
	<footer>
		<c:import url="rodape.html"></c:import>
	</footer>
</body>
</html>