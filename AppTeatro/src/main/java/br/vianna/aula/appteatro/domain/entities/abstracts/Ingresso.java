package br.vianna.aula.appteatro.domain.entities.abstracts;

import br.vianna.aula.appteatro.domain.entities.Cliente;
import br.vianna.aula.appteatro.domain.entities.Evento;
import br.vianna.aula.appteatro.domain.entities.enums.EnumTipoConvite;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table
public abstract class Ingresso implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "EVENTO_ID")
    private Evento evento;
    @Column(length = 10)
    @Enumerated(EnumType.STRING)
    private EnumTipoConvite tipoConvite;

    public Ingresso() {
    }

    public Ingresso(Cliente cliente, Evento evento, EnumTipoConvite tipoConvite) {
        this.cliente = cliente;
        this.evento = evento;
        this.tipoConvite = tipoConvite;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

    public EnumTipoConvite getTipoConvite() {
        return tipoConvite;
    }

    public void setTipoConvite(EnumTipoConvite tipoConvite) {
        this.tipoConvite = tipoConvite;
    }
}
