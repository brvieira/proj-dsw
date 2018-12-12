<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
  
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
  <title>Informar Parecer do Colegiado</title>
  
  <link rel="stylesheet" href="estilo.css" type="text/css">

</head><body>
<h1 style="text-align: center;">Parecer de Projeto</h1>
Nome do aluno: <input disabled="disabled" maxlength="50" size="50" name="nome" value="${sessionScope.usuarioLogado.nome}"><br>
<form method="post" action="Projeto?action=informarParecer" name="parecer">
<input type="hidden" maxlength="50" size="50" name="codigo" value="<%= request.getParameter("codigo") %>"><br>
<br>
Parecer do Colegiado:<br>
  <br>
Parecer:<br>
  <textarea cols="100" rows="5" maxlength="1000" size="1000" name="textoParecer" value=""></textarea> <br>
  <br>
  <input name="Enviar" value="Enviar" type="submit">
<input name="Cancelar" value="Cancelar" type="button">
</form>

</body></html>