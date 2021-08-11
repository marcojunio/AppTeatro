package br.vianna.aula.appteatro.controller.ingresso;

import br.vianna.aula.appteatro.controller.commander.GenericCommander;
import br.vianna.aula.appteatro.domain.entities.Cliente;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.IngressoEvento;
import br.vianna.aula.appteatro.domain.entities.IngressoTeatro;
import br.vianna.aula.appteatro.domain.entities.Usuario;
import br.vianna.aula.appteatro.domain.entities.Venda;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso;
import br.vianna.aula.appteatro.domain.entities.enums.EnumTipoConvite;
import br.vianna.aula.appteatro.infrastructure.dao.ClienteDAO;
import br.vianna.aula.appteatro.infrastructure.dao.EventoDAO;
import br.vianna.aula.appteatro.infrastructure.dao.IngressoDAO;

public class SaveCompraAction extends GenericCommander {

    public SaveCompraAction(boolean executarComLogin) {
        super(executarComLogin);
    }

    @Override
    public void executa(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Ingresso ingresso = null;
        Usuario user = (Usuario) request.getSession().getAttribute("user");
        Cliente cliente = ClienteDAO.buscaUsuarioPorId(user.getId());
        Evento evento = EventoDAO.buscarPorId(Integer.valueOf(request.getParameter("evento")));
        Venda venda = new Venda();
        String msg = "";

        if (Double.valueOf(request.getParameter("valorIngresso")) == 0.0 && evento.isEhTeatro() == true) {

            ingresso = new IngressoTeatro();
            ingresso.setTipoConvite(EnumTipoConvite.DOACAO);
            ingresso.setCliente(cliente);
            ingresso.setId(0);
            ingresso.setEvento(evento);
            ((IngressoTeatro) ingresso).setCodigoCadeira(request.getParameter("cadeiraEscolhida"));
            ((IngressoTeatro) ingresso).setSetor(request.getParameter("setorEscolhido"));

            venda.setCliente(cliente);
            venda.setEvento(evento);
            venda.setIngresso(ingresso);
            venda.setDescricao("ENTRADA COM DOACAO DE ALIMENTO");
            venda.setId(0);
            venda.setValorTotal(Double.valueOf(request.getParameter("valorIngresso")));

            IngressoDAO.getConexao().getTransaction().begin();
            IngressoDAO.getConexao().persist(ingresso);
            IngressoDAO.getConexao().getTransaction().commit();

            IngressoDAO.getConexao().getTransaction().begin();
            IngressoDAO.getConexao().persist(venda);
            IngressoDAO.getConexao().getTransaction().commit();

            msg = "Reserva realizada com sucesso, levar 1KG de alimento não perecível!";

        } else if (evento.isEhTeatro() == true && Double.valueOf(request.getParameter("valorIngresso")) > 0) {

            Double valor = null;
            ingresso = new IngressoTeatro();
            Double valorIngresso = Double.valueOf(request.getParameter("valorIngresso"));

            if (request.getParameter("tipoIngresso").equals("meia")) {
                valor = valorIngresso / 2;
                venda.setValorTotal(valor);
                ingresso.setTipoConvite(EnumTipoConvite.MEIA);
                venda.setDescricao("ENTRADA PAGA, MEIA");
                msg = "Compra realizada com sucesso, 50% de desconto no ingresso meia. :D";
            } else {
                valor = valorIngresso;
                venda.setValorTotal(valor);
                ingresso.setTipoConvite(EnumTipoConvite.PAGO);
                venda.setDescricao("ENTRADA PAGA, INTEIRA");
                msg = "Compra realizada com sucesso, ingresso pago integralmente. :D";
            }

            ingresso.setCliente(cliente);
            ingresso.setId(0);
            ingresso.setEvento(evento);
            ((IngressoTeatro) ingresso).setCodigoCadeira(request.getParameter("cadeiraEscolhida"));
            ((IngressoTeatro) ingresso).setSetor(request.getParameter("setorEscolhido"));

            venda.setCliente(cliente);
            venda.setEvento(evento);
            venda.setIngresso(ingresso);

            venda.setId(0);

            IngressoDAO.getConexao().getTransaction().begin();
            IngressoDAO.getConexao().persist(ingresso);
            IngressoDAO.getConexao().getTransaction().commit();

            IngressoDAO.getConexao().getTransaction().begin();
            IngressoDAO.getConexao().persist(venda);
            IngressoDAO.getConexao().getTransaction().commit();

        } else if (Double.valueOf(request.getParameter("valorIngresso")) == 0.0 && evento.isEhTeatro() == false) {

            ingresso = new IngressoEvento();
            ingresso.setTipoConvite(EnumTipoConvite.DOACAO);
            ingresso.setCliente(cliente);
            ingresso.setId(0);
            ingresso.setEvento(evento);

            venda.setCliente(cliente);
            venda.setEvento(evento);
            venda.setIngresso(ingresso);
            venda.setDescricao("ENTRADA COM DOACAO DE ALIMENTO");
            venda.setId(0);
            venda.setValorTotal(Double.valueOf(request.getParameter("valorIngresso")));

            IngressoDAO.getConexao().getTransaction().begin();
            IngressoDAO.getConexao().persist(ingresso);
            IngressoDAO.getConexao().getTransaction().commit();

            IngressoDAO.getConexao().getTransaction().begin();
            IngressoDAO.getConexao().persist(venda);
            IngressoDAO.getConexao().getTransaction().commit();

            msg = "Reserva realizada com sucesso, levar 1KG de alimento não perecível!";

        } else {
            Double valor = null;
            ingresso = new IngressoEvento();
            Double valorIngresso = Double.valueOf(request.getParameter("valorIngresso"));

            if (request.getParameter("tipoIngresso").equals("meia")) {
                valor = valorIngresso / 2;
                venda.setValorTotal(valor);
                ingresso.setTipoConvite(EnumTipoConvite.MEIA);
                venda.setDescricao("ENTRADA PAGA, MEIA");
                msg = "Compra realizada com sucesso, 50% de desconto no ingresso meia. :D";
            } else {
                valor = valorIngresso;
                venda.setValorTotal(valor);
                ingresso.setTipoConvite(EnumTipoConvite.PAGO);
                venda.setDescricao("ENTRADA PAGA, INTEIRA");
                msg = "Compra realizada com sucesso, ingresso pago integralmente. :D";
            }

            ingresso.setCliente(cliente);
            ingresso.setId(0);
            ingresso.setEvento(evento);

            venda.setCliente(cliente);
            venda.setEvento(evento);
            venda.setIngresso(ingresso);

            venda.setId(0);

            IngressoDAO.getConexao().getTransaction().begin();
            IngressoDAO.getConexao().persist(ingresso);
            IngressoDAO.getConexao().getTransaction().commit();

            IngressoDAO.getConexao().getTransaction().begin();
            IngressoDAO.getConexao().persist(venda);
            IngressoDAO.getConexao().getTransaction().commit();
        }

        request.setAttribute("msg", msg);
        new ViewListaEventosCompra(true).executa(request, response);

    }

}
