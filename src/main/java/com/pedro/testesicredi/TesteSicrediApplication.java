package com.pedro.testesicredi;

import com.pedro.testesicredi.model.Associado;
import com.pedro.testesicredi.model.Pauta;
import com.pedro.testesicredi.model.SessaoVotacao;
import com.pedro.testesicredi.model.Voto;
import com.pedro.testesicredi.model.enums.VotoEnum;
import com.pedro.testesicredi.service.PautaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteSicrediApplication implements CommandLineRunner{
	
	@Autowired
	private PautaService service;

	public static void main(String[] args) {
		SpringApplication.run(TesteSicrediApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Pauta pauta = new Pauta("teste1", "Pauta do teste 01");

		service.insert(pauta);

		SessaoVotacao sessaoVotacao = new SessaoVotacao(60000l);
		sessaoVotacao.setPauta(pauta);

		Associado associado = new Associado("70950585475");

		Voto voto = new Voto(VotoEnum.SIM);
		voto.setAssociado(associado);

		sessaoVotacao.setVoto(voto);

		System.out.println(pauta);
		System.out.println(sessaoVotacao);
		System.out.println(associado);
		System.out.println(voto);
		
	}

}
