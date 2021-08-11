package br.vianna.aula.appteatro.infrastructure.dao;

import br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso;
import br.vianna.aula.appteatro.infrastructure.data.DataContext;
import java.util.List;
import javax.persistence.Query;

public class IngressoDAO extends DataContext {

    public static List<Ingresso> buscarIngresso() {

        Query q = getConexao().createQuery("SELECT i from Ingresso i");

        return q.getResultList();
    }

    public static List<Ingresso> buscarPorFiltro(int id) {
        Query q = getConexao().createQuery("SELECT i from Ingresso i where i.cliente.id = :id");
        q.setParameter("id", id);

        return q.getResultList();
    }

    public static boolean verificarAssentoDisponivel(String cadeira, String setor,int idEvento) {
        
        Long resultado = new Long(0L);
        Query q = getConexao().createQuery("SELECT COUNT(it) from IngressoTeatro it "
                + "INNER JOIN Ingresso i ON it.id = i.id "
                + "WHERE i.evento.id = :idEvento and it.codigoCadeira = :codigoCadeira and it.setor = :setor");

        q.setParameter("codigoCadeira", cadeira);
        q.setParameter("setor", setor);
        q.setParameter("idEvento", idEvento);
        
        resultado = (Long) q.getSingleResult();
        
        
        if(resultado.intValue() == 1){
            return false;
        }
        
        return true;
    }

}
