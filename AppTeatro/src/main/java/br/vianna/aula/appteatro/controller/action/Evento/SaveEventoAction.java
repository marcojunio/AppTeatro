package br.vianna.aula.appteatro.controller.action.Evento;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.Salao;
import br.vianna.aula.appteatro.infrastructure.dao.EventoDAO;
import br.vianna.aula.appteatro.infrastructure.dao.SalaoDao;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveEventoAction extends GenericCommander {

    public SaveEventoAction(boolean executarComLogin) {
        super(executarComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Evento evento = new Evento();
        String msg = "";
        int id = Integer.valueOf(request.getParameter("idEvento"));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        if (!request.getParameter("salaoSelect").contains("-1") && id == 0) {

            EventoDAO.getConexao().getTransaction().begin();

            evento.setId(0);
            evento.setDescricao(request.getParameter("descricao"));
            evento.setValorDaLimpeza(Double.valueOf(request.getParameter("valorLimpeza")));
            evento.setValorDaLuz(Double.valueOf(request.getParameter("valorLuz")));
            evento.setValorIngresso(Double.valueOf(request.getParameter("valorIngresso")));
            evento.setMaxPessoas(Integer.valueOf(request.getParameter("maxPessoas")));

            try {
                evento.setDataEvento(sdf.parse(request.getParameter("dataEvento")));
            } catch (ParseException ex) {
                Logger.getLogger(SaveEventoAction.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (request.getParameter("ehTeatro").equals("sim")) {
                evento.setEhTeatro(true);
            } else {
                evento.setEhTeatro(false);
            }

            Salao salao = SalaoDao.buscarByID(Integer.valueOf(request.getParameter("salaoSelect")));
            evento.setSalao(salao);

            if (evento.getMaxPessoas() < salao.getQuantidadePessoas()) {
                EventoDAO.getConexao().persist(evento);

                EventoDAO.getConexao().getTransaction().commit();

                msg = "Evento cadastrado com sucesso.";
            } else {
                EventoDAO.getConexao().getTransaction().rollback();
                msg = "O Evento não pode ter mais pessoas do que o suportado pelo salão.";
            }

        } else if (request.getParameter("salaoSelect").contains("-1")) {
            msg = "Não há como cadastrar um evento sem associa-lo a um Salão.";
            EventoDAO.getConexao().getTransaction().rollback();
        } else {
            EventoDAO.getConexao().getTransaction().begin();

            evento = EventoDAO.buscarPorId(Integer.valueOf(request.getParameter("idEvento")));

            evento.setDescricao(request.getParameter("descricao"));
            evento.setValorDaLimpeza(Double.valueOf(request.getParameter("valorLimpeza")));
            evento.setValorDaLuz(Double.valueOf(request.getParameter("valorLuz")));
            evento.setValorIngresso(Double.valueOf(request.getParameter("valorIngresso")));
            evento.setMaxPessoas(Integer.valueOf(request.getParameter("maxPessoas")));

            try {
                evento.setDataEvento(sdf.parse(request.getParameter("dataEvento")));
            } catch (ParseException ex) {
                Logger.getLogger(SaveEventoAction.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (request.getParameter("ehTeatro").equals("sim")) {
                evento.setEhTeatro(true);
            } else {
                evento.setEhTeatro(false);
            }

            Salao salao = SalaoDao.buscarByID(Integer.valueOf(request.getParameter("salaoSelect")));
            evento.setSalao(salao);

            if (evento.getMaxPessoas() < salao.getQuantidadePessoas()) {
                EventoDAO.getConexao().persist(evento);

                EventoDAO.getConexao().getTransaction().commit();

                msg = "Evento alterado com sucesso.";
            } else {
                EventoDAO.getConexao().getTransaction().rollback();
                msg = "O Evento não pode ter mais pessoas do que o suportado pelo salão.";
            }
        }

        request.setAttribute("msg", msg);

        new ViewCadastroEventoAction(true).executa(request, response);

    }

}
