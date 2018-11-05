<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
    <title>Atualizar cadastro</title>

    <link rel="stylesheet" href="estilo.css" type="text/css">
</head>

<body>
  <h1 style="text-align: center;">Atualizar Cadastro<br></h1>
  <jsp:useBean id="Usuario" class="model.Usuario" scope="request" />
  <form action="/CadastrarUsuario?action=atualizar" method="post" name="cadastro">
    <input type="hidden" name="codigo" value="<jsp:getProperty name="Usuario" property="codigo" />" />
    
    <small>*Todos os campos são obrigatórios</small><br>
    <br>
    Nome: <input maxlength="50" size="50" name="nome" value="<jsp:getProperty name="Usuario" property="nome"/>"/><br>
    <br>
    CPF: <input maxlength="14" name="cpf" value="<jsp:getProperty name="Usuario" property="cpf"/>"> (xxx.xxx.xxx-xx)<br>
    <br>
    E-mail: <input maxlength="50" size="50" name="email" value="<jsp:getProperty name="Usuario" property="email"/>"><br>
    <br>
    Prontuário no IFSP: <input maxlength="10" size="10" name="prontuario" value="<jsp:getProperty name="Usuario" property="prontuario"/>"><br>
    <br>
    Foto: <input accept="*.jpg; *.jpeg; *.png; *.gif; *.bmp" name="foto" type="file"> <br>
    <br>
    <input name="Enviar" type="submit"><br>
  </form>

</body>

</html>