package com.pedro.testesicredi.model;

import java.util.Date;

public class SessaoVotacao {
    
    private Integer id;
    private Date timeVotacao;
    private Pauta pauta;

    public SessaoVotacao() {
    }

    public SessaoVotacao(Pauta pauta) {
        this.pauta = pauta;
        this.timeVotacao = new Date();
    }

    @Override
    public String toString() {
        return "Sessão: " 
            + "\nId: " + id
            + "\nPauta: " + pauta
            + "\nTime Votação: " + timeVotacao
            + "\n";
    }
    
}
