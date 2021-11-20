package com.api.engsoftwaremodulo2.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.annotation.Annotation;

public class CepNumberValidator implements ConstraintValidator<CepNumberConstraint, String> {


    @Override
    public void initialize(CepNumberConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    /**
     * Método checa se o cep é válido. Um cep válido contém 8 números e nada mais.
     * @param s = Uma string contendo o cep a ser validado.
     * @return true(válido), false(inválido)
     */
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        return s.length() == 8 && s.matches("^\\d+$");
    }
}
