package com.pedro.testesicredi.service;

import java.util.List;
import java.util.Optional;

import com.pedro.testesicredi.model.Associado;
import com.pedro.testesicredi.repository.AssociadoRepository;
import com.pedro.testesicredi.service.exception.ObjectNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AssociadoService {
    
    @Autowired
    private AssociadoRepository repository;

    public Associado insert(Associado obj) {
        return repository.save(obj);
    }

    public Associado find(Integer id) {
        Optional<Associado> obj = repository.findById(id);
        return obj.orElseThrow(() -> new ObjectNotFoundException("Error: Associado não encontrado!"));
    }

    public Optional<Associado> findByCpf(String cpf) {
        Optional<Associado> associado = repository.findByCpf(cpf);
        return associado;
    }

    public List<Associado> findAll() {
        return repository.findAll();
    }
}
