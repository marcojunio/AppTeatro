package br.vianna.aula.appteatro.infrastructure.dao;

import br.vianna.aula.appteatro.domain.entities.dto.relatorios.RelatorioDTO;
import br.vianna.aula.appteatro.domain.entities.Salao;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.Venda;
import br.vianna.aula.appteatro.infrastructure.data.DataContext;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.Query;

public class SalaoDao extends DataContext {

    public static List<Salao> buscarTodosSaloes() {

        Query q = getConexao().createQuery("SELECT s FROM Salao s");

        List<Salao> saloes = q.getResultList();

        return saloes;
    }

    public static Salao buscarByID(int id) {

        Query q = getConexao().createQuery("SELECT s from Salao s WHERE s.id = :id");
        q.setParameter("id", id);

        return (Salao) q.getSingleResult();
    }

    public static List<Salao> buscarPorFiltro(String descricao) {

        Query q = getConexao().createQuery("SELECT s from Salao s WHERE s.descricao like :descricao");
        q.setParameter("descricao", "%" + descricao + "%");

        return q.getResultList();
    }

    public static List<RelatorioDTO> buscaRelatorio() {
        Query q = getConexao().createQuery("SELECT new br.vianna.aula.appteatro.domain.entities.dto.relatorios.RelatorioDTO(e.descricao,e.valorDaLimpeza,e.valorDaLuz,e.salao.descricao,e.salao.valorAluguel,SUM(v.valorTotal)) from Evento e "
                + "INNER JOIN Venda v ON e.id = v.evento.id WHERE e.dataEvento >= CURRENT_DATE GROUP BY e.id ORDER BY e.dataEvento DESC");
        return q.getResultList();
    }

    public static List<RelatorioDTO> buscaRelatorioPorFiltro(String dtInicio, String dtFinal){
        
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd"); 
        
        Query q = getConexao().createQuery("SELECT new br.vianna.aula.appteatro.domain.entities.dto.relatorios.RelatorioDTO(e.descricao,e.valorDaLimpeza,e.valorDaLuz,e.salao.descricao,e.salao.valorAluguel,SUM(v.valorTotal)) from Evento e "
                + "INNER JOIN Venda v ON e.id = v.evento.id "
                + "WHERE e.dataEvento >= :dtInicial and e.dataEvento <= :dtFinal "
                + "GROUP BY e.id ORDER BY e.dataEvento DESC");
        
        try {
            q.setParameter("dtInicial", sdf.parse(dtInicio));
        } catch (ParseException ex) {
            Logger.getLogger(SalaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            q.setParameter("dtFinal", sdf.parse(dtFinal));
        } catch (ParseException ex) {
            Logger.getLogger(SalaoDao.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        return q.getResultList();
    }

}
