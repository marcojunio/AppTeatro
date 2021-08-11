package br.vianna.aula.appteatro.infrastructure.data.build;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class main {

    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence
                .createEntityManagerFactory("teatroPersistence");
        factory.close();
    }
}
