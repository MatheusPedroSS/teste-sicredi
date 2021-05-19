package com.pedro.testesicredi.service;

import java.util.List;
import java.util.Optional;

import com.pedro.testesicredi.model.Pauta;
import com.pedro.testesicredi.repository.PautaRepository;
import com.pedro.testesicredi.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PautaService {
    
    @Autowired
    private PautaRepository repository;

    public Pauta insert(Pauta obj) {
        return repository.save(obj);
    }

    public Pauta find(Integer id) {
        Optional<Pauta> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Error: Pauta não encontrada!"));
    }

    public List<Pauta> findAll() {
        return repository.findAll();
    }
}
