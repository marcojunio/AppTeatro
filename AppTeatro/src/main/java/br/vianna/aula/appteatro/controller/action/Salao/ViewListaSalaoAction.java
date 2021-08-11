package br.vianna.aula.appteatro.controller.action.Salao;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Salao;
import br.vianna.aula.appteatro.infrastructure.dao.SalaoDao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewListaSalaoAction extends GenericCommander {

    public ViewListaSalaoAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        List<Salao> salao = null;

        if (request.getParameter("descricaoSalao") == null) {
            salao = SalaoDao.buscarTodosSaloes();
        } else if (!request.getParameter("descricaoSalao").equals("")) {
            salao = SalaoDao.buscarPorFiltro(request.getParameter("descricaoSalao"));
        } else {
            salao = SalaoDao.buscarTodosSaloes();
        }

        request.setAttribute("page", "/Pages/Administracao/ListaSalao.jsp");
        request.setAttribute("salao", salao);
        rd.forward(request, response);
    }
}
