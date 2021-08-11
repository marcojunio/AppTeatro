package br.vianna.aula.appteatro.infrastructure.dao;

import br.vianna.aula.appteatro.domain.entities.Usuario;
import br.vianna.aula.appteatro.infrastructure.data.DataContext;
import java.sql.SQLException;
import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;

public class UsuarioDAO extends DataContext{
    
    public static boolean existeLogin(Usuario user) {
        Query q = getConexao().createQuery("select count(u) from Usuario u where u.login = :log ");
        q.setParameter("log", user.getLogin());
        return (long)q.getSingleResult() >= 1; 
    }
    
    public Usuario verifiyUser(String login, String senha) throws SQLException{
        Query q = getConexao().createQuery("select u from Usuario u where "
                + "u.login = :login and u.senha = :senha");
        q.setParameter("login", login);
        q.setParameter("senha", senha);
        
        try {
            return (Usuario) q.getSingleResult(); 
        } catch (NonUniqueResultException e) {
            throw new SQLException("foi encontrado 2 usuários no banco, contate o administrador");
        } catch (NoResultException e){
            return null;
        }           
    }
    
}
