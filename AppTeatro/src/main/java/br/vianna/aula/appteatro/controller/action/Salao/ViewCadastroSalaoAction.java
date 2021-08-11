package br.vianna.aula.appteatro.controller.action.Salao;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Salao;
import br.vianna.aula.appteatro.infrastructure.dao.SalaoDao;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewCadastroSalaoAction extends GenericCommander {

    public ViewCadastroSalaoAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        String titulo;
        Salao salao = new Salao();

        if (request.getParameter("id") != null) {
            titulo = "Alterar Salão";
            salao = SalaoDao.buscarByID(Integer.parseInt(request.getParameter("id")));
        } else {
            titulo = "Novo Salão";
        }

        request.setAttribute("titulo", titulo);
        request.setAttribute("salao", salao);
        request.setAttribute("page", "Pages/Acao/CadastroSalao.jsp");
        rd.forward(request, response);
    }

}
