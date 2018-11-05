<%@taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title><fmt:message key="nome.aplicacao"/></title>
    </head>
    <body>
        <sql:query dataSource="${datasource}" var="produtosDados">
                SELECT * FROM produto WHERE codigo = ?
            <sql:param value="${param.codigo}" />
        </sql:query>    
          
        <c:if test="${produtosDados.getRowCount() <= 0}">
            <p><fmt:message key="mensagem.produto.naoexiste"/>
        </c:if>
        
        <c:forEach items="${produtosDados.rows}" var="produto">
            <div class="produto">
                <span><fmt:message key="formulario.produto.rotulo"/></span> </br>
                <span><fmt:message key="formulario.produto.codigo"/>: ${produto.codigo}</span> </br> 
                <span><fmt:message key="formulario.produto.nome"/>: ${produto.nome}</span> </br>
                <span><fmt:message key="formulario.produto.preco"/>: ${produto.preco}</span> </br> 
                <span><fmt:message key="formulario.produto.descricao"/>: ${produto.descricao}</span> 
            </div>
        </c:forEach>
        <div class="butaoVoltar">
                <p><a href="index.jsp"><fmt:message key="formulario.retornar" /></a>
        </div>            
    </body>
</html>