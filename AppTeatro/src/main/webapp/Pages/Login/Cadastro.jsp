<!DOCTYPE html>
<html lang="pt" xmlns="http://www.w3.org/1999/xhtml"  >
    <head>
        <title>Associa��o Cultural Zezin</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />
        <link rel="icon" type="image/png" href="images/favicon.ico"  />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/animsition@4.0.2/dist/css/animsition.min.css" />
        <link rel="stylesheet" type="text/css" href="css/login.css" />
    </head>
    <body>
        <div class="container-fluid corpo">
            <div class="row justify-content-md-center h-100 p-5">
                <div class="card-wrapper">
                    <div class="brand text-center">
                        <h1 class="logo-badge text-whitesmoke"><span class="fa fa-user-circle"></span></h1>
                    </div>
                    <% if (request.getAttribute("msg") != null) {%>
                    <div class="alert alert-success text-center">
                        <%= request.getAttribute("msg")%>                                        
                    </div>
                    <% }%>
                    <div class="card fat">
                        <div class="card-body">
                            <h4 class="card-title text-center">Cadastro</h4>
                            <form method="POST" class="my-login-validation" novalidate="" action="ControllerCentral">
                                <input type="hidden" name="ac" value="saveUser"/>
                                <div class="form-group">
                                    <label for="login">Login</label>
                                    <input id="email" type="text" class="form-control" name="login" class="valid" value="" required="" autofocus="" kl_ab.original_type="email">
                                </div>
                                <div class="form-group">
                                    <label for="senha">Senha</label>
                                    <div style="position:relative" id="eye-password-0">
                                        <input id="password" type="password" class="form-control" class="valid" name="senha" required="" data-eye="" style="padding-right: 60px;">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="nomeCliente">Nome do Cliente</label>
                                    <div style="position:relative" id="eye-password-0">
                                        <input  type="text" class="form-control" name="nomeCliente" data-eye="" class="valid" style="padding-right: 60px;">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="nomeCliente">Endere�o</label>
                                    <div style="position:relative" id="eye-password-0">
                                        <input type="text" class="form-control" name="enderecoCliente" class="valid" data-eye="" style="padding-right: 60px;">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="nomeCliente">Idade</label>
                                    <div style="position:relative" id="eye-password-0">
                                        <input type="text" class="form-control" name="idadeCliente" class="valid" data-eye="" style="padding-right: 60px;">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="nomeCliente">Documento</label>
                                    <div style="position:relative" id="eye-password-0">
                                        <input type="text" class="form-control" name="documentoCliente" class="valid" data-eye="" style="padding-right: 60px;">
                                    </div>
                                </div>
                                <div class="form-group m-0">
                                    <button type="submit" class="btn btn-primary btn-block send">
                                        Cadastrar
                                    </button>
                                </div>
                                <div class="mt-4 text-center">
                                    <a href="ControllerCentral">Voltar</a>
                                </div>
                            </form>
                        </div>
                    </div>
                    <div class="footer text-center">
                        Associa��o Cultural Zezin
                    </div>
                </div>
            </div>
        </div>
        <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/animsition@4.0.2/dist/js/animsition.min.js"></script>
    </body>
</html>