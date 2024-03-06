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
		Pessoa p1 = new Pessoa(1, "Igor Dantas", "519.836.359-60", "igor@gmail.com", "123", null, "Administrador");
		Pessoa p2 = new Pessoa(2, "Marcos Alonso", "827.579.799-30", "Marcos@gmail.com", "123", null, "Cliente");
		Pessoa p3 = new Pessoa(3, "Roberto Ferreira", "324.000.656-16", "Roberto@gmail.com", "123", null, "Cliente");
		Pessoa p4 = new Pessoa(4, "Latencio Sousa", "737.003.845-99", "Latencio@gmail.com", "123", null, "Cliente");
		Pessoa p5 = new Pessoa(5, "Lucas Torres", "741.536.295-02", "Lucas@gmail.com", "123", null, "Cliente");
		Pessoa p6 = new Pessoa(6, "Adriano Vasquz", "539.586.471-70", "Adriano@gmail.com", "123", null, "Vendedor");
		Pessoa p7 = new Pessoa(7, "Luiz de sousa", "205.883.842-40", "Luiz@gmail.com", "123", null, "Vendedor");
		Pessoa p8 = new Pessoa(8, "Thomas Turbando", "925.781.607-91", "Thomas@gmail.com", "123", null, "Vendedor");
		Pessoa p9 = new Pessoa(9, "Paula Tejando", "359.107.789-51", "Paula@gmail.com", "123", null, "Vendedor");
		
		//Instacia de Veiculos
		Carro c1 = new Carro(1, "Ford", "Ka", 2010, "4Zu AL61j6 7z w45140", "85", "JIN-3247");
		Carro c2 = new Carro(2, "Chevrolet", "Omega", 1993, "2GA 6JlyAy 41 ZA3077", "179", "OPJ-1505");
		Carro c3 = new Carro(3, "Chevrolet", "Onix", 2023, "8G5 MA8Azx fA T13583", "116", "HYT-9731");
		Carro c4 = new Carro(4, "Chevrolet", "Monza", 1996, "651 MwfHYe Ag yX8903", "110", "AQB-5067");
		Carro c5 = new Carro(5, "Audi", "A3", 1995, "5S9 B5tAeA 6Z 8S2535", "210", "EJX-2465");
		Carro c6 = new Carro(6, "Chevrolet", "Omega", 2006, "304 Vm2BKu K5 460849", "220", "RFF-4570");
		Carro c7 = new Carro(7, "Ford", "Maverick", 1976, "67f MpDB12 S8 A77732", "180", "EQT-2572");
		Carro c8 = new Carro(8, "Ford", "Corcel II", 1986, "6K7 A6JWUG dg j13569", "80", "RJU-3421");
		Carro c9 = new Carro(9, "Fiat", "Palio", 1999, "5V2 5ldYNA 84 6W0328", "92", "PMB-1313");
		Carro c10 = new Carro(10, "Fiat", "Uno", 2006, "5Hp dnz7AR B7 bC1868", "70", "CFA-0768");
				
				
		pessoaRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6,p7,p8,p9));
		
		carroRepository.saveAll(Arrays.asList(c1,c2,c3,c4,c5,c6,c7,c8,c9,c10));
		
	}

}
