<%-- 
    Document   : dashboardaluno
    Created on : 05/11/2018, 19:51:12
    Author     : a1620037
--%>

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
            <a href="alterarusuario.jsp?codigo=${sessionScope.s}"
        </div>
    </body>
</html>
