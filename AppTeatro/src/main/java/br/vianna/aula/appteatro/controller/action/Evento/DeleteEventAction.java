package br.vianna.aula.appteatro.controller.action.Evento;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Evento;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.vianna.aula.appteatro.infrastructure.dao.EventoDAO;

public class DeleteEventAction extends GenericCommander {

    public DeleteEventAction(boolean executarComLogin) {
        super(executarComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int id = Integer.valueOf(request.getParameter("id"));

        int quantidade = (int) EventoDAO.QuantidadeIngressosVendidosPorEvento(id);

        if (quantidade == 0) {
            EventoDAO.getConexao().getTransaction().begin();
            Evento event = EventoDAO.buscarPorId(id);
            EventoDAO.getConexao().remove(event);
            EventoDAO.getConexao().getTransaction().commit();

            request.setAttribute("msg", "Excluído com sucesso.");
            new ViewListaEventoAction(true).executa(request, response);
        } else {
            request.setAttribute("msg", "Não é possível excluir o evento pois ele já está ativo.");
            new ViewListaEventoAction(true).executa(request, response);
        }

    }

}
