package br.vianna.aula.appteatro.domain.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "pergunta_tb")
public class Pergunta implements Serializable {
    
    @Id
    private Long id;
    private String texto;
    private Date date;
    @OneToOne(mappedBy = "pergunta")
    private Resposta resposta;

    public Pergunta(Long id, String texto, Date date, Resposta resposta) {
        this.id = id;
        this.texto = texto;
        this.date = date;
        this.resposta = resposta;
    }

    public Pergunta() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Resposta getResposta() {
        return resposta;
    }

    public void setResposta(Resposta resposta) {
        this.resposta = resposta;
    }
    
    
}
