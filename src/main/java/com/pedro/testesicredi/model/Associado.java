package com.pedro.testesicredi.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Associado {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cpf;

    public Associado() {
    }

    public Associado(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public String toString() {
        return "Associado: " 
            + "\nId: " + id
            + "\nCPF: " + cpf
            + "\n" ;
    }
}
