<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
  
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
  <title>Agendar Exame de Defesa</title>
  <link rel="stylesheet" href="estilo.css" type="text/css">

</head><body>
    <h1 style="text-align: center;">Agendar Exame de Defesa<br>
</h1>

<form action="Defesa?action=agendarDefesa" method="post" name="cadastro"><small>*Tod</small><small>os
os campos são obrigatórios</small><br>
<input type="hidden" maxlength="50" size="50" name="codigo" value="<%= request.getParameter("codigo") %>"><br>
  <br>
Data: <input maxlength="10" size="10" name="data"> (dd/mm/aaaa)<br>
  <br>
Horário: <input maxlength="5" size="5" name="horario"> (hh:mm)<br>
  <br>
Banca:<br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Membro avaliador 1: <input maxlength="50" size="50" name="nomeavaliador1"><br>
  <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; Membro avaliador 2: <input maxlength="50" size="50" name="nomeavaliador2"><br>
  <br>
  <input name="Enviar" value="Agendar" type="submit"> <input value="Cancelar" name="Cancelar" type="button"></form>

</body></html