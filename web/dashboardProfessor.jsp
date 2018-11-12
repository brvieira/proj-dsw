<jsp:useBean id="uc" class="controller.UsuarioController"></jsp:useBean>
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
            Você ainda não possui orientandos... convide um aluno!<br>
            <form action="Orientacao?action=alterarOrientando" method="POST">
            Aluno
            <select name="usuarioID" id="usuarioID">
                <c:forEach var="aluno" items="${uc.obterAlunos()}">
                    <option value="${aluno.codigo}">${aluno.nome}</option>
                </c:forEach>
            </select>
            <button type="submit">Salvar</button>
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