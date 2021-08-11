<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1 class="text-center mb-4 display-4">Eventos</h1>
<table class="table table-striped">
    <%if (request.getAttribute("msg") != null) {%>
    <div class="alert alert-success text-center">
        <%= request.getAttribute("msg")%>
    </div>
    <%}%>
    <fieldset>
        <legend>Pesquisar</legend>
        <form action="ControllerCentral" method="GET" > 
            <input type="hidden" name="ac" value="listEvento" />
            <div class="row">
                <div class="col">                  
                    <div class="form-group">                 
                        <label for="evento">Exibir somente Teatros</label> 
                        <select name="ehTeatro" class="form-control">
                            <option value="1">SIM</option>
                            <option value="0">NÃO</option>
                        </select>
                    </div>
                </div>
            </div>
            <div class="form-group">               
                <button type="submit" class="btn btn-primary" >Atualizar</button>
                <a href="ControllerCentral?ac=cadEvento"><button type="button" class="btn btn-success">Novo Evento</button></a>
            </div>     
        </form>   
    </fieldset>
    <thead>
        <tr>
            <th>Descrição</th>
            <th>Máx. Pessoas</th>
            <th>Salão</th>
            <th>Teatro</th>
            <th>Endereço</th>
            <th>Data</th>
            <th>Ação</th>
        </tr>
    </thead>
    <tbody>
        <c:if test="${requestScope.evento.size() == 0}">
            <tr>
                <td class="text-center" colspan="7"> Não há Evento Cadastrados</td>
            </tr> 
        </c:if>

        <c:forEach var="e" items="${requestScope.evento}">
            <tr>
                <td>${e.descricao}</td>
                <td>${e.maxPessoas}</td>
                <td>${e.salao.descricao}</td>
                <td>${e.ehTeatro == true? "SIM" : "NÃO"}</td>
                <td>${e.salao.endereco}</th>
                <td><fmt:formatDate value="${e.dataEvento}"/></th>
                <td>
                    <a href="ControllerCentral?ac=editEvent&id=${e.id}"><span><i class="fa fa-edit"></i></span></a>
                    <a href="#" class="btn-evento" data-toggle="modal" data-target="#modalQuestion" data-id="${e.id}" data-evento="${e.descricao}"><span><i class="fa fa-trash"></i></span></a>
                </td> 
            </tr>
        </c:forEach>                      
    </tbody>          
</table>
<div class="modal fade" id="modalQuestion" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">Confirmar exclusão</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                Deseja excluir o evento <span class="insert-evento"></span> ?
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Cancelar</button>
                <button id="excluirEvento"  type="button" class="btn btn-danger">Excluir</button>
            </div>
        </div>
    </div>
</div>
<script>

    $(".btn-evento").on("click", function (e) {
        $(".insert-evento").html($(e.currentTarget).data("evento"));
        $("#excluirEvento").data("id", $(e.currentTarget).data("id"))
    });

    $("#excluirEvento").on('click', function (e) {
        window.location = "ControllerCentral?ac=deleteEvent&id=" + $(e.currentTarget).data("id");
    })

</script>

