<%@page import="controller.UsuarioOrientadorController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="controller" class="controller.UsuarioOrientadorController"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard - Aluno</title>
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
                <a class="nav-link" href="RecuperarSenhaUsuario.jsp">Trocar Senha</a>
                <a class="nav-link" href="CadastrarUsuario?action=sair">Sair</a>
            </nav>
        </div>
    </div>

    <main role="main" class="container dashboard-main">

        <c:if test="${controller.obterOrientador(sessionScope.usuarioLogado.codigo) == null}">
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Convidar Orientador</h6>
                <div class="media text-muted pt-3">
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        Você ainda não possui orientador...
                        <a href="GridProfessores.jsp">convide um professor!</a>
                    </p>
                </div>
            </div>
        </c:if>

        <c:if test="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo) == null}">
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Orientador</h6>
                <div class="media text-muted pt-3">
                   <table class="table">
                        <thead>
                            <th>Professor</th>
                            <th>Email</th>
                            <th>Prontuário</th>
                        </thead>
                        <tbody>
                            <tr>
                                <td>${controller.obterOrientador(sessionScope.usuarioLogado.codigo).nome}</td>
                                <td>${controller.obterOrientador(sessionScope.usuarioLogado.codigo).email}</td>
                                <td>${controller.obterOrientador(sessionScope.usuarioLogado.codigo).prontuario}</td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </c:if>

        <c:if test="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo) != null}">
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Convites Enviados</h6>
                <div class="media text-muted pt-3">
                    
                    <c:if test="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo).size() == 0}">
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            Nenhum convite enviado até o momento.
                        </p>
                    </c:if>

                    <c:if test="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo).size() != 0}">
                        <table class="table">
                            <thead>
                                <th>Professor</th>
                                <th>Email</th>
                                <th>Ação</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo)}" var="p">
                                    <tr>
                                        <td>${p.orientador.nome}</td>
                                        <td>${p.orientador.email}</td>
                                        <td><a href="Orientacao?action=cancelar&convidadoId=${p.orientador.codigo}">Cancelar</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </c:if>

        <c:if test="${controller.obterOrientador(sessionScope.usuarioLogado.codigo) == null}">
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Convites Recebidos</h6>
                <div class="media text-muted pt-3">
                    <c:if test="${controller.convitesRecebidosByAluno(sessionScope.usuarioLogado.codigo).size() == 0}">
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            Você ainda não possui orientador...
                            <a href="GridProfessores.jsp">convide um professor!</a>
                        </p>
                    </c:if>

                    <c:if test="${controller.convitesRecebidosByAluno(sessionScope.usuarioLogado.codigo).size() != 0}">
                        <table class="table">
                            <thead>
                                <th>Professor</th>
                                <th>Email</th>
                                <th>Ação</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${controller.convitesRecebidosByAluno(sessionScope.usuarioLogado.codigo)}" var="p">
                                    <tr>
                                        <td>${p.orientador.nome}</td>
                                        <td>${p.orientador.email}</td>
                                        <td><a href="Orientacao?action=aceitar&convidadoId=${p.orientador.codigo}">Aceitar</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </c:if>

        <c:if test="${controller.obterOrientador(sessionScope.usuarioLogado.codigo) != null}">
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Projeto</h6>
                <div class="media text-muted pt-3">
                    <c:if test="${controller.obterOrientador(sessionScope.usuarioLogado.codigo) == null}">
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            Você ainda não elaborou seu projeto...
                            <a href="selecaoorientador.html">Enviar proposta de projeto!</a>
                        </p>
                    </c:if>
                </div>
            </div>
        </c:if>
        
    </main>
</body>

</html>