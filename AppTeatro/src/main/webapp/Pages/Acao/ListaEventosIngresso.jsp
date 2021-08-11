<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center mb-4 display-4">Eventos disponíveis</h1>
<table class="table table-striped">
    <thead>
        <tr>
            <th>Descrição</th>
            <th>Salão</th>
            <th>Teatro</th>
            <th>Endereço</th>
            <th>Data</th>
            <th>Ação</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${requestScope.eventos.size() == 0}">
            <tr>
                <td class="text-center" colspan="7"> Não há Evento Cadastrados</td>
            </tr> 
        </c:if>
        <c:forEach var="e" items="${requestScope.eventos}">
            <tr>
                <td>${e.descricaoEvento}</td>
                <td>${e.descricaoSalao}</td>
                <td>${e.ehTeatro == true? "SIM" : "NÃO"}</td>
                <td>${e.endereco}</th>
                <td><fmt:formatDate value="${e.dtInicio}"/></th>
                <td>
                    <a href="ControllerCentral?ac=compraIngresso&idEvento=${e.id}"><span><i class="fa fa-shopping-cart"></i></span></a>
                </td> 
            </tr>
        </c:forEach>                      
    </tbody>          
</table>

