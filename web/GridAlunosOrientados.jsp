<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="controller.UsuarioController"/>                

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuários</title>
    </head>
    <body>
    <p>
    <table border="1px" bordercolor="#FF0000">
      <th>Aluno</th>
      <th>Orientador</th>
      
      <c:forEach items="${usuarios.obterAlunosOrientados()}" var="u" >
        <tr>
          <td>${u.aluno}</td>
          <td>${u.orientador}</td>
        </tr>
      </c:forEach>
    </table>
    </body>
</html>
