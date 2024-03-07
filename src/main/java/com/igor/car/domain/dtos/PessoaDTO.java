package com.igor.car.domain.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.igor.car.domain.Pessoa;

public class PessoaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	
	private Integer id;
	@NotNull(message = "O Campo NOME é Requerido")
	private String nome;
	
	@JsonFormat(pattern = "###.###.###-##")	
	@NotNull(message = "O Campo CPF é Requerido")
	private String cpf;
	@NotNull(message = "O Campo EMAIL é Requerido")
	private String email;
	@NotNull(message = "O Campo SENHA é Requerido")
	private String senha;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataNascimento;
	private String funcao;
	
	public PessoaDTO() {
		super();
	} 
 
	public PessoaDTO(Pessoa obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.cpf = obj.getCpf();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.dataNascimento = obj.getDataNascimento();
		this.funcao = obj.getFuncao();
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
		 // Remover caracteres não numéricos do CPF
        cpf = cpf.replaceAll("[^0-9]", "");

        // Formatar o CPF
        StringBuilder cpfFormatado = new StringBuilder(cpf);
        cpfFormatado.insert(3, '.');
        cpfFormatado.insert(7, '.');
        cpfFormatado.insert(11, '-');

        this.cpf = cpfFormatado.toString();
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
