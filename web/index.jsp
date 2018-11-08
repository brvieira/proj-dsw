<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TCCando IFSP</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="./css/home.css" />
        <script src="./js/bootstrap.min.js"></script>
    </head>    
    <body>
    <div class="row d-flex h-100 w-100">
        <div class="col-md-5 justify-content-end d-flex align-items-center logo-container">
            <img class="logo-ifsp" src="./images/logo_ifsp.png">
        </div>
        <div class="col-md-7 d-flex align-items-center">
            <form class="form-signin" action="CadastrarUsuario?action=autenticar" method="post">
                <h1 class="h3 mb-3 font-weight-normal text-center">TCCando IFSP</h1>
                <input name="prontuario" id="inputEmail" class="form-control" placeholder="Prontuário" required autofocus>
                <input name="senha" type="password" id="inputPassword" class="form-control" placeholder="Senha" required>
                <button class="btn btn-lg btn-primary btn-block" type="submit">Entrar</button>
                <div class="text-center">
                    <a href="CadastrarUsuario.jsp">Ainda não tem cadastro? Clique aqui</a>
                </div>
            </form>
        </div>
    </div>
    </body>
</html>
