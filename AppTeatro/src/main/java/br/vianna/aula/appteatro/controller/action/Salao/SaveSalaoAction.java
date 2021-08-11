package br.vianna.aula.appteatro.controller.action.Salao;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Salao;
import br.vianna.aula.appteatro.infrastructure.dao.SalaoDao;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SaveSalaoAction extends GenericCommander {

    public SaveSalaoAction(boolean executarComLogin) {
        super(executarComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Salao salao = new Salao();
        String msg = "";
        int id = Integer.valueOf(request.getParameter("idSalao"));
        
         if (id == 0){

            SalaoDao.getConexao().getTransaction().begin();

            salao.setId(0);
            salao.setDescricao(request.getParameter("descricao"));
            salao.setEndereco(request.getParameter("endereco"));
            salao.setValorAluguel(Double.valueOf(request.getParameter("valorAluguel")));
            salao.setQuantidadePessoas(Integer.valueOf(request.getParameter("qtPessoas")));
           
            SalaoDao.getConexao().persist(salao);
            SalaoDao.getConexao().getTransaction().commit();
            msg = "Salão cadastrado com sucesso.";

        } else {
             
            SalaoDao.getConexao().getTransaction().begin();

            salao = SalaoDao.buscarByID(Integer.valueOf(request.getParameter("idSalao")));
            
            salao.setDescricao(request.getParameter("descricao"));
            salao.setEndereco(request.getParameter("endereco"));
            salao.setValorAluguel(Double.valueOf(request.getParameter("valorAluguel")));
            salao.setQuantidadePessoas(Integer.valueOf(request.getParameter("qtPessoas")));
           
            SalaoDao.getConexao().persist(salao);
            SalaoDao.getConexao().getTransaction().commit();
            msg = "Salão Alterado com sucesso.";
         }
        

           
        

        request.setAttribute("msg", msg);

        new ViewCadastroSalaoAction(true).executa(request, response);

    }

}
