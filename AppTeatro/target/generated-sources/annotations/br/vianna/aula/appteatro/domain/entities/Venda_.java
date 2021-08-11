package br.vianna.aula.appteatro.domain.entities;

import br.vianna.aula.appteatro.domain.entities.Cliente;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-05-08T20:41:26")
@StaticMetamodel(Venda.class)
public class Venda_ { 

    public static volatile SingularAttribute<Venda, Cliente> cliente;
    public static volatile SingularAttribute<Venda, Evento> evento;
    public static volatile SingularAttribute<Venda, Double> valorTotal;
    public static volatile SingularAttribute<Venda, Ingresso> ingresso;
    public static volatile SingularAttribute<Venda, Long> id;
    public static volatile SingularAttribute<Venda, String> descricao;

}