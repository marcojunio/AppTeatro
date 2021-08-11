<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center display-4">Relatório Financeiro</h1>
<table class="table table-striped">
    <fieldset>
        <form class="mt-4" action="ControllerCentral" method="GET" > 
            <input type="hidden" name="ac" value="listRelatorio" />
            <div class="d-flex justify-content-center align-items-center">
                <div class="form-group col-4">
                    <label for="datInicial">Data Inicial</label>
                    <input id="datInicial" type="date" class="form-control" name="dtInicial"/>
                </div>
                <div class="form-group col-4">
                    <label for="dtFinal">Data Final</label>
                    <input id="dtFinal" type="date" class="form-control" name="dtFinal"/>
                </div>
                <div class="form-group mt-4 ml-2">               
                    <button type="submit" class="btn btn-primary" >Atualizar</button>
                </div>   
            </div>
        </form>   
    </fieldset>
    <thead>
        <tr>
            <th>Salão</th>
            <th>Evento</th>
            <th>Locado ?</th>
            <th>Entrada</th>
            <th>Saída</th>
            <th>Total</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${requestScope.relatorio.size() == 0}">
            <tr>
                <td class="text-center" colspan="6"> Não há dados para Relatório</td>
            </tr> 
        </c:if>

        <c:forEach var="r" items="${requestScope.relatorio}">
            <tr>
                <td>${r.nomeSalao}</td>
                <td>${r.nomeEvento}</td>
                <td>
                    <c:if test="${r.valorAluguel == 0}">
                        NÃO
                    </c:if>
                    <c:if test="${r.valorAluguel > 0}">
                        SIM
                    </c:if>
                </td>    
                <td><fmt:setLocale value="pt-BR" /><fmt:formatNumber value="${r.entrada()}" minFractionDigits="2" type="currency" /></th>
                <td><fmt:setLocale value="pt-BR" /><fmt:formatNumber value="${r.saida()}" minFractionDigits="2" type="currency" /></th>    
                <td><fmt:setLocale value="pt-BR" /><fmt:formatNumber value="${r.total()}" minFractionDigits="2" type="currency" /></td> 
            </tr>
        </c:forEach> 
    <h5 class="text-success">Total: <fmt:setLocale value="pt-BR" /><fmt:formatNumber value="${requestScope.total}" minFractionDigits="2" type="currency" /></h5>   
</tbody>          
</table>

