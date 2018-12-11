<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html><head>
  
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
  <title>Enviar Projeto ao Colegiado</title>

  
  
  <link rel="stylesheet" href="estilo.css" type="text/css">

</head><body>
    <h1 style="text-align: center;">Enviar Projeto ao Colegiado<br>
</h1>

<form action="Projeto?action=criarProjeto" method="post" name="cadastro"><small>*Todos
os campos são obrigatórios</small><br>
  <br>
Prontuário: <input disabled="disabled" maxlength="10" size="10" name="prontuario" value="${sessionScope.usuarioLogado.prontuario}"><br>
  <br>
Nome do aluno: <input disabled="disabled" maxlength="50" size="50" name="nome" value="${sessionScope.usuarioLogado.nome}"><br>
  <br>
Semestre atual: <input maxlength="2" size="2" name="semestre" type="number"><br>
  <br>
Título do projeto: <input maxlength="100" size="70" name="titulo"><br>
  <br>
Arquivo: <input accept="*.pdf" name="arquivo" type="file"> <br>
  <br>
  <input name="Enviar" value="Enviar" type="submit"> <input value="Cancelar" name="Cancelar" type="button"></form>

</body></html>