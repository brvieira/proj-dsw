<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<jsp:useBean id="uc" class="controller.UsuarioController"></jsp:useBean>
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
            Novo Orientando:
            <select name="newCoordId">
                <c:forEach var="professor" items="${uc.obterAlunos()}">
                    <option value="${aluno.codigo}">${aluno.nome}</option>
                </c:forEach>
            </select>
            <button type="submit">Salvar</button>
        </form>
    </body>
</html>
