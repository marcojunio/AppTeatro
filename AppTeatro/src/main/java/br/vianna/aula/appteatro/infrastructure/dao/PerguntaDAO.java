/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.vianna.aula.appteatro.infrastructure.dao;

import br.vianna.aula.appteatro.domain.entities.Pergunta;
import br.vianna.aula.appteatro.infrastructure.data.DataContext;
import java.util.List;
import javax.persistence.Query;

/**
 *
 * @author marco
 */
public class PerguntaDAO extends DataContext {

    private String src = "br.vianna.aula.appteatro.domain.entities.dto.";

    public List<Pergunta> getAllPerguntas() {

        Query q = getConexao().createQuery("SELECT NEW "
                + "" + src + "PesquisaDto(p.id,p.texto,p.date,p.resposta.descricao) "
                + "FROM Pergunta p");

        return q.getResultList();
    }

}
