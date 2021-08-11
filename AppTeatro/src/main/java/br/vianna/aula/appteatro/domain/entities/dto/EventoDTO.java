package br.vianna.aula.appteatro.domain.entities.dto;

import java.util.Date;

public class EventoDTO {

    private long id;
    private String descricaoSalao;
    private boolean ehTeatro;
    private String descricaoEvento;
    private String endereco;
    private Date dtInicio;

    public EventoDTO(long id, String descricaoSalao, boolean ehTeatro, String descricaoEvento, String endereco, Date dtInicio) {
        this.id = id;
        this.descricaoSalao = descricaoSalao;
        this.ehTeatro = ehTeatro;
        this.descricaoEvento = descricaoEvento;
        this.endereco = endereco;
        this.dtInicio = dtInicio;
    }

    public EventoDTO() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricaoSalao() {
        return descricaoSalao;
    }

    public void setDescricaoSalao(String descricaoSalao) {
        this.descricaoSalao = descricaoSalao;
    }

    public boolean isEhTeatro() {
        return ehTeatro;
    }

    public void setEhTeatro(boolean ehTeatro) {
        this.ehTeatro = ehTeatro;
    }

    public String getDescricaoEvento() {
        return descricaoEvento;
    }

    public void setDescricaoEvento(String descricaoEvento) {
        this.descricaoEvento = descricaoEvento;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDtInicio() {
        return dtInicio;
    }

    public void setDtInicio(Date dtInicio) {
        this.dtInicio = dtInicio;
    }

}
