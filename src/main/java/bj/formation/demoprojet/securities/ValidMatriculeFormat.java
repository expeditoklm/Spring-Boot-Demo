package bj.formation.demoprojet.securities;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = MatriculeFormatValidator.class)
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidMatriculeFormat {
    String message() default "Format du matricule invalide";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}