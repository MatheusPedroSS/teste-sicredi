package com.pedro.testesicredi.service;

import java.util.List;
import java.util.Optional;

import com.pedro.testesicredi.model.SessaoVotacao;
import com.pedro.testesicredi.repository.SessaoVotacaoRepository;
import com.pedro.testesicredi.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SessaoVotacaoService {
    
    @Autowired
    private SessaoVotacaoRepository repository;

    public SessaoVotacao insert(SessaoVotacao obj) {
        return repository.save(obj);
    }

    public SessaoVotacao find(Integer id) {
        Optional<SessaoVotacao> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Error: Sessão Votação não encontrada!"));
    }

    public List<SessaoVotacao> findAll() {
        return repository.findAll();
    }
}
