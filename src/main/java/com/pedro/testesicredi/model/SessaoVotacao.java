package com.pedro.testesicredi.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class SessaoVotacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @JsonFormat(pattern = "dd-MM-yy HH:mm:ss")
    private Date finalTimerVotacao;

    @JsonIgnore
    @OneToOne(mappedBy = "sessaoVotacao")
    private Pauta pauta;

    @ManyToMany
    @JoinTable(
        name = "sessao_votacao_voto",
        joinColumns = @JoinColumn(name = "sessao_id"),
        inverseJoinColumns = @JoinColumn(name = "voto_id")
    )
    private Set<Voto> votos = new HashSet<>();

    public SessaoVotacao() {
    }

    public SessaoVotacao(Date finalTimerVotacao) {
        this.finalTimerVotacao = finalTimerVotacao;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFinalTimerVotacao() {
        return finalTimerVotacao;
    }

    public void setFinalTimerVotacao(Date finalTimerVotacao) {
        this.finalTimerVotacao = finalTimerVotacao;
    }

    public Pauta getPauta() {
        return pauta;
    }

    public void setPauta(Pauta pauta) {
        this.pauta = pauta;
    }

    public Set<Voto> getVotos() {
        return votos;
    }

    public void setVotos(Voto voto) {
        this.votos.add(voto);
    }

    @Override
    public String toString() {
        return "Sessão Votação: " 
            + "\nId: " + id
            + "\nPauta: " + pauta.getTitulo()
            + "\nFinal Timer Votação: " + finalTimerVotacao
            + "\n";
    }
    
}
