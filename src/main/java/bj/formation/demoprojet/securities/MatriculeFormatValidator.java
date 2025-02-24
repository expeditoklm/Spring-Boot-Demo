package bj.formation.demoprojet.securities;


import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;

@Component
public class MatriculeFormatValidator implements ConstraintValidator<ValidMatriculeFormat, String> {
    private static final String MATRICULE_PATTERN = "^[A-Z]{2}\\d{6}$";

    @Override
    public boolean isValid(String matricule, ConstraintValidatorContext context) {
        if (matricule == null) {
            return false;
        }

        boolean isFormatValid = matricule.matches(MATRICULE_PATTERN);

        if (!isFormatValid) {
            context.disableDefaultConstraintViolation();
            context.buildConstraintViolationWithTemplate(
                    "Le matricule doit être composé de 2 lettres majuscules suivies de 6 chiffres"
            ).addConstraintViolation();
        }

        return isFormatValid;
    }
}
