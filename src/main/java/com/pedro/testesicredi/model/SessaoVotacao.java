package com.pedro.testesicredi.model;

import java.util.Date;

public class SessaoVotacao {
    
    private Integer id;
    private Date timeVotacao;
    private Pauta pauta;

    public SessaoVotacao() {
    }

    public SessaoVotacao(Pauta pauta, Long tempoVotacao) {
        this.pauta = pauta;
        Date momentAtual = new Date();
        this.timeVotacao = new Date(momentAtual.getTime() + tempoVotacao);
    }

    @Override
    public String toString() {
        return "Sessão Votação: " 
            + "\nId: " + id
            + "\nPauta: " + pauta.getTitulo()
            + "\nTime Votação: " + timeVotacao
            + "\n";
    }
    
}
