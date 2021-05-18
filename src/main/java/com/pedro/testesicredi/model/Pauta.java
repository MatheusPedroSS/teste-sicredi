package com.pedro.testesicredi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Pauta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descricao;
    private Date momentCriacao;

    @OneToOne(mappedBy = "pauta")
    private SessaoVotacao sessaoVotacao;

    public Pauta(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
        this.momentCriacao = new Date();
    }

    public Integer getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
        this.sessaoVotacao = sessaoVotacao;
    }

    @Override
    public String toString() {
        return "Pauta: " 
            + "\nid: " + id 
            + "\nTitulo: " + titulo 
            + "\nDescrição: " + descricao 
            + "\nData Criação: " + momentCriacao
            + "\n";
    }

}
