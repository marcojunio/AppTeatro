package br.vianna.aula.appteatro.domain.entities;

import br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "venda")
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(length = 30)
    private String descricao;
    @OneToOne
    @JoinColumn(name = "CLIENTE_ID")
    private Cliente cliente;
    @OneToOne
    @JoinColumn(name = "INGRESSO_ID")
    private Ingresso ingresso;
    @OneToOne
    @JoinColumn(name = "EVENTO_ID")
    private Evento evento;
    private double valorTotal;

    public Venda(long id, String descricao, Cliente cliente, Ingresso ingresso, Evento evento) {
        this.id = id;
        this.descricao = descricao;
        this.cliente = cliente;
        this.ingresso = ingresso;
        this.evento = evento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Venda() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ingresso getIngresso() {
        return ingresso;
    }

    public void setIngresso(Ingresso ingresso) {
        this.ingresso = ingresso;
    }

    public Evento getEvento() {
        return evento;
    }

    public void setEvento(Evento evento) {
        this.evento = evento;
    }

}
