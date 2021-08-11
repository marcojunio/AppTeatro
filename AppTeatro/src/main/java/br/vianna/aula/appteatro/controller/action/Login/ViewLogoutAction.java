package br.vianna.aula.appteatro.controller.action.Login;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewLogoutAction extends GenericCommander{

    public ViewLogoutAction(boolean soExecuteComLogin) {
        super(soExecuteComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {   
        request.getSession().invalidate();
        response.sendRedirect("ControllerCentral");    
    }
}
