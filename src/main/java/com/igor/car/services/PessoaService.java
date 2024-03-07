package com.igor.car.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.igor.car.domain.Pessoa;
import com.igor.car.domain.dtos.PessoaDTO;
import com.igor.car.repositories.PessoaRepository;
import com.igor.car.services.exceptions.ObjectNotFoundException;



@Service
public class PessoaService {
	
	@Autowired
	private PessoaRepository repository;
	
	public Pessoa findById(Integer id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: "+ id));
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa create(PessoaDTO objDTO) {
		objDTO.setId(null); 
		Pessoa newObj = new Pessoa(objDTO); 
		return repository.save(newObj);
	}


	
	
}
