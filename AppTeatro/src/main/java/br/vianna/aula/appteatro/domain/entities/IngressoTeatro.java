package br.vianna.aula.appteatro.domain.entities;

import br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ingresso_teatro")
@PrimaryKeyJoinColumn(name="pk_ingresso_teatro",referencedColumnName = "id")
public class IngressoTeatro extends Ingresso implements Serializable {

    private String setor;
    @Column(length = 10)
    private String codigoCadeira;

    public IngressoTeatro() {
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public String getCodigoCadeira() {
        return codigoCadeira;
    }

    public void setCodigoCadeira(String codigoCadeira) {
        this.codigoCadeira = codigoCadeira;
    }
}
