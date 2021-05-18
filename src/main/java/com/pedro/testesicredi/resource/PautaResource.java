package com.pedro.testesicredi.resource;

import java.net.URI;
import java.util.List;

import com.pedro.testesicredi.model.Pauta;
import com.pedro.testesicredi.service.PautaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "pauta")
public class PautaResource {
    
    @Autowired
    private PautaService service;

    @PostMapping
    public ResponseEntity addPauta(@RequestBody Pauta obj) {
        Pauta pauta = service.insert(obj);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(pauta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable Integer id) {
        Pauta pauta = service.find(id);
        return ResponseEntity.ok().body(pauta);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Pauta> pautas = service.findAll();
        return ResponseEntity.ok().body(pautas);
    }

}
