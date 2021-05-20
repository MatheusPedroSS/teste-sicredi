package com.pedro.testesicredi.service;

import java.util.List;
import java.util.Optional;

import com.pedro.testesicredi.model.Voto;
import com.pedro.testesicredi.repository.VotoRepository;
import com.pedro.testesicredi.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VotoService {
    
    @Autowired
    private VotoRepository repository;

    public Voto insert(Voto obj) {
        return repository.save(obj);
    }

    public Voto find(Integer id) {
        Optional<Voto> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Error: Voto não encontrado!"));
    }

    public List<Voto> findAll() {
        return repository.findAll();
    }
}
