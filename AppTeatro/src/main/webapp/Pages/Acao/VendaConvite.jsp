<%@page import="br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid corpo">
    <div class="row justify-content-md-center h-100 p-5">
        <div class="card-wrapper">
            <h1 class="text-center mb-2">${requestScope.titulo}</h1>  
            <div class="card fat">
                <div class="card-body">
                    <h4 class="card-title text-center">Realizar compra</h4>
                    <h2 class="display-4 text-center">Total da compra <fmt:setLocale value="pt-BR" /><fmt:formatNumber value="${requestScope.eventoEscolhido.valorIngresso}" minFractionDigits="2" type="currency" /></h2>
                    <form method="POST" action="ControllerCentral">
                        <input type="hidden" name="ac" value="comprar"/>
                        <input type="hidden" name="evento" id="eventoEscolhido" value="${requestScope.eventoEscolhido.id}"/>
                        <c:if test="${requestScope.eventoEscolhido.valorIngresso == 0}">
                            <div class="row mt-4">
                                <div class="jumbotron jumbotron-fluid">
                                    <div class="container">
                                        <h1 class="text-center display-4">Evento Beneficente <3</h1>
                                        <p class="lead">Esse evento foi promovido por um dos nossos patrocinadores, olha que incrível!! Levar somente 1kg de alimento não perecível para a entrada ;).</p>
                                    </div>
                                </div>
                            </div>
                        </c:if>

                        <div class="row">
                            <div class="form-group mr-2">
                                <input id="valorIngresso" type="hidden" class="form-control" name="valorIngresso" value="${requestScope.eventoEscolhido.valorIngresso}"/>
                            </div>
                            <c:if test="${requestScope.teatro == true}">
                                <div class="form-group mr-2">
                                    <label for="setor">Escolha o setor</label>
                                    <input required maxlength="1" id="setor" type="text" class="form-control" name="setorEscolhido""/>
                                </div>
                                <div class="form-group">
                                    <label for="codigoCadeira">Código da cadeira</label>
                                    <input required id="codigoCadeira" maxlength="2" type="text" class="form-control" name="cadeiraEscolhida""/>
                                    <span id="danger"></span> 
                                </div>
                            </div>
                        </c:if>
                        <c:if test="${requestScope.eventoEscolhido.valorIngresso > 0}">
                            <div class="row">
                                <c:if test="${sessionScope.idadeCliente > 18}">
                                    <div class="form-check ml-2 mr-2">
                                        <input class="form-check-input" checked type="radio" name="tipoIngresso" id="tipoIngresso" value="inteira">
                                        <label class="form-check-label" for="tipoIngresso">
                                            INTEIRA
                                        </label>
                                    </div>
                                </c:if>
                                <c:if test="${sessionScope.idadeCliente <= 18}">
                                    <div class="form-check">
                                        <input class="form-check-input" checked required type="radio" name="tipoIngresso" id="tipoIngresso" value="meia">
                                        <label class="form-check-label" for="tipoIngresso">
                                            MEIA
                                        </label>
                                    </div>
                                </c:if>
                            </div>
                        </c:if>
                        <c:if test="${requestScope.teatro == true}">
                            <div class="img-fluid text-center">
                                <img width="650" height="650" src="img/mapaTeatro.jpg"></img>
                            </div>
                        </c:if>
                        <div class="mt-4">
                            <button type="submit" id="btn-submit" ${requestScope.teatro == true? "disabled=true" : "enabled"} class="btn btn-primary">
                                Comprar
                            </button>
                            <a href="ControllerCentral?ac=listEventosDisponivel"><button class="btn btn-primary" type="button">Voltar</button></a>
                            <c:if test="${requestScope.teatro == true}">
                                <button type="button" id="btnVerificaAssento" class="btn btn-primary">Verificar Disponibilidade</button>
                            </c:if>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
    $("#btnVerificaAssento").on('click', function () {
        $.ajax({
            url: "ControllerCentral?ac=verifcarDisponibilidade",
            type: 'GET',
            data: {
                setor: $("#setor").val(),
                cadeira: $("#codigoCadeira").val(),
                evento: $('#eventoEscolhido').val()
            },
            statusCode: {
                400: function (data, textStatus, jqXHR) {
                    $("#danger").removeClass("text-success");
                    $("#danger").html("Assento indisponível");
                    $("#danger").addClass("text-danger");
                    $("#codigoCadeira").addClass("acento-danger");
                    $("#btn-submit").attr('disabled', true);
                },
                200: function () {
                    $("#danger").removeClass("text-danger");
                    $("#danger").html("Assento disponível");
                    $("#danger").addClass("text-success");
                    $("#codigoCadeira").removeClass("acento-danger");
                    $("#btn-submit").attr('disabled', false);
                }
            }
        });
    });
</script>
