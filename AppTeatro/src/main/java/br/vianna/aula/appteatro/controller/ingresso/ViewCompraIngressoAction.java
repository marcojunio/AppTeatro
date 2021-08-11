package br.vianna.aula.appteatro.controller.ingresso;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.infrastructure.dao.EventoDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCompraIngressoAction extends GenericCommander {

    public ViewCompraIngressoAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        Evento evento = EventoDAO.buscarPorId(Integer.parseInt(request.getParameter("idEvento")));
        
        
        request.setAttribute("teatro", evento.isEhTeatro());
        request.setAttribute("eventoEscolhido", evento);
        request.setAttribute("page", "/Pages/Acao/VendaConvite.jsp");
        rd.forward(request, response);
    }

}
