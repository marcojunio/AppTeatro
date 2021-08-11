package br.vianna.aula.appteatro.infrastructure.dao;

import br.vianna.aula.appteatro.domain.entities.Cliente;
import br.vianna.aula.appteatro.infrastructure.data.DataContext;
import javax.persistence.Query;

public class ClienteDAO extends DataContext {

    public static Cliente buscaUsuarioPorId(int id) {

        Query q = getConexao().createQuery("SELECT c FROM Cliente c "
                + "INNER JOIN Usuario u ON u.cliente.id = c.id "
                + "WHERE u.id = :id ");

        q.setParameter("id", id);

        return (Cliente) q.getSingleResult();
    }
}
