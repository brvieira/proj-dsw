<%@page import="model.Usuario"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<jsp:useBean id="model" class="model.Usuario"></jsp:useBean>
<jsp:useBean id="controller" class="controller.UsuarioController"></jsp:useBean>
<%
    Usuario aluno = controller.obterUsuario(Integer.parseInt(request.getParameter("alunoId")));
    Usuario orientador = controller.obterUsuario(Integer.parseInt(request.getParameter("orientadorId")));
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Termo de Aceite</title>
    </head>
    <body>
        <h1>TERMO DE ACEITE DE ORIENTAÇÃO/CO-ORIENTAÇÃO DE TRABALHO DE CONCLUSÃO DE CURSO (TCC)</h1>
        <p>O professor abaixo firmado, conforme as normas de Trabalho de Conclusão de Curso, aceita orientar o(a) acadêmico(a) especificado(a) 
            nos termos do próprio regulamento.</p>
        <p>Caso haja a representação do co-orientador no TCC, com autorização do professor orientador, este aceita a co-orientar o(a) acadêmico(a), 
            respeitando e considerando as diretrizes do professor orientador, bem como os termos do próprio regulamento.</p>
        <span>
            <b>PROFESSOR ORIENTADOR</b><br>
            <b>PRONTUÁRIO: </b><% out.print(orientador.getProntuario()); %><br>
            <b>NOME: </b><% out.print(orientador.getNome()); %><br>
            <b>TELEFONE: </b><br>
            <b>E-MAIL: </b><% out.print(orientador.getEmail()); %><br>
            <b>ÁREA: </b><br>
        </span><br>
        <span>
            <b>CO-ORIENTADOR</b><br>
            <b>NOME: </b><br>
            <b>TELEFONE: </b><br>
            <b>E-MAIL: </b><br>
            <b>CONTATO PROFISSIONAL: </b><br>
        </span><br>
        <span>
            <b>ACADÊMICO</b><br>
            <b>PRONTUÁRIO: </b><% out.print(aluno.getProntuario()); %><br>
            <b>NOME: </b><% out.print(aluno.getNome()); %><br>
            <b>TELEFONE: </b><br>
            <b>E-MAIL: </b><% out.print(aluno.getEmail()); %><br>
        </span><br>
        <%
        Calendar now = Calendar.getInstance();
        Integer dayOfMonthStr = now.get(Calendar.DAY_OF_MONTH);
        String monthStr = (((now.get(Calendar.MONTH) + 1) < 10) ? "0" : "") + (now.get(Calendar.MONTH) + 1);
        %>
        <span>Hortolândia, <% out.print(dayOfMonthStr); %>/<% out.print(monthStr); %>/<% out.print(now.get(Calendar.YEAR)); %>.</span><br>
        __________________ORIENTADOR<br>
        __________________CO-ORIENTADOR (ES)<br>
        __________________ACADÊMICO<br>
    </body>
</html>
