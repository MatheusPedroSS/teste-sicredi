package com.pedro.testesicredi.repository;

import com.pedro.testesicredi.model.Pauta;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PautaRepository extends JpaRepository<Pauta, Integer> {
    
}
