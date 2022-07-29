package cybersoft.javabackend.java16giragv.user.validation.annotation;

import cybersoft.javabackend.java16giragv.user.validation.validator.UniqueUsernameValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = UniqueUsernameValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface UniqueUsername {
    String message() default "Username already used.";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
