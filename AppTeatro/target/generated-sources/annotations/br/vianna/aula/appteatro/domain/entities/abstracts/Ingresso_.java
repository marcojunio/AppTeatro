package br.vianna.aula.appteatro.domain.entities.abstracts;

import br.vianna.aula.appteatro.domain.entities.Cliente;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.enums.EnumTipoConvite;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.7.7.v20200504-rNA", date="2021-05-08T20:41:26")
@StaticMetamodel(Ingresso.class)
public abstract class Ingresso_ { 

    public static volatile SingularAttribute<Ingresso, Cliente> cliente;
    public static volatile SingularAttribute<Ingresso, Evento> evento;
    public static volatile SingularAttribute<Ingresso, EnumTipoConvite> tipoConvite;
    public static volatile SingularAttribute<Ingresso, Long> id;

}