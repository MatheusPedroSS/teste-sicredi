package com.pedro.testesicredi.model;

public class Associado {
    
    private Integer id;
    private Long cpf;

    public Associado() {
    }

    public Associado(Long cpf) {
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
