package com.pedro.testesicredi.model.dao;

import java.util.Date;

import com.pedro.testesicredi.model.SessaoVotacao;

public class SessaoDAO {
    
    private Long momentFinalVotacao;

    public SessaoDAO(){
    }

    public SessaoDAO(Long momentFinalVotacao) {
        this.momentFinalVotacao = momentFinalVotacao;
    }

    public SessaoVotacao sessaoDAOToClass () {
        Date timerFinalVota = new Date(new Date().getTime() + momentFinalVotacao);
        return new SessaoVotacao(timerFinalVota);
    }

    public Long getMomentFinalVotacao() {
        return momentFinalVotacao;
    }

    public void setMomentFinalVotacao(Long momentFinalVotacao) {
        this.momentFinalVotacao = momentFinalVotacao;
    }
}
