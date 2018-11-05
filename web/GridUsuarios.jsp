<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="nome.aplicacao"/></title>
    </head>
    <body>
    <p><h2><fmt:message key="menu.visualizar.produtos"/></h2>
    <p>
    <table border="1px" bordercolor="#FF0000">
        <sql:query var="dadosProdutos" dataSource="${datasource}">
            SELECT * FROM produto
        </sql:query>
      <TH><fmt:message key="formulario.produto.codigo"/></th>
      <TH><fmt:message key="formulario.produto.nome"/></th>
      <TH><fmt:message key="formulario.produto.preco"/></th>
      <TH><fmt:message key="formulario.produto.descricao"/></th>
      <TH colspan="2"><fmt:message key="formulario.produto.acoes"/></th>
      
      <c:if test="${dadosProdutos.getRowCount() == 0}">
          <p><tr><td colspan="5"><fmt:message key="mensagem.produto.naoexiste"/></td></tr>
      </c:if>    
      
      <c:forEach items="${dadosProdutos.rows}" var="p" >
        <tr>
          <td><c:out value="${p.codigo}" /></td>
          <td><a href="visualizarProduto.jsp?codigo=${p.codigo}"><c:out value="${p.nome}" /></a></td>
          <td><c:out value="${p.preco}" /></td>
          <td><c:out value="${p.descricao}" /></td>
          <td><a href="formularioAlteraProduto.jsp?codigo=<c:out value="${p.codigo}"/>"><fmt:message key="mensagem.produto.alterar"/></a></td>
          <td><a href="confirmarRemoverProduto.jsp?codigo=<c:out value="${p.codigo}"/>"><fmt:message key="mensagem.produto.remover"/></a></td>
        </tr>
      </c:forEach>
    </table>
    <p><a href="index.jsp"><fmt:message key="formulario.retornar" /></a>
    </body>
</html>
