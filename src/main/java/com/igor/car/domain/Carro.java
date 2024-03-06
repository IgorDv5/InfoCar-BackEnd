package com.igor.car.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Carro implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	private String Chassi;
	private String cavalaria;
	
	public Carro() {
		super();
	}

	public Carro(Integer id, String marca, String modelo, int anoFabricacao, String chassi, String cavalaria) {
		super();
		this.id = id;
		this.marca = marca;
		this.modelo = modelo;
		this.anoFabricacao = anoFabricacao;
		Chassi = chassi;
		this.cavalaria = cavalaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public int getAnoFabricacao() {
		return anoFabricacao;
	}

	public void setAnoFabricacao(int anoFabricacao) {
		this.anoFabricacao = anoFabricacao;
	}

	public String getChassi() {
		return Chassi;
	}

	public void setChassi(String chassi) {
		Chassi = chassi;
	}

	public String getCavalaria() {
		return cavalaria;
	}

	public void setCavalaria(String cavalaria) {
		this.cavalaria = cavalaria;
	}
	
	
}