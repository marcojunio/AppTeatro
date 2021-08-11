package br.vianna.aula.appteatro.domain.entities;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Resposta implements Serializable{
    
    @Id
    private Long id;
    private String link;
    private String descricao;
    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pergunta_id",referencedColumnName = "pergunta_id")
    private Pergunta pergunta;

    public Resposta(Long id, String link, String descricao, Pergunta pergunta) {
        this.id = id;
        this.link = link;
        this.descricao = descricao;
        this.pergunta = pergunta;
    }

    public Resposta() {
    }
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Pergunta getPergunta() {
        return pergunta;
    }

    public void setPergunta(Pergunta pergunta) {
        this.pergunta = pergunta;
    }
    
    
}
