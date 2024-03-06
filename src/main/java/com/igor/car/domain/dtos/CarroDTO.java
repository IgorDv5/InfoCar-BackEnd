package com.igor.car.domain.dtos;

import java.io.Serializable;

import com.igor.car.domain.Carro;

public class CarroDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String marca;
	private String modelo;
	private int anoFabricacao;
	private String chassi;
	private String cavalaria;
	private String placa;
	
	public CarroDTO() {
		super();
	}

	public CarroDTO(Carro obj) {
		super();
		this.id = obj.getId();
		this.marca = obj.getMarca();
		this.modelo = obj.getModelo();
		this.anoFabricacao = obj.getAnoFabricacao();
		this.chassi = obj.getChassi();
		this.cavalaria = obj.getCavalaria();
		this.placa = obj.getPlaca();
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
		return chassi;
	}

	public void setChassi(String chassi) {
		this.chassi = chassi;
	}

	public String getCavalaria() {
		return cavalaria;
	}

	public void setCavalaria(String cavalaria) {
		this.cavalaria = cavalaria;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}
	
	

	
	
}
