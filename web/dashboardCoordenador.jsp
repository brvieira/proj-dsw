<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">

        <link rel="stylesheet" href="estilo.css" type="text/css">
        <title>Dashboard do Coordenador</title>
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
            <br>
        </div>
        
        <div class="caixa">
            <h3>Alunos<br></h3>
            <a href="GridAlunos.jsp"><button>Visualizar Todos Alunos</button></a>
        </div>
        
        <div class="caixa">
            <h3>Alunos e Orientadores<br></h3>
            Alunos com orientação: <br>
            Alunos sem orientação: <br>
            <b>Relação orientador e orientandos: </b><br>
            <br>
            <a href="GridAlunosOrientados.jsp"><button>Orientados x Orientandos</button></a>
        </div>

        <div class="caixa">
            <h3>Eventos</h3>
            Não existem bancas marcadas.<br>
            <br>
        </div>
        
        <div class="caixa">
            <a href="AtualizarUsuario.jsp"><button>Alterar Dados</button></a>
            <a href="AlterarCoordenador.jsp"><button>Alterar Coordenador</button></a>
            <a href="RecuperarSenhaUsuario.jsp"><button>Trocar Senha</button></a>
            <a href="CadastrarUsuario?action=sair"><button>Sair</button></a>
        </div>

    </body></html>