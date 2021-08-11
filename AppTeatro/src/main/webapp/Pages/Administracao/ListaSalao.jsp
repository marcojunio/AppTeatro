<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center mb-4 display-4">Salão</h1>
<table class="table table-striped">
    <%if (request.getAttribute("msg") != null) {%>
    <div class="alert alert-success text-center">
        <%= request.getAttribute("msg")%>
    </div>
    <%}%>
    <fieldset>
        <legend>Pesquisar</legend>
        <form action="ControllerCentral" method="GET" > 
            <input type="hidden" name="ac" value="ListSalao" />
            <div class="row">
                <div class="col">     
                    <div class="form-group">                 
                        <label for="salao">Descrição do salão</label> 
                        <input type="text" name="descricaoSalao" id="salao" class="form-control"/>  
                    </div>                
                </div>
            </div>
            <div class="form-group">               
                <button type="submit" class="btn btn-primary" >Atualizar</button>
                <a href="ControllerCentral?ac=cadSalao"><button type="button" class="btn btn-success">Novo Salao</button></a>
            </div>     
        </form>   
    </fieldset>
    <thead>
        <tr>
            <th>Descrição</th>
            <th>Endereço</th>
            <th>Valor Aluguel</th>
            <th>Quantidade de Pessoas</th>
            <th>Ação</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${requestScope.salao.size() == 0}">
            <tr>
                <td class="text-center" colspan="5"> Não há Salão Cadastrados</td>
            </tr> 
        </c:if>

        <c:forEach var="s" items="${requestScope.salao}">
            <tr>
                <td>${s.descricao}</td>
                <td>${s.endereco}</td>
                <td><fmt:setLocale value="pt-BR" /><fmt:formatNumber value="${s.valorAluguel}" minFractionDigits="2" type="currency" /></td>
                <td>${s.quantidadePessoas}</th>
                <td>
                    <a href="ControllerCentral?ac=editSalao&id=${s.id}"><span><i class="fa fa-edit"></i></span></a>
                </td> 
            </tr>
        </c:forEach>                      
    </tbody>          
</table>
