package bj.formation.demoprojet.securities;


// ValidMatriculeUnique.java

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MatriculeUniqueValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMatriculeUnique {
    String message() default "Matricule déjà existant";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}