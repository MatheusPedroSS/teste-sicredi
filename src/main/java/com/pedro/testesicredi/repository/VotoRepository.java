package com.pedro.testesicredi.repository;

import com.pedro.testesicredi.model.Voto;

import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<Voto, Integer> {
    
}
