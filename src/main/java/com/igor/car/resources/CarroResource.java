package com.igor.car.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
	
}
