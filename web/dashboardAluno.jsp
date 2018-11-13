<%@page import="controller.UsuarioOrientadorController"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="controller" class="controller.UsuarioOrientadorController"/>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="estilo.css" type="text/css">
        <title>Dashboard do Aluno</title>
    </head>
    <body>
        <c:if test="${controller.obterOrientador(sessionScope.usuarioLogado.codigo) == null}">
        <div class="caixa">
            <h3>Convidar Orientador</h3>
            <p>Você ainda não possui orientador... <a href="GridProfessores.jsp">convide um professor!</a></p>                   
        </div>
        </c:if>
        <div class="caixa">
            <c:if test="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo) == null}">
                <h3>Orientador</h3>
                <table>
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
            </c:if>
            <c:if test="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo) != null}">
            <h3>Convites Enviados</h3>
            <c:if test="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo).size() == 0}">
                <p>Nenhum convite enviado até o momento.</p>
            </c:if>
            <c:if test="${controller.convitesEnviadosByAluno(sessionScope.usuarioLogado.codigo).size() != 0}">
            <table>
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
            </c:if>
        </div>
        <c:if test="${controller.obterOrientador(sessionScope.usuarioLogado.codigo) == null}">
        <div class="caixa">
            <h3>Convites Recebidos</h3>
            <c:if test="${controller.convitesRecebidosByAluno(sessionScope.usuarioLogado.codigo).size() == 0}">
                <p>Nenhum convite recebido até o momento.</p>
            </c:if>
            <c:if test="${controller.convitesRecebidosByAluno(sessionScope.usuarioLogado.codigo).size() != 0}">
            <table>
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
        </c:if>
        </div>
        <c:if test="${controller.obterOrientador(sessionScope.usuarioLogado.codigo) != null}">
        <div class="caixa">
            <h3> Projeto</h3>
                <p>Você ainda não elaborou seu projeto... <a href="selecaoorientador.html">Enviar proposta de projeto!</a></p>
        </div>
        </c:if>
        <div class="caixa">
            <a href="AtualizarUsuario.jsp"><button>Alterar Dados</button></a>
            <a href="RecuperarSenhaUsuario.jsp"><button>Trocar Senha</button></a>
            <a href="CadastrarUsuario?action=sair"><button>Sair</button></a>
        </div>
        
    </body>
</html>
