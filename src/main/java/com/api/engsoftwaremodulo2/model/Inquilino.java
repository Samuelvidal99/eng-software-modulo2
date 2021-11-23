package com.api.engsoftwaremodulo2.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document
@Data
public class Inquilino {
	
	
	@Id
	private String id;
	
	@NotBlank(message = "O campo nome é obrigatório")
	private String nome;
	
	@CPF(message = "Digite um CPF válido")
	private String cpf;
	
	@NotBlank(message = "O campo RG é obrigatório")
	private String rg;
	
	@NotBlank(message = "O campo telefone é obrigatório")
	private String telefone;
	
	@Email(message = "Digite um Email valido")
	private String email;
	
	public Inquilino() {}
	
	public Inquilino(String nome, String cpf, String rg, String telefone, String email) {
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.telefone = telefone;
		this.email = email;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
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

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
