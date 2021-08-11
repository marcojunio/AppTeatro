package br.vianna.aula.appteatro.controller.action.Login;

import br.vianna.aula.appteatro.controller.action.Home.ViewHomeLogadoAction;
import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.infrastructure.dao.UsuarioDAO;
import br.vianna.aula.appteatro.domain.entities.Usuario;
import java.io.IOException;
import java.rmi.ServerException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "VerificaLogin", urlPatterns = {"/VerificaLogin"})
public class VerificaLogin extends GenericCommander {

    public VerificaLogin(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        try {

            String email = request.getParameter("login");
            String senha = request.getParameter("senha");
            Usuario u = new UsuarioDAO().verifiyUser(email, senha);

            if (u != null) {
                Usuario user = new Usuario();
                user.setCliente(u.getCliente());
                user.setId(u.getId());
                user.setLogin(u.getLogin());
                user.setSenha(u.getSenha());
                user.setIsAdmin(u.IsAdmin());
                 
                request.getSession().setAttribute("tipoUser", u.IsAdmin());
                request.getSession().setAttribute("user", user);
                request.getSession().setAttribute("idadeCliente", u.getCliente().getIdade());
                new ViewHomeLogadoAction(true).executa(request, response);
            } else {
                response.sendRedirect("ControllerCentral?ac=logar&error=1");
            }
        } catch (SQLException ex) {
            throw new ServerException(ex.getMessage());
        }
    }
}
