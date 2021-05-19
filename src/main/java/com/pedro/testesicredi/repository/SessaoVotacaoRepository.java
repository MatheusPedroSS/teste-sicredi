package com.pedro.testesicredi.repository;

import com.pedro.testesicredi.model.SessaoVotacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacao, Integer> {
    
}
