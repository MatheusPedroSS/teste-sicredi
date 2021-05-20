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
    private Integer votosSim;
    private Integer votosNao;

    @OneToOne(cascade = CascadeType.ALL)
    private SessaoVotacao sessaoVotacao;

    public Pauta() {
        votosSim = 0;
        votosNao = 0;
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

    public String getResultado() {
        for(Voto v : sessaoVotacao.getVotos()){
            if(v.getVoto().toString() == "SIM") {
                setVotosSim();
            } else if (v.getVoto().toString() == "NAO") {
                setVotosNao();
            }
        }

        if(votosNao == null || votosSim == null || (votosSim + votosNao == 0)) {
            return "Sem votos";
        }
        else if(votosSim > votosNao) {
            return "Pauta Aprovada!";
        }
        else if(votosNao > votosSim) {
            return "Pauta Reprovada!";
        } else {
            return "Empate!";
        }
    }

    public SessaoVotacao getSessaoVotacao() {
        return sessaoVotacao;
    }

    public void setSessaoVotacao(SessaoVotacao sessaoVotacao) {
        this.sessaoVotacao = sessaoVotacao;
    }

    public Integer getVotosSim() {
        return votosSim;
    }

    public void setVotosSim() {
        votosSim += 1;
    }

    public Integer getVotosNao() {
        return votosNao;
    }

    public void setVotosNao() {
        votosNao += 1;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Pauta other = (Pauta) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
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
