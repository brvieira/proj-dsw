<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard - Coordenador</title>
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="./css/dashboard.css" />
    </head>
    <body class="bg-light">

    <div class="fixed-top">
        <nav class="navbar navbar-expand-lg navbar-dark bg-green">
            <a class="navbar-brand mr-auto mr-lg-0" href="#">TCCando IFSP</a>
        </nav>

        <div class="nav-scroller bg-white shadow-sm">
            <nav class="nav nav-underline">
                <a class="nav-link" href="AtualizarUsuario.jsp">Alterar Dados</a>
                <a class="nav-link" href="AlterarCoordenador.jsp">Alterar Coordenador</a>
                <a class="nav-link" href="RecuperarSenhaUsuario.jsp">Trocar Senha</a>
                <a class="nav-link" href="CadastrarUsuario?action=sair">Sair</a>
            </nav>
        </div>
    </div>

    <main role="main" class="container dashboard-main">

        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Requisições</h6>
            <div class="media text-muted pt-3">
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    Não existem requisições pendentes.
                </p>
            </div>
        </div>

        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Projetos</h6>
            <div class="media text-muted pt-3">
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    Não existem projetos sob sua orientação.
                </p>
            </div>
        </div>

        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Seus Orientandos</h6>
            <div class="media text-muted pt-3">
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    Você ainda não possui orientandos... convide um aluno!
                </p>
            </div>
        </div>

        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Alunos</h6>
            <div class="media text-muted pt-3">
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    <a href="GridAlunos.jsp">Visualizar Todos Alunos</a>
                </p>
            </div>
        </div>

        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Alunos e Orientadores</h6>
            <div class="media text-muted pt-3">
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    Alunos com orientação:
                </p>
            </div>

            <div class="media text-muted pt-3">
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    Alunos sem orientação:
                </p>
            </div>

            <div class="media text-muted pt-3">
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    Relação orientador e orientandos:
                    <a href="GridAlunosOrientados.jsp">Orientados x Orientandos</a>
                </p>
            </div>
        </div>

        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Eventos</h6>
            <div class="media text-muted pt-3">
                <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                    Não existem BANANAS marcadas.
                </p>
            </div>
        </div>
        </main>
    </body>
</html>