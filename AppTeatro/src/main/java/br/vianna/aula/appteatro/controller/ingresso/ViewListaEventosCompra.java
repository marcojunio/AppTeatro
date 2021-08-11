package br.vianna.aula.appteatro.controller.ingresso;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.dto.EventoDTO;
import br.vianna.aula.appteatro.infrastructure.dao.EventoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewListaEventosCompra extends GenericCommander {

    public ViewListaEventosCompra(boolean executarComLogin) {
        super(executarComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        List<EventoDTO> eventos = EventoDAO.buscarEventosDisponiveis();

        request.setAttribute("eventos", eventos);
        request.setAttribute("page", "/Pages/Acao/ListaEventosIngresso.jsp");
        rd.forward(request, response);
    }
}
