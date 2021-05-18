package com.pedro.testesicredi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class SessaoVotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Date timeVotacao;

    @OneToOne(cascade = CascadeType.ALL)
    private Pauta pauta;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "sessao_id")
    private Set<Voto> votos = new HashSet<>();

    public SessaoVotacao() {
    }

    public SessaoVotacao(Long tempoVotacao) {
        Date momentAtual = new Date();
        this.timeVotacao = new Date(momentAtual.getTime() + tempoVotacao);
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public void setVoto(Voto voto){
        votos.add(voto);
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
