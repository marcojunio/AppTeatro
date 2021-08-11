
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="java.util.List"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="d-flex justify-content-center">
    <div id="cardDados" class="card" style="width: 18rem; font-size: 1.3em">
        <div class="card-header">
           Dados cadastrais
        </div>
        <div class="card-body">                        
            <ul class="list-group">
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Nome do cliente: 
                    <span class="badge badge-primary badge-pill">
                        ${requestScope.usuario.cliente.nome}
                    </span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Usuario: 
                    <span class="badge badge-primary badge-pill">
                        ${requestScope.usuario.login}
                    </span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Documento: 
                    <span class="badge badge-primary badge-pill">
                        ${requestScope.usuario.cliente.documento}
                    </span>
                </li>
                <li class="list-group-item d-flex justify-content-between align-items-center">
                    Idade: 
                    <span class="badge badge-primary badge-pill">
                        ${requestScope.usuario.cliente.idade}
                    </span>
                </li>
            </ul>
        </div>
    </div>
</div>
