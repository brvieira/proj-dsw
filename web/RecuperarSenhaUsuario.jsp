<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
  <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
  <title>Mudar senha</title>

  <link rel="stylesheet" href="estilo.css" type="text/css">
</head>

<body>
  <h1 style="text-align: center;">Mudar Senha</h1><br>

  <form action="CadastrarUsuario?action=mudarsenha" method="post" name="cadastro">
    <input type="hidden" name="codigo" value="${sessionScope.usuarioLogado.codigo}" />
    
    Senha Atual: <input maxlength="12" size="12" name="senhaAnterior" type="password"><br>
    <br>
    Nova Senha: <input maxlength="12" size="12" name="senha" type="password"><br>
    <br>
    Nova Senha (repetir): <input maxlength="12" size="12" name="senhaRepetir" type="password"><br>
    <br>
    <input name="Enviar" type="submit"><br>
  </form>

</body>

</html>