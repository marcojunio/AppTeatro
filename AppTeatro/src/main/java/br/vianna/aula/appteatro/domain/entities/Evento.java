package br.vianna.aula.appteatro.domain.entities;

import br.vianna.aula.appteatro.domain.entities.abstracts.Ingresso;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "evento")
public class Evento implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @OneToMany(mappedBy = "evento")
    private List<Ingresso> ingressos;
    @Column(length = 40)
    private String descricao;
    private Date dataEvento;
    private double valorIngresso;
    @ManyToOne
    @JoinColumn(name = "SALAO_ID", nullable = false)
    private Salao salao;
    private double valorDaLimpeza;
    private double valorDaLuz;
    private boolean ehTeatro;
    private int maxPessoas;

    public Evento() {
    }

    public Date getDataEvento() {
        return dataEvento;
    }

    public int getMaxPessoas() {
        return maxPessoas;
    }

    public void setMaxPessoas(int maxPessoas) {
        this.maxPessoas = maxPessoas;
    }

    public void setDataEvento(Date dataEvento) {
        this.dataEvento = dataEvento;
    }

    public double getValorIngresso() {
        return valorIngresso;
    }

    public void setValorIngresso(double valorIngresso) {
        this.valorIngresso = valorIngresso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Ingresso> getIngressos() {
        return ingressos;
    }

    public void setIngressos(List<Ingresso> ingressos) {
        this.ingressos = ingressos;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Salao getSalao() {
        return salao;
    }

    public void setSalao(Salao salao) {
        this.salao = salao;
    }

    public double getValorDaLimpeza() {
        return valorDaLimpeza;
    }

    public void setValorDaLimpeza(double valorDaLimpeza) {
        this.valorDaLimpeza = valorDaLimpeza;
    }

    public double getValorDaLuz() {
        return valorDaLuz;
    }

    public void setValorDaLuz(double valorDaLuz) {
        this.valorDaLuz = valorDaLuz;
    }

    public boolean isEhTeatro() {
        return ehTeatro;
    }

    public void setEhTeatro(boolean ehTeatro) {
        this.ehTeatro = ehTeatro;
    }
}
