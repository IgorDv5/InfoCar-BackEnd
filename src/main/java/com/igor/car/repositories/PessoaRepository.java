package com.igor.car.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.igor.car.domain.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Integer> {

}
