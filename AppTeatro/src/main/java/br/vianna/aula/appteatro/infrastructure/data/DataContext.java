package br.vianna.aula.appteatro.infrastructure.data;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DataContext {

    private static EntityManagerFactory entityManagerFactory;
    private static EntityManager entityManager;

    public static void FecharConexao() {
        if (entityManager.isOpen()) {
            entityManager.close();
        }
    }

    public static EntityManager getConexao() {
        if (entityManager == null || !entityManager.isOpen()) {
            entityManagerFactory = Persistence.createEntityManagerFactory("teatroPersistence");
            entityManager = entityManagerFactory.createEntityManager();
        }

        return entityManager;
    }
}
