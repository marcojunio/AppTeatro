<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="pt-br">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <script src="https://kit.fontawesome.com/29ef1c1af1.js" crossorigin="anonymous"></script>
        <link rel="icon" href="img/favicon.png">
        <link rel="stylesheet" type="text/css" href="css/style2.css">
        <title>Associação Cultural Zezin</title>
    </head>
    <body>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script> 

        <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js" integrity="sha384-9/reFTGAW83EW2RDu2S0VKaIzap3H66lZH81PoYlFhbGU+6BZp6G7niu735Sk7lN" crossorigin="anonymous"></script>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.min.js" integrity="sha384-+YQ4JLhjyBLPDQt//I+STsc9iw4uQqACwlvpslubQzn4u2UU2UFM80nGisd026JF" crossorigin="anonymous"></script> 


        <header>
            <nav class="navbar navbar-expand-sm navbar-light fixed-top navbar-transparente">
                <div class="container">
                    <a href="ControllerCentral" class="navbar-brand"> 
                        <img src="img/favicon.png" width="100">
                    </a>

                    <h1 class="nav-titulo">Associação Cultural Zezin</h1>

                    <button class="navbar-toggler" data-toggle="collapse" data-target="#nav-principal">
                        <i class="fas fa-bars text-white"></i>
                    </button>

                    <div class="collapse navbar-collapse" id="nav-principal">
                        <ul class="navbar-nav ml-auto">
                            <li class="nav-item">
                                <a href="ControllerCentral?ac=logar" class="nav-link">Entrar</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </header>     

        <section>
            <div class="container">
                <div class="caixa" style="margin-top: 150px">
                    <div class="row">
                        <div class="col-md-12 d-flex"> 
                            <div id="carouselExampleCaptions" class="carousel slide" data-ride="carousel">
                                <ol class="carousel-indicators">
                                    <li data-target="#carouselExampleCaptions" data-slide-to="0" class="active"></li>
                                    <li data-target="#carouselExampleCaptions" data-slide-to="1"></li>
                                </ol>
                                <div class="carousel-inner">
                                    <div class="carousel-item active">
                                        <img src="img/teatro-01.jpg" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Anfiteatro</h5>
                                            <p>Modernidade, versatilidade e elegância para seu evento.</p>
                                        </div>
                                    </div>
                                    <div class="carousel-item">
                                        <img src="img/teatro-02.jpg" class="d-block w-100" alt="...">
                                        <div class="carousel-caption d-none d-md-block">
                                            <h5>Teatro</h5>
                                            <p>Faça um evento para ser aplaudido de pé</p>
                                        </div>
                                    </div>
                                </div>
                                <a class="carousel-control-prev" href="#carouselExampleCaptions" role="button" data-slide="prev">
                                    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Previous</span>
                                </a>
                                <a class="carousel-control-next" href="#carouselExampleCaptions" role="button" data-slide="next">
                                    <span class="carousel-control-next-icon" aria-hidden="true"></span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </div> 
                        </div>
                    </div>
                </div>
            </div>

        </section>

        <section>
            <div class="container" >
                <div class="caixa" style="background-color: whitesmoke">
                    <div class="row row justify-content-center">
                        <div class="col">
                            <img src="img/teatro-04.jpg" class="img-fluid rounded mx-auto d-block border" style="margin: 2%">
                        </div>
                        <div class="col text-center" style="padding:5%">
                            <h1>TEATRO</h1>
                            <p class="text-justify">
                                Com 2.000m² de área, o Teatro apresenta-se como um espaço multifuncional, 
                                sofisticado e inovador, que conquista em cada detalhe. Nossas atrações se apresentam 
                                em um palco de 215m², com boca de cena de 15 metros de altura e 36 varas cenográficas motorizadas.
                            </p>
                        </div>

                    </div>

                    <div class="row">
                        <div class="col text-center" style="padding:3%">
                            <h1>ANFITEATRO</h1>
                            <p class="text-justify">
                                O Anfiteatro é um espaço multiuso, 
                                adaptável para vários tipos de eventos. 
                                Somos o único anfiteatro do Brasil que possui poltronas 
                                com sistema de recolhimento automatizado que torna 
                                possível a mudança de parte da configuração em até 10 minutos.
                                Um espaço para múltiplas ideias!
                            </p>
                        </div>
                        <div class="col">
                            <img src="img/teatro-03.jpg" class="img-fluid rounded mx-auto d-block border" style="margin: 2%">
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <section> <!-- MAPA -->
            <div class="container"">
                <div class="row" >
                    <div class="col-md-12">
                        <iframe src="https://www.google.com/maps/embed?pb=!1m14!1m8!1m3!1d14632.67553917256!2d-46.6808813!3d-23.5264274!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x0%3A0xf741c6e7df1fd020!2sTeatro%20Bradesco!5e0!3m2!1spt-BR!2sbr!4v1617738717510!5m2!1spt-BR!2sbr" 
                                width="100%" height="450" 
                                style="border:2;" allowfullscreen="" loading="lazy">
                        </iframe>
                    </div>
                </div>
            </div>
        </section>

        <section>
            <div class="container">
                <div class="caixa">
                    <div class="row" style="background-color: whitesmoke">
                        <div class="col-md-5 caixa-conteudo" >
                            <div class="form-group">
                                <form>
                                    <fieldset>
                                        <legend>Contato</legend>
                                        <label for="nome" class="form-label">Seu nome:</label>
                                        <input class="form-control form-ajuste" type="text" name="nome" id="nome"></input>
                                        <label for="email" class="form-label">Email:</label>
                                        <input class="form-control form-ajuste" type="email" name="email" id="email"></input>
                                        <label for="mensagem" class="form-label">Sua mensagem:</label>
                                        <textarea class="form-control form-ajuste" name="mensagem" id="mensagem" rows="3"></textarea>
                                        <button class="btn btn-lg btn-primary btn-block" type="submit">Enviar</button>
                                    </fieldset>

                                </form>
                            </div>
                        </div>

                        <div class="col-md-6 caixa-conteudo">
                            <p>
                                Lorem Ipsum is simply dummy text of the printing and
                                typesetting industry. Lorem Ipsum has been the 
                                industry's standard dummy text ever since the 1500s
                                ,when an unknown printer took a galley of type and 
                                scrambled it to make a type specimen book. It has 
                                survived not only five centuries, but also the leap 
                                into electronic typesetting, remaining essentially 
                                unchanged. It was popularised in the 1960s with the 
                                release of Letraset sheets containing Lorem Ipsum 
                                passages, and more recently with desktop publishing 
                                software like Aldus PageMaker including versions of 
                                Lorem Ipsum.
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <footer class="layout-footer" style="background: black" >
            <div class="container">
                <div class="row">
                    <div class="col-md-8 offset-2">
                        <p class="text-white">
                            2021 &copy; Todos os direitos reservados. 
                            Feito por Marcos André e Vinicius Assunção
                        </p>
                    </div>

                    <div class="col-md-1 d-flex justify-content-center">
                        <a href="#" class="btn btn-outline-dark">
                            <i class="fab fa-facebook"></i>
                        </a>
                        <a href="#" class="btn btn-outline-dark ">
                            <i class="fab fa-twitter"></i>
                        </a>
                        <a href="#" class="btn btn-outline-dark ">
                            <i class="fab fa-instagram"></i>
                        </a>
                    </div>  
                </div>
            </div>
        </footer>
    </body>
</html>
