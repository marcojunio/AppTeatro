package br.vianna.aula.appteatro.domain.entities;

import br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ingresso_evento")
@PrimaryKeyJoinColumn(name="pk_ingresso_evento",referencedColumnName = "id")
public class IngressoEvento extends Ingresso implements Serializable {

    public IngressoEvento() {
    }

}
