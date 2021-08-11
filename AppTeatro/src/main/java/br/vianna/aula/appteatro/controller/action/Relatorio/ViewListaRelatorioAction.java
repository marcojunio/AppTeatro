package br.vianna.aula.appteatro.controller.action.Relatorio;

import br.vianna.aula.appteatro.domain.entities.dto.relatorios.RelatorioDTO;
import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.infrastructure.dao.SalaoDao;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ViewListaRelatorioAction extends GenericCommander {

    public ViewListaRelatorioAction(boolean isLogado) {
        super(isLogado);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd = request.getRequestDispatcher("template.jsp");

        List<RelatorioDTO> relatorio = null;
        
        
        if(request.getParameter("dtInicial") == null && request.getParameter("dtFinal") == null){
            relatorio = SalaoDao.buscaRelatorio();
        }else if(!request.getParameter("dtInicial").equals("") && !request.getParameter("dtFinal").equals("")){
            relatorio = SalaoDao.buscaRelatorioPorFiltro(request.getParameter("dtInicial"),request.getParameter("dtFinal"));
        }else{
            relatorio = SalaoDao.buscaRelatorio();
        }
        
        BigDecimal total = BigDecimal.ZERO;
        for(RelatorioDTO r : relatorio){
            total = total.add(new BigDecimal(r.total()));
        }
        
        request.setAttribute("relatorio", relatorio);
        request.setAttribute("total", total);
        request.setAttribute("page", "/Pages/Administracao/ListaRelatorio.jsp");
        rd.forward(request, response);
    }
}
