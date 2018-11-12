<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilo.css" type="text/css">
        <title>Dashboard do Aluno</title>
    </head>
    <body>
        <div class="caixa">
            <h3>Requisições</h3>
            <br>
            Não existem requisições pendentes.
            <br>
        </div>

        <div class="caixa">
            <h3> Projeto</h3>
            <br>
            Você ainda não elaborou seu projeto... mas precisa <a href="selecaoorientador.html">encontrar um orientador</a> antes!
            <br>
        </div>

        <div class="caixa">
            <h3>Seu orientador</h3>
            Você ainda não possui orientador... <a href="selecaoorientador.html">convide um
                professor</a>!<br>
            <br>
        </div>
        <div class="caixa">
            <a href="AtualizarUsuario.jsp"><button>Alterar Dados</button></a>
            <a href="RecuperarSenhaUsuario.jsp"><button>Trocar Senha</button></a>
            <a href="CadastrarUsuario?action=sair"><button>Sair</button></a>
        </div>
    </body>
</html>
