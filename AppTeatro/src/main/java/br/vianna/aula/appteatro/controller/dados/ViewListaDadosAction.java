package br.vianna.aula.appteatro.controller.dados;

import br.vianna.aula.appteatro.controller.ingresso.*;
import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Usuario;
import br.vianna.aula.appteatro.infrastructure.dao.UsuarioDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewListaDadosAction extends GenericCommander {

    public ViewListaDadosAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        request.setAttribute("page", "/Pages/Acao/DadosCliente.jsp");
        request.setAttribute("usuario", (Usuario)request.getSession().getAttribute("user"));
        rd.forward(request, response);
    }

}
