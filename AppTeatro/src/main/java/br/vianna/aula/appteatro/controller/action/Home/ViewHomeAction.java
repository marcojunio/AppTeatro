package br.vianna.aula.appteatro.controller.action.Home;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ViewHomeAction extends GenericCommander{

    public ViewHomeAction(boolean executarComLogin) {
        super(executarComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("Pages/externo/home.jsp");
        
        rd.forward(request, response); 
    }
    
}
