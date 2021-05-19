package com.pedro.testesicredi.resource;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.pedro.testesicredi.model.Pauta;
import com.pedro.testesicredi.model.SessaoVotacao;
import com.pedro.testesicredi.service.PautaService;
import com.pedro.testesicredi.service.SessaoVotacaoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "pauta")
public class PautaResource {
    
    @Autowired
    private PautaService pautaService;

    @Autowired
    private SessaoVotacaoService sessaoService;

    @PostMapping
    public ResponseEntity addPauta(@RequestBody Pauta obj) {
        obj.setMomentCriacao(new Date());
        Pauta pauta = pautaService.insert(obj);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(pauta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("/{id}/abrirSessao")
    public ResponseEntity abrirSessao(@PathVariable Integer id, @RequestParam(value = "time") Long timeVotacao) {
        Pauta pauta = pautaService.find(id);
        if (timeVotacao < 60000l) {
            timeVotacao = 60000l;
        }
        SessaoVotacao sessao = sessaoService.insert(new SessaoVotacao(new Date(new Date().getTime() + timeVotacao)));
        pauta.setSessaoVotacao(sessao);
        pautaService.insert(pauta);
        return ResponseEntity.ok().body(sessao);
    }

    @GetMapping("/{id}")
    public ResponseEntity find(@PathVariable Integer id) {
        Pauta pauta = pautaService.find(id);
        return ResponseEntity.ok().body(pauta);
    }

    @GetMapping
    public ResponseEntity findAll() {
        List<Pauta> pautas = pautaService.findAll();
        return ResponseEntity.ok().body(pautas);
    }

}
