<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<h1 class="display-4 text-center">Associa��o Cultural Zezin</h1>
<br>
<c:if test="${requestScope.eventos.size() == 0}">
    <div class="row text-center">
        <div class="col">                                 
            <p>Seja bem vindo ao sistema de venda de convites do espa�o cultural Zezin</p>
            <p>Nosso espa�o conta com um amplo sal�o que � palco de grande eventos e</p>
            <p>afitetro super moderno e confort�vel para assitir os mais variados espet�culos.</p>
            <p>Confira nossa agenda e garanta j� o seu ingresso.</p>
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
                     <p class="card-text"><small class="text-muted">� TEATRO ?  ${e.ehTeatro == true? "SIM" : "N�O"}</small></p>
                    <p class="card-text"><small class="text-muted">Marcado para <fmt:formatDate value="${e.dtInicio}" /></small></p>
                    <a href="ControllerCentral?ac=compraIngresso&idEvento=${e.id}" class="btn btn-primary">Comprar ingresso</a>
                </div>
            </div>
        </div>
    </c:forEach>
</c:if>