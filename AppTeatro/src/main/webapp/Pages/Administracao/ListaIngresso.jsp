
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center mb-4 display-4">Convites</h1>
<table class="table table-striped">
    <fieldset>
        <legend>Pesquisar</legend>
        <form action="ControllerCentral" method="GET" > 
            <input type="hidden" name="ac" value="listIngresso" />
            <div class="row">
                <div class="col">                  
                    <div class="form-group">                 
                        <label for="convite">Código de Identificação do Cliente (ID)</label> 
                        <input type="number" name="numeroConvite" class="form-control" placeholder="ID"/>  
                    </div>                
                </div>
            </div>
            <div class="form-group">               
                <button type="submit" class="btn btn-primary" >Atualiza</button>
            </div>     
        </form>   
    </fieldset>
    <thead>
        <tr>
            <th>Identificador Cliente</th>
            <th>Descrição Evento</th>
            <th>Valor da compra</th>
            <th>Tipo de ingresso</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${requestScope.ingresso.size() == 0}">
            <tr>
                <td class="text-center" colspan="5"> Não há Ingresso Vendidos</td>
            </tr> 
        </c:if>

        <c:forEach var="i" items="${requestScope.ingresso}">
            <tr>
                <td>${i.cliente.id}</td>
                <td>${i.evento.descricao}</td>
                <td>${i.valor}</td>
                <td>${i.evento}</td>
                <td>${i.tipoConvite}</td>
            </tr>
        </c:forEach>                      
    </tbody>          
</table>