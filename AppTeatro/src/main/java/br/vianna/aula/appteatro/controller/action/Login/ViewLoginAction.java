package br.vianna.aula.appteatro.controller.action.Login;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewLoginAction extends GenericCommander{

    public ViewLoginAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("Pages/Login/Login.jsp");
        rd.forward(request, response);
    }
}
