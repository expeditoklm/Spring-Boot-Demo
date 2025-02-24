package bj.formation.demoprojet.securities;


// MatriculeUniqueValidator.java

import bj.formation.demoprojet.securities.ValidMatriculeUnique;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class MatriculeUniqueValidator implements ConstraintValidator<ValidMatriculeUnique, String> {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional(readOnly = true)
    public boolean isValid(String matricule, ConstraintValidatorContext context) {
        if (matricule == null) {
            return true;
        }

        try {
            Long count = entityManager.createQuery(
                            "SELECT COUNT(a) FROM Agent a WHERE a.matricule = :matricule", Long.class)
                    .setParameter("matricule", matricule)
                    .getSingleResult();

            boolean isUnique = count == 0;

            if (!isUnique) {
                context.disableDefaultConstraintViolation();
                context.buildConstraintViolationWithTemplate(
                        "Le matricule " + matricule + " existe déjà dans la base de données"
                ).addConstraintViolation();
            }

            return isUnique;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}