package br.vianna.aula.appteatro.controller.action.User;

import br.vianna.aula.appteatro.controller.action.Login.ViewLoginAction;
import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Cliente;
import br.vianna.aula.appteatro.infrastructure.dao.UsuarioDAO;
import br.vianna.aula.appteatro.domain.entities.Usuario;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewSaveUserAction extends GenericCommander {

    public ViewSaveUserAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Cliente client = new Cliente();
        client.setId(0);
        client.setDocumento(request.getParameter("documentoCliente"));
        client.setIdade(Integer.valueOf(request.getParameter("idadeCliente")));
        client.setNome(request.getParameter("nomeCliente"));
        client.setEndereco(request.getParameter("enderecoCliente"));

        Usuario user = new Usuario();
        user.setId(0);
        user.setLogin(request.getParameter("login"));
        user.setSenha(request.getParameter("senha"));
        user.setIsAdmin(false);
        user.setCliente(client);

        if (UsuarioDAO.existeLogin(user)) {
            request.setAttribute("msg", "Login já existe no sistema");
            user.setLogin("");
            request.setAttribute("user", user);
            new ViewCadastroAction(false).executa(request, response);
        }
        
        UsuarioDAO.getConexao().getTransaction().begin();
        UsuarioDAO.getConexao().persist(client);
        UsuarioDAO.getConexao().getTransaction().commit();

        UsuarioDAO.getConexao().getTransaction().begin();
        UsuarioDAO.getConexao().persist(user);
        UsuarioDAO.getConexao().getTransaction().commit();
        request.setAttribute("msg", "Cliente criado com sucesso.");
        new ViewLoginAction(false).executa(request, response);
    }

}
