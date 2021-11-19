package com.api.engsoftwaremodulo2.model;

import com.api.engsoftwaremodulo2.exception.CepInvalidoException;
import com.api.engsoftwaremodulo2.exception.ValorCondominioInvalidoException;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@SuppressWarnings("unused")
public class Imovel {

    @Id
    private String id;
    private String cidade;
    private String logradouro;
    private String cep;
    private double valorCondominio;

    public Imovel() { }

    public Imovel(String cidade, String logradouro, String cep, double valorCondominio) {
        this.cidade = cidade;
        this.logradouro = logradouro;
        this.setCep(cep);
        this.setValorCondominio(valorCondominio);
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

	/**
     * Método checa se o cep é válido. Um cep válido contém 8 números e nada mais.
     * @param cep Uma string contendo o cep a ser validado.
     * @return true(válido), false(inválido)
     */
    public boolean validarCep(String cep) {
        return cep.length() == 8 && cep.matches("^\\d+$");
    }

    /**
     * Método formata um dado cep removendo os caractéres comuns de separação entre os dígitos.
     * @param cep Uma string contendo o cep a ser formatado.
     * @return cepFormatado
     */
    @SuppressWarnings("RegExpRedundantEscape")
    public String formatarCep(String cep) {
        return cep.replaceAll("[-\\.]", "");
    }

    public void setCep(String cep) {
        cep = this.formatarCep(cep);

        if (!this.validarCep(cep))
            throw new CepInvalidoException("Não é possível atribuir um cep inválido a um imóvel.\nCEP: " + this.cep);

        this.cep = cep;
    }

    public void setValorCondominio(double valorCondominio) {
        if (valorCondominio <= 0)
            throw new ValorCondominioInvalidoException("Valor de condomínio inválido.\nVALOR: " + this.valorCondominio);

        this.valorCondominio = valorCondominio;
    }
}
