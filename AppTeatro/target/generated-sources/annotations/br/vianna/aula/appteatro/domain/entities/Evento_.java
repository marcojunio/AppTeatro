package br.vianna.aula.appteatro.domain.entities;

import br.vianna.aula.appteatro.domain.entities.Salao;
import br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-05-08T20:41:26")
@StaticMetamodel(Evento.class)
public class Evento_ { 

    public static volatile SingularAttribute<Evento, Date> dataEvento;
    public static volatile SingularAttribute<Evento, Double> valorIngresso;
    public static volatile SingularAttribute<Evento, Double> valorDaLimpeza;
    public static volatile SingularAttribute<Evento, Boolean> ehTeatro;
    public static volatile SingularAttribute<Evento, Long> id;
    public static volatile ListAttribute<Evento, Ingresso> ingressos;
    public static volatile SingularAttribute<Evento, Salao> salao;
    public static volatile SingularAttribute<Evento, Double> valorDaLuz;
    public static volatile SingularAttribute<Evento, Integer> maxPessoas;
    public static volatile SingularAttribute<Evento, String> descricao;

}