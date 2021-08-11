<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="br.vianna.aula.appteatro.domain.entities.Usuario"%>
<!DOCTYPE html>
<html lang="pt" xmlns="http://www.w3.org/1999/xhtml" >
    <head>
        <title>Associação Cultural Zezin</title>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no" />
        <meta name="description" content="" />
        <meta name="author" content="" />
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/open-iconic/1.1.1/font/css/open-iconic.min.css" integrity="sha512-LeCmts7kEi09nKc+DwGJqDV+dNQi/W8/qb0oUSsBLzTYiBwxj0KBlAow2//jV7jwEHwSCPShRN2+IWwWcn1x7Q==" crossorigin="anonymous" />
        <link rel="stylesheet" type="text/css" href="https://cdn.jsdelivr.net/npm/font-awesome@4.7.0/css/font-awesome.min.css" />
        <link rel="stylesheet" type="text/css" href="css/home.css" />
        <link rel="stylesheet" type="text/css" href="css/style.css" />
        <link rel="icon" href="img/favicon.png">
            <script src="https://code.jquery.com/jquery-3.5.1.min.js" ></script>
            <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>
    </head>
    <body>

        <header>
            <nav class="navbar navbar-inverse navbar navbar-dark bg-dark fixed-top">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <button type="button" class="btn btn-dark navbar-toggle pull-left menu-toggle"  data-target="#side-bar">
                            <i class="oi oi-menu"></i>
                        </button>
                        <a class="navbar-brand " href="#">Associação cultural Zezin</a>
                    </div>
                </div>
            </nav>
        </header>

        <div class="layout-main"> 

            <aside class="wrapper" id="side-bar">
                <nav id="menu" class="sidebar sidebar-open">
                    <ul class="nav nav-pills">
                        <li class="nav-item">
                            <a class="nav-link " href="ControllerCentral?ac=home"><i class="oi oi-home"></i> 
                                <span>Home</span>
                            </a>
                        </li>
                    </ul>
                    <ul class="nav nav-pills">                 
                        <li class="nav-item"><span class="nav-link active" >Vendas</span></li>
                        <li class="nav-item">
                            <a class="nav-link " href="ControllerCentral?ac=listEventosDisponivel"> <i class="oi oi-spreadsheet"></i>
                                <span>Comprar Ingresso</span>
                            </a>
                        </li>
                        <c:if test="${sessionScope.tipoUser == true}">
                            <li class="nav-item"><span class="nav-link active" >Administração</span></li>
                            <li class="nav-item">
                                <a class="nav-link" href="ControllerCentral?ac=listEvento"> <i class="oi oi-cart"></i> 
                                    <span>Evento</span>
                                </a>
                            </li>                           
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="ControllerCentral?ac=ListSalao"> <i class="oi oi-cart"></i> <span>Salões</span>
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link"
                                   href="ControllerCentral?ac=listRelatorio"> <i class="oi oi-cart"></i> <span>Relatório</span>
                                </a>
                            </li>    
                        </c:if>
                    </ul>
                    <ul class="nav nav-pills">
                        <li class="nav-item"><span class="nav-link active" >Dados / Logout</span></li>
                        <li class="nav-item">
                            <a class="nav-link " href="ControllerCentral?ac=listDados"> <i class="oi oi-spreadsheet"></i>
                                <span>Meus Dados</span>
                            </a>
                        </li>
                        <li class="nav-item" >
                            <a class="nav-link " href="ControllerCentral?ac=logout"><i class="oi oi-account-logout"></i> 
                                <span>Sair</span>
                            </a>
                        </li>
                    </ul>
                </nav>
            </aside>
            <section class="row container-fluid"  >
                <div class="col-12">
                    <c:if test="${requestScope.page == null}">
                        <jsp:include page="Pages/Home.jsp" />
                    </c:if>   

                    <c:if test="${requestScope.page != null}">
                        <jsp:include page="${requestScope.page}" />
                    </c:if>   
                </div>
            </section>
        </div>
        <footer class="layout-footer">
            <div class="container">
                <span class="footer-copy">&copy; 2021 &copy; Todos os direitos reservados. 
                    Feito por Marcos André e Vinicius Assunção</span>
            </div>
        </footer> 
    </body>
</html>
