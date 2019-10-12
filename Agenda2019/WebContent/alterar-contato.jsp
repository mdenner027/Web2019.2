<%@page import="br.com.agenda.bd.ContatoDAO"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="br.com.agenda.modelo.Contato"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Alterar Contato</title>
</head>
<body>
	<header>
		<c:import url="cabecalho.html"></c:import>
	</header>
	<h1>Alterar Contato</h1>
	<%
		Contato c = new Contato();
		//c.setId(Long.parseLong(request.getParameter("id")));
		SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
		ContatoDAO d = new ContatoDAO();
		c = d.getContatoById(request.getParameter("id"));
	%>

	<h1>Atualizar Contato</h1>
	<hr />
	<form action="atualizaContato">
		<label for="id"> Id: <input type="text" name="id" required
			value="<%=c.getId()%>" /><br />
		</label> <label for="nome"> Nome: <input type="text" name="nome"
			required value="<%=c.getNome()%>" /><br />
		</label> <label for="emai"> E-mail: <input type="text" name="email"
			value="<%=c.getEmail()%>" /><br />
		</label> <label for="endereco"> Endereço: <input type="text"
			name="endereco" value="<%=c.getEndereco()%>" /><br />
		</label> <label for="dataNascimento"> Data Nascimento: <input
			type="text" name="dataNascimento"
			value="<%=formatador.format(c.getDataNascimento().getTime())%>" /><br />
		</label> <input type="submit" value="Atualizar" />
	</form>
	<footer>
		<c:import url="rodape.html"></c:import>
	</footer>
</body>
</html>