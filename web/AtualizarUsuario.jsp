<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Atualizar Cadastro</title>

    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
    <script src="./js/bootstrap.min.js"></script>
  </head>

  <body class="bg-light">

  <div class="container">
      <div class="py-5 text-center">
        <h2>Atualizar Cadastro</h2>
        <small>*Todos os campos são obrigatórios</small>
      </div>

      <div class="row">
        <div class="col-md-12 order-md-1">
          <form class="needs-validation" action="CadastrarUsuario?action=atualizar" method="post" name="cadastro" novalidate>
            <input type="hidden" name="codigo" value="${sessionScope.usuarioLogado.codigo}" />
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" value="${sessionScope.usuarioLogado.nome}" name="nome" maxlength="50" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Digite um nome válido
                </div>
              </div>
              
              <div class="col-md-6 mb-3">
                <label for="cpf">CPF <i>(xxx.xxx.xxx-xx)</i></label>
                <input type="text" maxlength="14" name="cpf" value="${sessionScope.usuarioLogado.cpf}" class="form-control" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Digite um CPF válido
                </div>
              </div>
            </div>

            <div class="row">   
                <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email" value="${sessionScope.usuarioLogado.email}" maxlength="50" placeholder="email@ifsp.com" required>
                <div class="invalid-feedback">
                    Digite um e-mail válido
                </div>
                </div>

                <div class="col-md-6 mb-3">
                <label for="prontuario">Prontuário IFSP</label>
                <input type="text" class="form-control" maxlength="10" value="${sessionScope.usuarioLogado.prontuario}" name="prontuario" placeholder="HT11256156" required>
                <div class="invalid-feedback">
                    Digite um prontuário válido
                </div>
                </div>
            </div>
            
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Atualizar</button>
          </form>
        </div>
      </div>

      <footer class=" pt-5 text-muted text-center text-small">
        <p class="mb-1">&copy; TCCando IFSP</p>
      </footer>
    </div>

    <script>
      (function() {
        'use strict';

        window.addEventListener('load', function() {
          var forms = document.getElementsByClassName('needs-validation');

          var validation = Array.prototype.filter.call(forms, function(form) {
            form.addEventListener('submit', function(event) {
              if (form.checkValidity() === false) {
                event.preventDefault();
                event.stopPropagation();
              }
              form.classList.add('was-validated');
            }, false);
          });
        }, false);
      })();
    </script>

</body>

</html>