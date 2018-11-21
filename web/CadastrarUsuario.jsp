<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <title>Cadastrar Usuário</title>

    <link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css" />
    <script src="./js/bootstrap.min.js"></script>
  </head>

  <body class="bg-light">

    <div class="container">
      <div class="py-5 text-center">
        <h2>Cadastrar Usuário</h2>
        <p class="lead">Crie sua conta preenchendo o formulário:</p>
        <small>Já sou usuário? <a href="index.jsp">Fazer Login</a></small>
        <br>
        <small>*Todos os campos são obrigatórios</small>
      </div>

      <div class="row">
        <div class="col-md-12 order-md-1">
          <form class="needs-validation" action="CadastrarUsuario?action=cadastrar" method="post" name="cadastro" novalidate>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="nome">Nome</label>
                <input type="text" class="form-control" name="nome" maxlength="50" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Digite um nome válido
                </div>
              </div>
              
              <div class="col-md-6 mb-3">
                <label for="cpf">CPF <i>(xxx.xxx.xxx-xx)</i></label>
                <input type="text" maxlength="14" name="cpf" class="form-control" placeholder="" value="" required>
                <div class="invalid-feedback">
                  Digite um CPF válido
                </div>
              </div>
            </div>

            <div class="row">   
                <div class="col-md-6 mb-3">
                <label for="email">Email</label>
                <input type="email" class="form-control" name="email" maxlength="50" placeholder="email@ifsp.com" required>
                <div class="invalid-feedback">
                    Digite um e-mail válido
                </div>
                </div>

                <div class="col-md-6 mb-3">
                <label for="prontuario">Prontuário IFSP</label>
                <input type="text" class="form-control" maxlength="10" name="prontuario" placeholder="HT11256156" required>
                <div class="invalid-feedback">
                    Digite um prontuário válido
                </div>
                </div>
            </div>
            
            <h4 class="mb-3">Eu sou?</h4>

            <div class="d-block my-3">
              <div class="custom-control custom-radio">
                <input id="aluno" name="tipoUsuario" value="aluno" type="radio" class="custom-control-input" checked required>
                <label class="custom-control-label" for="aluno">Aluno</label>
              </div>
              <div class="custom-control custom-radio">
                <input id="professor" name="tipoUsuario" value="professor" type="radio" class="custom-control-input" required>
                <label class="custom-control-label" for="professor">Professor</label>
              </div>
            </div>
            <div class="row">
              <div class="col-md-6 mb-3">
                <label for="senha">Senha</label>
                <input maxlength="12" name="senha" type="password" class="form-control" placeholder="" required>
                <div class="invalid-feedback">
                  Digite uma senha válida
                </div>
              </div>
              <div class="col-md-6 mb-3">
                <label for="confirmacaoSenha">Confirme a Senha</label>
                <input type="password" maxlength="12" name="senhaRepetir" class="form-control" id="cc-number" placeholder="" required>
                <div class="invalid-feedback">
                   Digite uma senha válida
                </div>
              </div>
            </div>
            
            <hr class="mb-4">
            <button class="btn btn-primary btn-lg btn-block" type="submit">Cadastrar</button>
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
