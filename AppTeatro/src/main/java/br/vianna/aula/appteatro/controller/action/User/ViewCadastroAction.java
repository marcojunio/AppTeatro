package br.vianna.aula.appteatro.controller.action.User;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewCadastroAction extends GenericCommander {

    public ViewCadastroAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("Pages/Login/Cadastro.jsp");
        rd.forward(request, response);
    }

}
