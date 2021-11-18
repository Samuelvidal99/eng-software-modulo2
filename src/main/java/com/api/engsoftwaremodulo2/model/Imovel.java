package com.api.engsoftwaremodulo2.model;

import com.api.engsoftwaremodulo2.exception.CepInvalidoException;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
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
        this.valorCondominio = valorCondominio;
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
}
