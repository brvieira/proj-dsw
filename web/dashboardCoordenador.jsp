<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="controller.UsuarioController"/>     
<jsp:useBean id="controller" class="controller.UsuarioOrientadorController"/>
<jsp:useBean id="prjController" class="controller.ProjetoController"/>
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
                    <c:if test="${prjController.obterProjetosPendentesColegiado().size() == 0}">
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        Não existem projetos enviados ao colegiado.
                    </p>
                    </c:if>
                    
                    <c:if test="${prjController.obterProjetosPendentesColegiado().size() != 0}">
                        <table class="table">
                            <thead>
                                <th>Aluno</th>
                                <th>Título</th>
                                <th>Projeto em análise pelo Colegiado ?</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${prjController.obterProjetosPendentesColegiado()}" var="p">
                                    <tr>
                                        <td>${p.aluno.nome}</td>
                                        <td>${p.nome}</td>
                                        <td>
                                            <c:if test="${p.projetoRecebidoAnalise != true}">
                                                ${p.projetoRecebidoAnalise} - <a href="Projeto?action=confirmarRecebimento&codigo=${p.codigo}">Confirmar Recebimento</a>
                                            </c:if>
                                            <c:if test="${p.projetoRecebidoAnalise == true}">
                                                ${p.projetoRecebidoAnalise}
                                            </c:if>
                                            
                                        </td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>

            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Alunos</h6>
                <div class="media text-muted pt-3">
                    <c:if test="${usuarios.obterAlunos().size() == 0}">
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            Não existem alunos cadastrados.
                        </p>
                </c:if>
                <c:if test="${usuarios.obterAlunos().size() != 0}">
                    <table class="table">
                        <thead>
                            <tr>
                                <th>Nome</th>
                                <th>CPF</th>
                                <th>Prontuário</th>
                                <th>Email</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${usuarios.obterAlunos()}" var="u">
                                <tr>
                                    <td>${u.nome}</td>
                                    <td>${u.cpf}</td>
                                    <td>${u.prontuario}</td>
                                    <td>${u.email}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
                </div>
            </div>

            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Alunos e Orientadores</h6>
                <div class="media text-muted pt-3">
                    <c:if test="${controller.obterAlunosOrientados().size() == 0}">
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            Não existem orientações.
                        </p>
                    </c:if>
                    <c:if test="${controller.obterAlunosOrientados().size() != 0}">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Nome Aluno</th>
                                    <th>Prontuário Aluno</th>
                                    <th>Email Aluno</th>
                                    <th>X</th>
                                    <th>Nome Orientador</th>
                                    <th>Prontuário Orientador</th>
                                    <th>Email Orientador</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${controller.obterAlunosOrientados()}" var="u">
                                    <tr>
                                        <td>${u.aluno.nome}</td>
                                        <td>${u.aluno.prontuario}</td>
                                        <td>${u.aluno.email}</td>
                                        <td></td>
                                        <td>${u.orientador.nome}</td>
                                        <td>${u.orientador.prontuario}</td>
                                        <td>${u.orientador.email}</td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>    
                    </c:if>
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