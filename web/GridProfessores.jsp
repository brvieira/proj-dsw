<%-- 
    Document   : GridProfessores
    Created on : 12/11/2018, 20:11:58
    Author     : bruno
--%>

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
      <th>Código</th>
      <th>Nome</th>
      <th>CPF</th>
      <th>Prontuário</th>
      <th>Email</th>
      <th>Convite de Orientação</th>
      
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
    </table>
    </body>
</html>
