package com.igor.car.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.car.domain.Carro;



public interface CarroRepository extends JpaRepository<Carro, Integer> {

	 Optional<Carro> findByPlaca(String placa);
	
	 Optional<Carro> findByChassi(String chassi);
	
}
