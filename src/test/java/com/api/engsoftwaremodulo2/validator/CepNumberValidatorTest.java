package com.api.engsoftwaremodulo2.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CepNumberValidatorTest {

    private CepNumberValidator validator;

    @BeforeEach
    public void init() {
        this.validator = new CepNumberValidator();
    }

    @Test
    void validarCepCorreto() {
        String cep = "92031111";
        assertTrue(this.validator.isValid(cep, null));
    }

    @Test
    void validarCepIncorreto() {
        String cep = "9203az!/";
        assertFalse(this.validator.isValid(cep, null));
    }
}