package com.api.engsoftwaremodulo2.model;

import java.util.Date;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;


@Document
@Data
public class Contrato {

	@Id
	private String id;
	@DBRef
	private Imovel imovel;
	@DBRef
	private Inquilino inquilino;
	
	@NotBlank(message = "O campo Número do Contrato é obrigatório")
	private int num_contrato;
	
	@NotNull(message = "O campo Valor do Aluguel é obrigatório")
	private double valor_aluguel;
	
	@NotBlank(message = "O campo Contrato de Enérgia é obrigatório")
	private String contrato_energia;
	
	@NotBlank(message = "O campo Contrato de Água é obrigatório")
	private String contrato_agua;
	
	@DateTimeFormat
	@NotNull(message = "O campo Data de Início é obrigatório")
	private Date dataInicio;
	
	@DateTimeFormat
	@NotNull(message = "O campo Data de Término é obrigatório")
	private Date dataTermino;
	
	@Email
	private String emailContratante;
	
	@NotNull(message = "O campo Pendente é obrigatório")
	private boolean pendente;
	
	public Contrato() {}

	public Contrato(Imovel imovel, Inquilino inquilino, int num_contrato, double valor_aluguel, String contrato_energia,
			String contrato_agua, Date dataInicio, Date dataTermino, String emailContratante, boolean pendente) {
		this.imovel = imovel;
		this.inquilino = inquilino;
		this.num_contrato = num_contrato;
		this.valor_aluguel = valor_aluguel;
		this.contrato_energia = contrato_energia;
		this.contrato_agua = contrato_agua;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.emailContratante = emailContratante;
		this.pendente = pendente;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Imovel getImovel() {
		return imovel;
	}

	public void setImovel(Imovel imovel) {
		this.imovel = imovel;
	}

	public Inquilino getInquilino() {
		return inquilino;
	}

	public void setInquilino(Inquilino inquilino) {
		this.inquilino = inquilino;
	}

	public int getNum_contrato() {
		return num_contrato;
	}

	public void setNum_contrato(int num_contrato) {
		this.num_contrato = num_contrato;
	}

	public double getValor_aluguel() {
		return valor_aluguel;
	}

	public void setValor_aluguel(double valor_aluguel) {
		this.valor_aluguel = valor_aluguel;
	}

	public String getContrato_energia() {
		return contrato_energia;
	}

	public void setContrato_energia(String contrato_energia) {
		this.contrato_energia = contrato_energia;
	}

	public String getContrato_agua() {
		return contrato_agua;
	}

	public void setContrato_agua(String contrato_agua) {
		this.contrato_agua = contrato_agua;
	}

	
	public Date getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(Date dataInicio) {
		this.dataInicio = dataInicio;
	}

	public Date getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(Date dataTermino) {
		this.dataTermino = dataTermino;
	}

	public String getEmailContratante() {
		return emailContratante;
	}

	public void setEmailContratante(String emailContratante) {
		this.emailContratante = emailContratante;
	}

	public boolean isPendente() {
		return pendente;
	}

	public void setPendente(boolean pendente) {
		this.pendente = pendente;
	}

	
		
}
