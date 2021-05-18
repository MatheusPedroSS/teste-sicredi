package com.pedro.testesicredi.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.pedro.testesicredi.model.enums.VotoEnum;

@Entity
public class Voto {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private VotoEnum voto;
    private Date moment;

    @ManyToOne
    private Associado associado;

    public Voto() {
    }

    public Voto(VotoEnum votoEnum) {
        this.voto = votoEnum;
        this.moment = new Date();
    }

    public void setAssociado(Associado associado) {
        this.associado = associado;
    }

    @Override
    public String toString() {
        return "Voto: " 
            + "\nId: " + id
            + "\nVoto: " + voto
            + "\nMoment: " + moment
            + "\n";
    }

}
