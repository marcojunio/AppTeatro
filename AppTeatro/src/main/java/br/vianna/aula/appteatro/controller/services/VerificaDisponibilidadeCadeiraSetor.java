package br.vianna.aula.appteatro.controller.services;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.infrastructure.dao.IngressoDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VerificaDisponibilidadeCadeiraSetor extends GenericCommander {

    public VerificaDisponibilidadeCadeiraSetor(boolean executarComLogin) {
        super(executarComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String setor = request.getParameter("setor");
        String cadeira = request.getParameter("cadeira");
        int idEvento = Integer.valueOf(request.getParameter("evento"));
        boolean disponivel = IngressoDAO.verificarAssentoDisponivel(cadeira, setor,idEvento);

        if (disponivel == false) {
            response.setStatus(400);
        } else {
            response.setStatus(200);
        }
    }

}
