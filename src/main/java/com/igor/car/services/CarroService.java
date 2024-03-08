package com.igor.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.car.domain.Carro;
import com.igor.car.domain.dtos.CarroDTO;
import com.igor.car.repositories.CarroRepository;
import com.igor.car.services.exceptions.DataIntegrityViolationException;
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

	public Carro create(CarroDTO objDTO) {
		objDTO.setId(null);
		validaPorPlacaeChassi(objDTO);
		Carro newObj = new Carro(objDTO);
		return repository.save(newObj);
	}
	
	
	private void validaPorPlacaeChassi(CarroDTO objDTO) {
		Optional<Carro> obj = repository.findByPlaca(objDTO.getPlaca());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Placa já Cadastrada no Sistema!");
		}
		
		obj = repository.findByChassi(objDTO.getChassi());
		if(obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("Chassi Já Cadastrado No Sistema!");
		} 
	}
	

}
