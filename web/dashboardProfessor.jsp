<%@page import="controller.UsuarioOrientadorController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="controller" class="controller.UsuarioOrientadorController"/>
<jsp:useBean id="prjController" class="controller.ProjetoController"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dashboard - Orientador</title>
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
        
        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Projetos</h6>
            <div class="media text-muted pt-3">
                
                <c:if test="${controller.obterOrientandosByProfessor(sessionScope.usuarioLogado.codigo).size() == 0}">
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        Você ainda não possui orientandos... convide um aluno!
                    </p>
                </c:if>
                    
                    
                <c:if test="${controller.obterOrientandosByProfessor(sessionScope.usuarioLogado.codigo).size() != 0}">
                    <c:forEach items="${controller.obterOrientandosByProfessor(sessionScope.usuarioLogado.codigo)}" var="p">                    
                        <c:if test="${prjController.obterProjetosByUsuarioID(p.aluno.codigo).size() == 0}">
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            Não existem projetos enviados pelo ${p.aluno.nome} ainda.
                        </p>
                        </c:if>
                        
                        <c:if test="${prjController.obterProjetosByUsuarioID(p.aluno.codigo).size() != 0}">
                            <table class="table">
                                <thead>
                                    <th>Orientando</th>
                                    <th>Titulo</th>
                                    <th>Enviado ao Colegiado ?</th>
                                    <th>Aprovado pelo Orientador ?</th>
                                    <th>Em Análise pelo Coordenador ?</th>
                                    <th>Parecer Projeto</th>
                                    <th>Agendar Defesa</th>
                                    <th>Versão Final</th>
                                </thead>
                                <tbody>
                                <c:forEach items="${prjController.obterProjetosByUsuarioID(p.aluno.codigo)}" var="a">
                                    <tr>
                                        <td>${p.aluno.nome}</td>
                                        <td>${a.nome}</td>
                                        <td>
                                            <c:if test="${a.projetoEnviadoColegiado == true}">
                                                ${a.projetoEnviadoColegiado} - <a href="Projeto?action=cancelarEnvio&codigo=${a.codigo}">Cancelar Envio</a>
                                            </c:if>
                                            <c:if test="${a.projetoEnviadoColegiado != true}">
                                                ${a.projetoEnviadoColegiado}
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${a.projetoEnviadoColegiadoConcordado != true}">
                                                ${a.projetoEnviadoColegiadoConcordado} - <a href="Projeto?action=aprovarEnvio&codigo=${a.codigo}">Aprovar Projeto</a>
                                            </c:if>
                                            <c:if test="${a.projetoEnviadoColegiadoConcordado == true}">
                                                ${a.projetoEnviadoColegiadoConcordado}
                                            </c:if>
                                        </td>
                                        <td>${a.projetoRecebidoAnalise}</td>
                                        <td>
                                            <c:if test="${a.parecerProjeto == null}">
                                                Não Disponível
                                            </c:if>
                                            <c:if test="${a.parecerProjeto != null}">
                                                <a href="VisualizarParecer.jsp?codigo=${a.codigo}">Visualizar Parecer</a>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${a.parecerProjeto == null}">
                                                N/A
                                            </c:if>
                                            <c:if test="${a.parecerProjeto != null}">
                                                <a href="AgendarExameDefesa.jsp?codigo=${a.codigo}">Agendar Exame Defesa</a>
                                            </c:if>
                                        </td>
                                        <td>
                                            <c:if test="${a.versaoFinalEnviada == false}">
                                                Não Disponível
                                            </c:if>
                                            <c:if test="${a.versaoFinalEnviada == true}">
                                                <c:if test="${a.versaoFinalConfirmadaOrientador == false}">
                                                    <a href="Projeto?action=confirmarVersaoFinal&codigo=${a.codigo}">Confirmar Versão Final</a>
                                                </c:if>
                                                <c:if test="${a.versaoFinalConfirmadaOrientador == true}">
                                                    Finalizado!
                                                </c:if>
                                            </c:if>
                                        </td>
                                    </tr>
                                </c:forEach>
                                </tbody>
                            </table>
                        </c:if>
                    </c:forEach>
                </c:if>
                
            </div>
        </div>

        <c:if test="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo) == null}">
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

        <c:if test="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo) != null}">
            <div class="my-3 p-3 bg-white rounded shadow-sm">
                <h6 class="border-bottom border-gray pb-2 mb-0">Convites Enviados</h6>
                <div class="media text-muted pt-3">
                    
                    <c:if test="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo).size() == 0}">
                        <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                            Nenhum convite enviado até o momento.
                        </p>
                    </c:if>

                    <c:if test="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo).size() != 0}">
                        <table class="table">
                            <thead>
                                <th>Professor</th>
                                <th>Email</th>
                                <th>Ação</th>
                            </thead>
                            <tbody>
                                <c:forEach items="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo)}" var="p">
                                    <tr>
                                        <td>${p.aluno.nome}</td>
                                        <td>${p.aluno.email}</td>
                                        <td><a href="Orientacao?action=cancelar&convidadoId=${p.aluno.codigo}">Cancelar</a></td>
                                    </tr>
                                </c:forEach>
                            </tbody>
                        </table>
                    </c:if>
                </div>
            </div>
        </c:if>

        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Convites Recebidos</h6>
            <div class="media text-muted pt-3">
                <c:if test="${controller.convitesRecebidosByProfessor(sessionScope.usuarioLogado.codigo).size() == 0}">
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        Nenhum convite recebido até o momento.
                    </p>
                </c:if>

                <c:if test="${controller.convitesRecebidosByProfessor(sessionScope.usuarioLogado.codigo).size() != 0}">
                    <table class="table">
                        <thead>
                            <th>Professor</th>
                            <th>Email</th>
                            <th>Ação</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${controller.convitesRecebidosByProfessor(sessionScope.usuarioLogado.codigo)}" var="p">
                                <tr>
                                    <td>${p.aluno.nome}</td>
                                    <td>${p.aluno.email}</td>
                                    <td><a href="Orientacao?action=aceitar&convidadoId=${p.aluno.codigo}">Aceitar</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
        </div>
        <div class="my-3 p-3 bg-white rounded shadow-sm">
            <h6 class="border-bottom border-gray pb-2 mb-0">Seus Orientandos</h6>
            <div class="media text-muted pt-3">
                <c:if test="${controller.obterOrientandosByProfessor(sessionScope.usuarioLogado.codigo).size() == 0}">
                    <p class="media-body pb-3 mb-0 small lh-125 border-bottom border-gray">
                        Você ainda não possui orientandos... convide um aluno!
                    </p>
                </c:if>

                <c:if test="${controller.obterOrientandosByProfessor(sessionScope.usuarioLogado.codigo).size() != 0}">
                    <table class="table">
                        <thead>
                            <th>Professor</th>
                            <th>Email</th>
                            <th>Ação</th>
                        </thead>
                        <tbody>
                            <c:forEach items="${controller.obterOrientandosByProfessor(sessionScope.usuarioLogado.codigo)}" var="p">
                                <tr>
                                    <td>${p.aluno.nome}</td>
                                    <td>${p.aluno.email}</td>
                                    <td><a href="termoAceiteOrientacao.jsp?alunoId=${p.aluno.codigo}&orientadorId=${p.orientador.codigo}">Emitir termo de aceite</a></td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:if>
            </div>
            <form action="Orientacao?action=convidar" method="POST">
                <div class="media text-muted pt-3 d-flex w-100">
                        <div class="px-2 w-100">
                            <select name="convidadoId" id="convidadoId" class="form-control">
                                <c:forEach var="aluno" items="${controller.obterAlunosSemOrientacao()}">
                                    <option value="${aluno.codigo}">${aluno.nome}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="px-2">
                            <button class="btn btn-h" type="submit">Convidar</button>
                        </div>
                </div>
            </form>
        </div>
    </main>
</body>

</html>