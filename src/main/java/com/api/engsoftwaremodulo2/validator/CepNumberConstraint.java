package com.api.engsoftwaremodulo2.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@SuppressWarnings("unused")
@Documented
@Constraint(validatedBy = CepNumberValidator.class)
@Target({ElementType.FIELD, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CepNumberConstraint {
    String message() default "Cep deve conter exatamente 8 números";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
