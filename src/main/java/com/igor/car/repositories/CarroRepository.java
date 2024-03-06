package com.igor.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.car.domain.Carro;

public interface CarroRepository extends JpaRepository<Carro, Integer> {

}
