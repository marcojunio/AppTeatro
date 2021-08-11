/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.appteatro.domain.entities.dto;

import java.util.Date;

/**
 *
 * @author marco
 */
public class PesquisaDto {
    
    private Long perguntaId;
    private String perguntaTexto;
    private Date dataPergunta;
    private String RespostaDescricao;

    public PesquisaDto(Long perguntaId, String perguntaTexto, Date dataPergunta, String RespostaDescricao) {
        this.perguntaId = perguntaId;
        this.perguntaTexto = perguntaTexto;
        this.dataPergunta = dataPergunta;
        this.RespostaDescricao = RespostaDescricao;
    }

    public PesquisaDto() {
    }

    public Long getPerguntaId() {
        return perguntaId;
    }

    public void setPerguntaId(Long perguntaId) {
        this.perguntaId = perguntaId;
    }

    public String getPerguntaTexto() {
        return perguntaTexto;
    }

    public void setPerguntaTexto(String perguntaTexto) {
        this.perguntaTexto = perguntaTexto;
    }

    public Date getDataPergunta() {
        return dataPergunta;
    }

    public void setDataPergunta(Date dataPergunta) {
        this.dataPergunta = dataPergunta;
    }

    public String getRespostaDescricao() {
        return RespostaDescricao;
    }

    public void setRespostaDescricao(String RespostaDescricao) {
        this.RespostaDescricao = RespostaDescricao;
    }
    
    
}
