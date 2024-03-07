package com.igor.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.car.domain.Carro;
import com.igor.car.repositories.CarroRepository;
import com.igor.car.services.exceptions.ObjectNotFoundException;

@Service
public class CarroService {
	
	@Autowired
	private CarroRepository repository;

	public Carro findById(Integer id) {
		Optional<Carro> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + id));
	}

	public List<Carro> findAll() {
		return repository.findAll();
	}
	
	 
	

}
