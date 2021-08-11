package br.vianna.aula.appteatro.controller.action.Evento;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.Salao;
import br.vianna.aula.appteatro.infrastructure.dao.EventoDAO;
import br.vianna.aula.appteatro.infrastructure.dao.SalaoDao;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCadastroEventoAction extends GenericCommander {

    public ViewCadastroEventoAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String data = "";
        
        List<Salao> saloes = SalaoDao.buscarTodosSaloes();
        String titulo;
        Evento evento = new Evento();

        if (request.getParameter("id") != null) {
            titulo = "Alterar Evento";
            evento = EventoDAO.buscarPorId(Integer.parseInt(request.getParameter("id")));
            data = sdf.format(evento.getDataEvento());
            request.setAttribute("data",data);
        } else {
            titulo = "Novo Evento";
        }

        request.setAttribute("evento", evento);
        request.setAttribute("data",data);
        request.setAttribute("titulo", titulo);
        request.setAttribute("saloes", saloes);
        request.setAttribute("page", "Pages/Acao/CadastroEvento.jsp");
        rd.forward(request, response);
    }

}
