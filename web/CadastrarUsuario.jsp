<%-- 
    Document   : CadastrarUsuario
    Created on : 04/11/2018, 11:05:35
    Author     : gu_ri
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
  <title>Cadastro de novo usuário</title>

  <link rel="stylesheet" href="estilo.css" type="text/css">
</head>

<body>
  <h1 style="text-align: center;">Cadastrar Usuário</h1>

  <form action="CadastrarUsuario?action=cadastrar" method="post" name="cadastro">
    Crie sua conta preenchendo o formulário:<br>
    <small>*Todos os campos são obrigatórios</small><br>
    <br>
    Nome: <input maxlength="50" size="50" name="nome"><br>
    <br>
    CPF: <input maxlength="14" name="cpf"> (xxx.xxx.xxx-xx)<br>
    <br>
    e-mail: <input maxlength="50" size="50" name="email"><br>
    <br>
    Prontuário no IFSP: <input maxlength="10" size="10" name="prontuario"><br>
    <br>    
    Você é: <input name="tipoUsuario" value="aluno" type="radio">Aluno&nbsp;&nbsp;&nbsp;
    <input name="tipoUsuario" value="professor" type="radio">Professor<br>
    <br>
    Senha: <input maxlength="12" size="12" name="senha" type="password"><br>
    <br>
    Senha (repetir): <input maxlength="12" size="12" name="senhaRepetir" type="password"><br>
    <br>
    <input name="Enviar" type="submit"><br>
  </form>

</body>

</html>