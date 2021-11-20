package com.api.engsoftwaremodulo2.deserializer;

import com.api.engsoftwaremodulo2.model.Imovel;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class CepDeserializerTest {

    private String json;

    @SneakyThrows
    @BeforeEach
    public void init() {
        Map<String, String> params = new HashMap<>();
        params.put("cidade", "Recife");
        params.put("logradouro", "rua x");
        params.put("cep", "52.061-080");
        params.put("valorCondominio", "99.15");

        json = new ObjectMapper().writeValueAsString(params);
    }

    @Test
    void deserializeCorrect() throws IOException {
        Imovel imovel = new ObjectMapper().readerFor(Imovel.class).readValue(json);

        assertEquals("52061080", imovel.getCep());
    }
}