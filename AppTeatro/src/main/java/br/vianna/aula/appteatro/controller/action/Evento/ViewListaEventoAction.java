package br.vianna.aula.appteatro.controller.action.Evento;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.infrastructure.dao.EventoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewListaEventoAction extends GenericCommander {

    public ViewListaEventoAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        List<Evento> eventos = null;
        if (request.getParameter("ehTeatro") == null) {
            eventos = EventoDAO.buscarEventos();
        } else if (request.getParameter("ehTeatro").contains("1")) {
            boolean ehTeatro = request.getParameter("ehTeatro").contains("1") ? true : false;
            eventos = EventoDAO.buscarEventosPorFiltro(ehTeatro);
        } else {
            eventos = EventoDAO.buscarEventos();
        }

        request.setAttribute("page", "/Pages/Administracao/ListaEvento.jsp");
        request.setAttribute("evento", eventos);
        rd.forward(request, response);
    }
}
