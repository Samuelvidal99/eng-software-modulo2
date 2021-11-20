package com.api.engsoftwaremodulo2.deserializer;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;

public class CepDeserializer extends StdDeserializer<String> {

    public CepDeserializer() { this(null);}

    public CepDeserializer(Class<?> vc) { super(vc); }

    @Override
    public String deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        try {
            String cep = jsonParser.getText();
            return this.formatarCep(cep);
        } catch (IOException e) {
            throw new JsonEOFException(jsonParser, jsonParser.getCurrentToken(),
                    "Houve um erro ao deserializar o campo <cep> do json referente a um objeto imóvel de uma request.");
        }
    }

    /**
     * Método formata um dado cep removendo os caractéres comuns de separação entre os dígitos.
     * @param cep Uma string contendo o cep a ser formatado.
     * @return cepFormatado
     */
    @SuppressWarnings("RegExpRedundantEscape")
    private String formatarCep(String cep) {
        return cep.replaceAll("[-\\.]", "");
    }
}
