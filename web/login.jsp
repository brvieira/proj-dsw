<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Seja bem-vindo!</h1>
        <form action="CadastrarUsuario?action=autenticar" method="post">
            <p>Prontuário:<input type="text" name="prontuario"/>
            <p>Senha:<input type="password" name="senha"/>
            <p><input type="submit" />
        </form>
    </body>
</html>
