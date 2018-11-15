<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="usuarios" class="controller.UsuarioController"/>                

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Professores</title>
        <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
    </head>
    <body>
        <h2 class="text-center mt-4 mb-4">Escolher Professor</h2>
    <table class="table table-striped">
        <thead class="thead-dark">
            <tr>
              <th>Código</th>
              <th>Nome</th>
              <th>CPF</th>
              <th>Prontuário</th>
              <th>Email</th>
              <th>Convite de Orientação</th>
            </tr>
        </thead>
        <tbody>
          <c:forEach items="${usuarios.obterProfessores()}" var="u" >
            <tr>
              <td>${u.codigo}</td>
              <td>${u.nome}</td>
              <td>${u.cpf}</td>
              <td>${u.prontuario}</td>
              <td>${u.email}</td>
              <td><a href="Orientacao?action=convidar&convidadoId=${u.codigo}&perfil=aluno">Convidar</a></td>
            </tr>
          </c:forEach>
        </tbody>
    </table>
    </body>
</html>
