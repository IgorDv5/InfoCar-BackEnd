package com.igor.car.services;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.igor.car.domain.Pessoa;
import com.igor.car.domain.dtos.PessoaDTO;
import com.igor.car.repositories.PessoaRepository;
import com.igor.car.services.exceptions.DataIntegrityViolationException;
import com.igor.car.services.exceptions.ObjectNotFoundException;

@Service
public class PessoaService {

	@Autowired
	private PessoaRepository repository;
	@Autowired
	private BCryptPasswordEncoder encoder;

	public Pessoa findById(Integer id) {
		Optional<Pessoa> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto Não Encontrado! Id: " + id));
	}

	public List<Pessoa> findAll() {
		return repository.findAll();
	}

	public Pessoa create(PessoaDTO objDTO) {
		objDTO.setId(null);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		validaPorCpfeEmail(objDTO);
		Pessoa newObj = new Pessoa(objDTO);
		return repository.save(newObj);
	}

	public Pessoa update(Integer id, @Valid PessoaDTO objDTO) {
		objDTO.setId(id);
		objDTO.setSenha(encoder.encode(objDTO.getSenha()));
		Pessoa oldObj = findById(id);
		validaPorCpfeEmail(objDTO);
		oldObj = new Pessoa(objDTO);
		return repository.save(oldObj);
	}

	public void delete(Integer id) {
		repository.deleteById(id);
	}

	private void validaPorCpfeEmail(PessoaDTO objDTO) {
		Optional<Pessoa> obj = repository.findByCpf(objDTO.getCpf());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("CPF já Cadastrado no Sistema!");
		}

		obj = repository.findByEmail(objDTO.getEmail());
		if (obj.isPresent() && obj.get().getId() != objDTO.getId()) {
			throw new DataIntegrityViolationException("EMAIL já Cadastrado no Sistema!");
		}

	}

}
