package com.pedro.testesicredi.model;

import java.util.Date;

public class Pauta {
    
    private Integer id;
    private String titulo;
    private String descricao;
    private Date momentCriacao;

    public Pauta() {
    }

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
