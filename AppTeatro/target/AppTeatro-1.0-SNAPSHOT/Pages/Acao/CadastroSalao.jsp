<%@page import="br.vianna.aula.appteatro.domain.entities.Salao"%>
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
                    <h4 class="card-title text-center">Salão</h4>
                    <form method="POST" action="ControllerCentral">
                        <input type="hidden" name="ac" value="saveSalao"/>
                        <input type="hidden" name="idSalao" value="${requestScope.salao.id}"/>
                        <div class="row">
                            <label for="descricao">Descrição</label>
                            <input required id="descricao" type="text" class="form-control mb-3" name="descricao" value="${requestScope.salao.descricao}"/>
                        </div>
                        <div class="row">
                            <div class="form-group mr-2">
                                <label for="endereco">Endereco</label>
                                <input required id="endereco" type="text" class="form-control" name="endereco" value="${requestScope.salao.endereco}"/>
                            </div>
                            <div class="form-group">
                                <label for="valorAluguel">Valor Aluguel</label>
                                <input required id="valorAluguel" type="text" class="form-control" name="valorAluguel" value="${requestScope.salao.valorAluguel}"/>
                            </div>
                            <div class="form-group">
                                <label for="qtPessoas">Quantidade de Pessoas</label>
                                <input required id="qtPessoas" type="text" class="form-control" name="qtPessoas" value="${requestScope.salao.quantidadePessoas}"/>
                            </div>  
                        </div>
                        <div class="form-group mt-4">
                            <button type="submit" class="btn btn-primary">
                                Cadastrar
                            </button>
                            <a href="ControllerCentral?ac=ListSalao"><button class="btn btn-primary" type="button">Voltar</button></a>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<script>
</script>
