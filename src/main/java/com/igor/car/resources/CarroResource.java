package com.igor.car.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.igor.car.domain.Carro;
import com.igor.car.domain.dtos.CarroDTO;
import com.igor.car.services.CarroService;

@RestController
@RequestMapping(value = "/carros")
public class CarroResource {

	@Autowired
	private CarroService service;
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CarroDTO> findById(@PathVariable Integer id){
		Carro obj = service.findById(id);
		return ResponseEntity.ok().body(new CarroDTO(obj));
	}
	
	@GetMapping
	public ResponseEntity<List<CarroDTO>> findAll(){
		List<Carro> list = service.findAll();
		List<CarroDTO> listDTO = list.stream().map(obj -> new CarroDTO(obj)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);
		
	}
	
	@PostMapping
	public ResponseEntity<CarroDTO> create(@Valid @RequestBody CarroDTO objDTO){
		Carro newObj = service.create(objDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(newObj.getId()).toUri();
		return ResponseEntity.created(uri).build();
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CarroDTO> update(@PathVariable Integer id,@Valid @RequestBody CarroDTO objDTO){
		Carro obj = service.update(id,objDTO);
		return ResponseEntity.ok().body(new CarroDTO(obj));
		
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<CarroDTO> delete(@PathVariable Integer id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
