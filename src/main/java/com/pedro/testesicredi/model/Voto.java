package com.pedro.testesicredi.model;

import java.util.Date;

import com.pedro.testesicredi.model.enums.VotoEnum;

public class Voto {
    
    private Integer id;
    private VotoEnum voto;
    private Date moment;

    public Voto() {
    }

    public Voto(VotoEnum votoEnum) {
        this.voto = votoEnum;
        this.moment = new Date();
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
