package br.vianna.aula.appteatro.infrastructure.dao;

import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.dto.EventoDTO;
import br.vianna.aula.appteatro.infrastructure.data.DataContext;
import java.util.List;
import javax.persistence.Query;

public class EventoDAO extends DataContext {

    public static Evento buscarPorId(int id) {

        Query q = getConexao().createQuery("SELECT e FROM Evento e WHERE e.id = :id");
        q.setParameter("id", id);

        return (Evento) q.getSingleResult();
    }

    public static List<Evento> buscarEventos() {

        Query q = getConexao().createQuery("SELECT e from Evento e");

        return q.getResultList();
    }

    public static List<EventoDTO> buscarEventosDisponiveis() {
        
        Query q = getConexao().createQuery("SELECT new br.vianna.aula.appteatro.domain.entities.dto.EventoDTO(e.id,e.salao.descricao,e.ehTeatro,e.descricao,e.salao.endereco,e.dataEvento) "
                + "from Evento e "
                + "WHERE e.dataEvento >= CURRENT_DATE "
                + "AND e.maxPessoas > (SELECT COUNT(v) FROM Venda v WHERE v.evento.id = e.id)");

        return q.getResultList();
    }

    public static List<Evento> buscarEventosPorFiltro(boolean ehTeatro) {

        Query q = getConexao().createQuery("SELECT e FROM Evento e WHERE e.ehTeatro = :ehTeatro ");

        q.setParameter("ehTeatro", ehTeatro);
        return q.getResultList();

    }

    public static long QuantidadeIngressosVendidosPorEvento(int id) {

        Long quantidade = new Long(0L);
        Query q = getConexao().createQuery("SELECT COUNT(i.id) from Ingresso i WHERE i.evento.id = :id");

        q.setParameter("id", id);

        quantidade = (Long) q.getSingleResult();

        return quantidade;
    }
}
