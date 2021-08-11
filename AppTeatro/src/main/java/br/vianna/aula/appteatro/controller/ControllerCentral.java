package br.vianna.aula.appteatro.controller;

import br.vianna.aula.appteatro.controller.action.Evento.DeleteEventAction;
import br.vianna.aula.appteatro.controller.action.Evento.SaveEventoAction;
import br.vianna.aula.appteatro.controller.action.Evento.ViewCadastroEventoAction;
import br.vianna.aula.appteatro.controller.action.Evento.ViewListaEventoAction;
import br.vianna.aula.appteatro.controller.action.Home.ViewHomeLogadoAction;
import br.vianna.aula.appteatro.controller.action.Login.VerificaLogin;
import br.vianna.aula.appteatro.controller.action.User.ViewCadastroAction;
import br.vianna.aula.appteatro.controller.action.Login.ViewLoginAction;
import br.vianna.aula.appteatro.controller.action.Login.ViewLogoutAction;
import br.vianna.aula.appteatro.controller.action.Relatorio.ViewListaRelatorioAction;
import br.vianna.aula.appteatro.controller.action.User.ViewSaveUserAction;
import br.vianna.aula.appteatro.controller.action.Salao.SaveSalaoAction;
import br.vianna.aula.appteatro.controller.action.Salao.ViewCadastroSalaoAction;
import br.vianna.aula.appteatro.controller.action.Salao.ViewListaSalaoAction;
import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.controller.dados.ViewListaDadosAction;
import br.vianna.aula.appteatro.controller.ingresso.SaveCompraAction;
import br.vianna.aula.appteatro.controller.ingresso.ViewCompraIngressoAction;
import br.vianna.aula.appteatro.controller.ingresso.ViewListaEventosCompra;
import br.vianna.aula.appteatro.controller.services.VerificaDisponibilidadeCadeiraSetor;
import br.vianna.aula.appteatro.controller.action.Home.ViewHomeAction;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControllerCentral", urlPatterns = {"/ControllerCentral"})
public class ControllerCentral extends HttpServlet {

    static HashMap<String, GenericCommander> comandos;

    static {
        comandos = new HashMap<>();
        
        //HomeExterna
        comandos.put(null,new ViewHomeAction(false));
        
        //Usuários
        comandos.put("logar", new ViewLoginAction(false));
        comandos.put("login", new VerificaLogin(false));
        comandos.put("cad", new ViewCadastroAction(false));
        comandos.put("saveUser", new ViewSaveUserAction(false));
        comandos.put("logout", new ViewLogoutAction(true));

        //HomeInterna
        comandos.put("home", new ViewHomeLogadoAction(true));

        //Venda
        comandos.put("compraIngresso", new ViewCompraIngressoAction(true));
        comandos.put("comprar", new SaveCompraAction(true));
        comandos.put("listEventosDisponivel", new ViewListaEventosCompra(true));

        //Evento
        comandos.put("cadEvento", new ViewCadastroEventoAction(true));
        comandos.put("listEvento", new ViewListaEventoAction(true));
        comandos.put("saveEvento", new SaveEventoAction(true));
        comandos.put("editEvent", new ViewCadastroEventoAction(true));
        comandos.put("deleteEvent", new DeleteEventAction(true));

        //Salão
        comandos.put("cadSalao", new ViewCadastroSalaoAction(true));
        comandos.put("ListSalao", new ViewListaSalaoAction(true));
        comandos.put("saveSalao", new SaveSalaoAction(true));
        comandos.put("editSalao", new ViewCadastroSalaoAction(true));

        //Dados
        comandos.put("listDados", new ViewListaDadosAction(true));

        //Relatorio
        comandos.put("listRelatorio", new ViewListaRelatorioAction(true));
        
        //Services
        comandos.put("verifcarDisponibilidade",new VerificaDisponibilidadeCadeiraSetor(true));
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String acao = request.getParameter("ac");

            try {
                if (!comandos.get(acao).isSoExecuteComLogin() || request.getSession().getAttribute("user") != null) {
                    comandos.get(acao).executa(request, response);
                } else {
                    request.setAttribute("msg", "Acesso não autorizado.");
                    new ViewLoginAction(false).executa(request, response);
                }
            } catch (Exception e) {
                RequestDispatcher rd = request.getRequestDispatcher("error.jsp");
                request.setAttribute("error", e.getMessage() == null ? "Requisição inválida." : e.getMessage());
                rd.forward(request, response);
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
