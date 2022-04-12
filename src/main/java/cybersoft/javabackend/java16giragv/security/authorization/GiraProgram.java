package cybersoft.javabackend.java16giragv.security.authorization;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface GiraProgram {
	String value() default "";
	
	Class<?>[] groups() default {};
}
