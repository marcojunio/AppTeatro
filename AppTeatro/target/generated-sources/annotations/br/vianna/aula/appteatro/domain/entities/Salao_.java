package br.vianna.aula.appteatro.domain.entities;

import br.vianna.aula.appteatro.domain.entities.Evento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-05-08T20:41:26")
@StaticMetamodel(Salao.class)
public class Salao_ { 

    public static volatile ListAttribute<Salao, Evento> evento;
    public static volatile SingularAttribute<Salao, Double> valorAluguel;
    public static volatile SingularAttribute<Salao, String> endereco;
    public static volatile SingularAttribute<Salao, Long> id;
    public static volatile SingularAttribute<Salao, Integer> quantidadePessoas;
    public static volatile SingularAttribute<Salao, String> descricao;

}