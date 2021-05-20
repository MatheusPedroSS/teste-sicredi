package com.pedro.testesicredi.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Pauta {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String titulo;
    private String descricao;
    @JsonFormat(pattern = "dd-MM-yy HH:mm:ss")
    private Date momentCriacao;

    @OneToOne(cascade = CascadeType.ALL)
    private SessaoVotacao sessaoVotacao;

    public Pauta() {
    }

    public Pauta(String titulo, String descricao) {
        this.titulo = titulo;
        this.descricao = descricao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Date getMomentCriacao() {
        return momentCriacao;
    }

    public void setMomentCriacao(Date momentCriacao) {
        this.momentCriacao = momentCriacao;
    }

    public SessaoVotacao getSessaoVotacao() {
        return sessaoVotacao;
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
