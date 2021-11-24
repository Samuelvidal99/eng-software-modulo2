package com.api.engsoftwaremodulo2.model;

import com.api.engsoftwaremodulo2.deserializer.CepDeserializer;
import com.api.engsoftwaremodulo2.exception.CepInvalidoException;
import com.api.engsoftwaremodulo2.exception.ValorCondominioInvalidoException;
import com.api.engsoftwaremodulo2.validator.CepNumberConstraint;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Null;
import javax.validation.constraints.PositiveOrZero;

@Document
@Data
@SuppressWarnings("unused")
public class Imovel {

    @Id
    private String id;
    @NotBlank(message = "O campo <cidade> é obrigatório")
    private String cidade;
    @NotBlank(message = "O campo <logradouro> é obrigatório")
    private String logradouro;
    @NotBlank(message = "O campo <cep> é obrigatório")
    @CepNumberConstraint
    @JsonDeserialize(using = CepDeserializer.class)
    private String cep;
    @PositiveOrZero(message = "O campo <valorCondominio> deve ser maior ou igual a zero")
    private double valorCondominio;

    public Imovel() { }

    public Imovel(String cidade, String logradouro, String cep, double valorCondominio) {
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.cep = cep;
        this.valorCondominio = valorCondominio;
    }



    public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public double getValorCondominio() {
		return valorCondominio;
	}

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setValorCondominio(double valorCondominio) {
        this.valorCondominio = valorCondominio;
    }
}
