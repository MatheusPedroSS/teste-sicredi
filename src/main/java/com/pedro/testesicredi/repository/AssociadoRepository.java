package com.pedro.testesicredi.repository;

import java.util.Optional;

import com.pedro.testesicredi.model.Associado;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AssociadoRepository extends JpaRepository<Associado, Integer> {
    
    Optional<Associado> findByCpf(String cpf);

}
