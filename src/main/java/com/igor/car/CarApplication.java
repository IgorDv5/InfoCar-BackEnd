package com.igor.car;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.igor.car.domain.Carro;
import com.igor.car.domain.Pessoa;
import com.igor.car.repositories.CarroRepository;
import com.igor.car.repositories.PessoaRepository;

@SpringBootApplication
public class CarApplication implements CommandLineRunner {

	@Autowired
	private PessoaRepository pessoaRepository;
	@Autowired
	private CarroRepository carroRepository;
	
	public static void main(String[] args) {
		SpringApplication.run(CarApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//Instacia de Pessoas
		Pessoa p1 = new Pessoa(1, "Igor Dantas", "12345678910", "igor@gmail.com", "123", null, "Administrador");
		
		//Instacia de Veiculos
		Carro c1 = new Carro(1, "Ford", "Ka", 2013, "4Zu AL61j6 7z w45140", "85");
		
		pessoaRepository.saveAll(Arrays.asList(p1));
		
		carroRepository.saveAll(Arrays.asList(c1));
		
	}

}
