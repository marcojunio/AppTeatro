<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1 class="display-4 text-center">Associação Cultural Zezin</h1>
<br>
<c:if test="${requestScope.eventos.size() == 0}">
    <div class="row text-center">
        <div class="col">                                 
            <p>Seja bem vindo ao sistema de venda de convites do espaço cultural Zezin</p>
            <p>Nosso espaço conta com um amplo salão que é palco de grande eventos e</p>
            <p>afitetro super moderno e confortável para assitir os mais variados espetáculos.</p>
            <p>Confira nossa agenda e garanta já o seu ingresso.</p>
        </div>
    </div>
</c:if>

<c:if test="${requestScope.eventos.size() > 0}">
    <c:forEach var="e" items="${requestScope.eventos}">
        <div class="card-deck">
            <div class="card">
                <div class="card-body">
                    <h5 class="card-title">${e.descricaoSalao}</h5>
                    <p class="card-text">${e.descricaoEvento}</p>
                     <p class="card-text"><small class="text-muted">É TEATRO ?  ${e.ehTeatro == true? "SIM" : "NÃO"}</small></p>
                    <p class="card-text"><small class="text-muted">Marcado para <fmt:formatDate value="${e.dtInicio}" /></small></p>
                    <a href="ControllerCentral?ac=compraIngresso&idEvento=${e.id}" class="btn btn-primary">Comprar ingresso</a>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>