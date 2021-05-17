package com.pedro.testesicredi;

import com.pedro.testesicredi.model.Pauta;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TesteSicrediApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(TesteSicrediApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Pauta p1 = new Pauta("teste1", "Pauta do teste 01");
		System.out.println(p1);
		
	}

}
