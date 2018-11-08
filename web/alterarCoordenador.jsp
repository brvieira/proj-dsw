<%-- 
    Document   : alterarCoordenador
    Created on : 08/11/2018, 08:33:01
    Author     : bruno
--%>
<jsp:useBean id="uc" class="controller.UsuarioController"></jsp:useBean>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alterar Coordenador</title>
    </head>
    <body>
        <h1>Alterar Coordenador</h1>
        <form action="CadastrarUsuario?action=alterarCoordenador" method="POST">
            Novo Coordenador:
            <select name="newCoordId" id="newCoordId">
                <c:forEach var="professor" items="${uc.obterProfessores()}">
                    <option value="${professor.codigo}">${professor.nome}</option>
                </c:forEach>
            </select>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>
