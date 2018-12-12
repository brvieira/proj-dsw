<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="projeto" class="controller.ProjetoController"/>                

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Visualizar Parecer</title>
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
    </head>
    <body style="text-align: center">
        <h2 class="text-center mt-4 mb-4">Parecer Projeto</h2>

        <textarea style="width: 80%; margin: auto" disabled>
        ${projeto.obterParecer(param["codigo"])}
        </textarea>
        <br>
        <a href="javascript:window.history.go(-1)">Voltar</a>
    </body>
</html>
