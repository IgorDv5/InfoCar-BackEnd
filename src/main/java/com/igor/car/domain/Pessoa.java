package com.igor.car.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.br.CPF;

import com.igor.car.domain.dtos.PessoaDTO;

@Entity
public class Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id //Anotacao para Identificar o id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // diz que é gerada automaticamente pelo banco
	private Integer id;
	private String nome;
	
	@Column(unique=true) //Anotacao para informar que é unica no banco
	@CPF
	private String cpf;
	
	@Column(unique=true) //Anotacao para informar que é unica no banco
	private String email;
	
	private String senha;
	private Date dataNascimento;
	private String funcao;
	
	public Pessoa() {
		super();
	}

	public Pessoa(Integer id, String nome, String cpf, String email, String senha, Date dataNascimento, String funcao) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.senha = senha;
		this.dataNascimento = dataNascimento;
		this.funcao = funcao;
	}
	
	public Pessoa(PessoaDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.dataNascimento = obj.getDataNascimento();
		this.funcao = obj.getFuncao();
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getFuncao() {
		return funcao;
	}

	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	
}
