package com.api.engsoftwaremodulo2.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ImovelTest {

    private Imovel imovel;

    @BeforeEach
    public void init() {
        this.imovel = new Imovel();
    }


    @Test
    void validarCepCorreto() {
        String cep = "92031111";
        assertTrue(this.imovel.validarCep(cep));
    }

    @Test
    void validarCepIncorreto() {
        String cep = "9203az!/";
        assertFalse(this.imovel.validarCep(cep));
    }

    @Test
    void formatarCep() {
        String cep = "59.501-010";
        assertEquals(this.imovel.formatarCep(cep), "59501010");
    }
}