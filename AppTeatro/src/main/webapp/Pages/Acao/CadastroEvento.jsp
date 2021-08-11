<%@page import="br.vianna.aula.appteatro.domain.entities.Evento"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="container-fluid corpo">
    <div class="row justify-content-md-center h-100 p-5">
        <div class="card-wrapper">
            <%if (request.getAttribute("msg") != null) {%>
            <div class="alert alert-success text-center">
                <%= request.getAttribute("msg")%>
            </div>
            <%}%>
            <h1 class="text-center mb-2">${requestScope.titulo}</h1>  
            <div class="card fat">
                <div class="card-body">
                    <h4 class="card-title text-center">Evento</h4>
                    <form method="POST" action="ControllerCentral">
                        <input type="hidden" name="ac" value="saveEvento"/>
                        <input type="hidden" name="idEvento" value="${requestScope.evento.id}"/>
                        <div class="row">
                            <label for="descricao">Descrição</label>
                            <input required id="descricao" type="text" class="form-control mb-3" name="descricao" value="${requestScope.evento.descricao}"/>
                        </div>
                        <div class="row">
                            <div class="form-group mr-2">
                                <label for="valorLimpeza">Valor Limpeza</label>
                                <input required id="valorLimpeza" type="text" class="form-control" name="valorLimpeza" value="${requestScope.evento.valorDaLimpeza}"/>
                            </div>
                            <div class="form-group mr-2">
                                <label for="valorLimpeza">Máximo de pessoas</label>
                                <input required id="valorLimpeza" type="text" class="form-control" name="maxPessoas" value="${requestScope.evento.maxPessoas}"/>
                            </div>
                            <div class="form-group">
                                <label for="valorLuz">Valor Luz</label>
                                <input required id="valorLuz" type="text" class="form-control" name="valorLuz" value="${requestScope.evento.valorDaLuz}"/>
                            </div>        
                        </div>
                        <div class="row">
                            <div class="form-group mr-2">
                                <label for="valorLuz">Valor do ingresso</label>
                                <input required id="valorLuz" type="text" class="form-control" name="valorIngresso" value="${requestScope.evento.valorIngresso}"/>
                            </div>
                            <div class="form-group mr-2">
                                <label for="valorLuz">Data do evento</label>
                                <input required id="valorLuz" type="date" class="form-control" name="dataEvento" value="${requestScope.data}"/>
                            </div>
                            <div class="form-group">
                                <label for="salao">Salão</label>
                                <select id="salao" class="form-control" name="salaoSelect">
                                    <c:if test="${requestScope.evento.salao != null}">
                                        <option value="${requestScope.evento.salao.id}">${requestScope.evento.salao.descricao}</option>
                                    </c:if>
                                    <c:if test="${requestScope.saloes.size() == 0}">
                                        <option value="-1">Não há salões disponíveis</option>
                                    </c:if>
                                    <c:if test="${requestScope.saloes.size() > 0 && requestScope.evento.salao == null}">
                                        <c:forEach var="s" items="${requestScope.saloes}">
                                            <option value="${s.id}">${s.descricao}</option>
                                        </c:forEach>   
                                    </c:if>
                                </select>
                            </div>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="ehTeatro" ${requestScope.evento.ehTeatro == true? "checked=true" : false}" id="inlineRadio1" value="sim">
                            <label class="form-check-label" for="inlineRadio1">É um teatro</label>
                        </div>
                        <div class="form-check form-check-inline">
                            <input class="form-check-input" type="radio" name="ehTeatro" id="inlineRadio2" ${requestScope.evento.ehTeatro == false? "checked=false" : false} value="nao">
                            <label class="form-check-label" for="inlineRadio2">Não é teatro</label>
                        </div>
                        <div class="form-group mt-4">
                            <button type="submit" class="btn btn-primary">
                                Cadastrar
                            </button>
                            <a href="ControllerCentral?ac=listEvento"><button class="btn btn-primary" type="button">Voltar</button></a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
</script>