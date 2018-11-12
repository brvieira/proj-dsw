<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="uc" class="controller.UsuarioOrientadorController"></jsp:useBean>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">

        <link rel="stylesheet" href="estilo.css" type="text/css">
        <title>Dashboard do Orientador</title>
    </head>
    <body>
        <div class="caixa">
            <h3>Requisições</h3>
            <br>    
            Não existem requisições pendentes.<br>
        </div>

        <div class="caixa">
            <h3> Projetos</h3>
            <br>
            Não existem projetos sob sua orientação.<br>
        </div>

        <div class="caixa">
            <h3>Seus orientandos</h3>
            Você ainda não possui orientandos... convide um aluno!<br><br>
            <form action="Orientacao?action=convidar" method="POST">
            <select name="convidadoId" id="convidadoId">
                <c:forEach var="aluno" items="${uc.obterAlunosSemOrientacao()}">
                    <option value="${aluno.codigo}">${aluno.nome}</option>
                </c:forEach>
            </select>
            <button type="submit">Convidar</button>
        </form>
            <br>
        </div>

        <div class="caixa">
            <h3>Eventos</h3>
            Não existem bancas marcadas.<br>
            <br>
        </div>
        
        <div class="caixa">
            <a href="AtualizarUsuario.jsp"><button>Alterar Dados</button></a>
            <a href="RecuperarSenhaUsuario.jsp"><button>Trocar Senha</button></a>
            <a href="CadastrarUsuario?action=sair"><button>Sair</button></a>
        </div>

    </body></html>