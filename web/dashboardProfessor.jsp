<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="controller" class="controller.UsuarioOrientadorController"/>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">

        <link rel="stylesheet" href="estilo.css" type="text/css">
        <title>Dashboard do Orientador</title>
    </head>
    <body>
        <div class="caixa">
            <h3>Projetos</h3>
            <br>
            Não existem projetos sob sua orientação.<br>
        </div>
        
        <div class="caixa">
            <c:if test="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo) == null}">
                <h3>Orientador</h3>
                <table>
                <thead>
                    <th>Aluno</th>
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
            </c:if>
            <c:if test="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo) != null}">
            <h3>Convites Enviados</h3>
            <c:if test="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo).size() == 0}">
                <p>Nenhum convite enviado até o momento.</p>
            </c:if>
            <c:if test="${controller.convitesEnviadosByProfessor(sessionScope.usuarioLogado.codigo).size() != 0}">
            <table>
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
            </c:if>
        </div>
        
        <div class="caixa">
            <h3>Convites Recebidos</h3>
            <c:if test="${controller.convitesRecebidosByProfessor(sessionScope.usuarioLogado.codigo).size() == 0}">
                <p>Nenhum convite recebido até o momento.</p>
            </c:if>
            <c:if test="${controller.convitesRecebidosByProfessor(sessionScope.usuarioLogado.codigo).size() != 0}">
            <table>
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

        <div class="caixa">
            <h3>Seus orientandos</h3>
            <c:if test="${controller.obterOrientandosByProfessor(sessionScope.usuarioLogado.codigo) == null}">
            Você ainda não possui orientandos... convide um aluno!<br><br>
            </c:if>
            <c:if test="${controller.obterOrientandosByProfessor(sessionScope.usuarioLogado.codigo) != null}">
                <table>
                <thead>
                    <th>Aluno</th>
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
            <form action="Orientacao?action=convidar" method="POST">
            <select name="convidadoId" id="convidadoId">
                <c:forEach var="aluno" items="${controller.obterAlunosSemOrientacao()}">
                    <option value="${aluno.codigo}">${aluno.nome}</option>
                </c:forEach>
            </select>
            <button type="submit">Convidar</button>
        </form>
            <br>
        </div>
        
        <div class="caixa">
            <a href="AtualizarUsuario.jsp"><button>Alterar Dados</button></a>
            <a href="RecuperarSenhaUsuario.jsp"><button>Trocar Senha</button></a>
            <a href="CadastrarUsuario?action=sair"><button>Sair</button></a>
        </div>

    </body></html>