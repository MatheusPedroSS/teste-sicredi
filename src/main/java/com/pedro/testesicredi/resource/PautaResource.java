package com.pedro.testesicredi.resource;

import java.net.URI;
import java.util.Date;
import java.util.List;

import com.pedro.testesicredi.model.Associado;
import com.pedro.testesicredi.model.Pauta;
import com.pedro.testesicredi.model.SessaoVotacao;
import com.pedro.testesicredi.model.Voto;
import com.pedro.testesicredi.model.enums.VotoEnum;
import com.pedro.testesicredi.service.AssociadoService;
import com.pedro.testesicredi.service.PautaService;
import com.pedro.testesicredi.service.SessaoVotacaoService;
import com.pedro.testesicredi.service.VotoService;

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
@RequestMapping
public class PautaResource {
    
    @Autowired
    private PautaService pautaService;

    @Autowired
    private SessaoVotacaoService sessaoService;

    @Autowired
    private AssociadoService associadoService;

    @Autowired
    private VotoService votoService;

    @PostMapping(value = "pauta")
    public ResponseEntity addPauta(@RequestBody Pauta obj) {
        obj.setMomentCriacao(new Date());
        Pauta pauta = pautaService.insert(obj);
        URI uri = ServletUriComponentsBuilder
            .fromCurrentRequest()
            .path("/{id}")
            .buildAndExpand(pauta.getId()).toUri();
        return ResponseEntity.created(uri).build();
    }

    @PostMapping("pauta/{id}/abrirSessao")
    public ResponseEntity abrirSessao(@PathVariable Integer id, @RequestParam(value = "time") Long timeVotacao) {
        Pauta pauta = pautaService.find(id);
        if (timeVotacao < 60000l) {
            timeVotacao = 60000l;
        }
        if(pauta.getSessaoVotacao() != null) {
            return ResponseEntity.badRequest().body("Só e permitido uma sessão de votação por vez!");
        } 
        SessaoVotacao sessao = sessaoService.insert(new SessaoVotacao(new Date(new Date().getTime() + timeVotacao)));
        pauta.setSessaoVotacao(sessao);
        pautaService.insert(pauta);
        return ResponseEntity.ok().body(sessao);
    }

    @PostMapping("sessao/{idSessao}")
    public ResponseEntity votar(@PathVariable Integer idSessao, @RequestParam(value = "associado") String cpfAss, @RequestParam(value = "voto") String votoAss){
        
        SessaoVotacao sesao = sessaoService.find(idSessao);

        if(associadoService.findByCpf(cpfAss).isEmpty()){
            associadoService.insert(new Associado(cpfAss));
        }

        Associado associado = associadoService.findByCpf(cpfAss).get();

        Voto voto = new Voto(VotoEnum.valueOf(votoAss));
        for(Voto v: sesao.getVotos()) {
            if(v.getAssociado().getCpf() == associado.getCpf()){
                return ResponseEntity.badRequest().body("Só e permitido um voto por Associado!");
            }
        }

        if(sesao.getFinalTimerVotacao().getTime() < new Date().getTime()) {
            return ResponseEntity.badRequest().body("O tempo de Votação acabou!");
        }

        voto.setAssociado(associado);
        sesao.setVotos(voto);

        votoService.insert(voto);

        sessaoService.insert(sesao);

        return ResponseEntity.ok().body("Voto Efetuado!");
    }

    @GetMapping("pauta/{id}")
    public ResponseEntity find(@PathVariable Integer id) {
        Pauta pauta = pautaService.find(id);
        return ResponseEntity.ok().body(pauta);
    }

    @GetMapping("pauta")
    public ResponseEntity findAll() {
        List<Pauta> pautas = pautaService.findAll();
        return ResponseEntity.ok().body(pautas);
    }

}
