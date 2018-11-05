<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TICICI IFSP</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="./css/home.css" />
        <script src="./js/bootstrap.min.js"></script>
    </head>    
    <body>
        <div class="mx-5" style="width: 20%" class="it">
            <img class="mb-4" src="./images/logo_ifsp.png" style="box-shadow: 2px 2px 2px #cdcdcd; border-radius: 50px">
            <p>
                <a href="CadastrarUsuario.jsp">Cadastrar Usuário</a>
            </p>
            <p>
                <a href="GridUsuarios.jsp">Visualizar Usuários</a>
            </p> 
        </div>
        <form class="form-signin">
            <h1 class="h3 mb-3 font-weight-normal text-center">TICICI IFSP</h1>
            <input type="email" id="inputEmail" class="form-control" placeholder="Prontuário" required autofocus>
            <input type="password" id="inputPassword" class="form-control" placeholder="Senha" required>
            <button class="btn btn-lg btn-primary btn-block" style="background: #4caf50" type="submit">Entrar</button>
            <div class="text-center">
                <a href="#">Ainda não tem cadastro? Clique aqui</a>
            </div>
        </form>
    </body>
</html>
