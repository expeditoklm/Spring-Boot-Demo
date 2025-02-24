package bj.formation.demoprojet.dto;

import bj.formation.demoprojet.securities.ValidMatriculeFormat;
import bj.formation.demoprojet.securities.ValidMatriculeUnique;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import jakarta.validation.constraints.*;
import lombok.Data;
import java.time.LocalDate;

@Data
@JsonInclude(Include.NON_NULL)
public class AgentCreationDTO {
        @ValidMatriculeFormat
        @ValidMatriculeUnique
        private String matricule;

        @NotBlank(message = "Le nom est obligatoire")
        private String nom;

        @NotBlank(message = "Le prénom est obligatoire")
        private String prenom;

        @NotNull(message = "La date de naissance est obligatoire")
        @Past(message = "La date de naissance doit être dans le passé")
        private LocalDate dateNaissance;

        @Positive(message = "L'indice doit être positif")
        private int indice;

        @PositiveOrZero(message = "Le salaire de base doit être positif ou zéro")
        private int salaireBase;

        @PositiveOrZero(message = "L'allocation familiale doit être positive ou zéro")
        private int allocationFamiliale;

        @PositiveOrZero(message = "Le nombre d'enfants doit être positif ou zéro")
        private int nbreEnfant;

        @NotBlank(message = "Le code grade est obligatoire")
        private String gradeCode;

        // Constructeur par défaut
        public AgentCreationDTO() {
        }

        // Constructeur avec tous les champs
        public AgentCreationDTO(String matricule, String nom, String prenom,
                                LocalDate dateNaissance, int indice, int salaireBase,
                                int allocationFamiliale, int nbreEnfant, String gradeCode) {
                this.matricule = matricule;
                this.nom = nom;
                this.prenom = prenom;
                this.dateNaissance = dateNaissance;
                this.indice = indice;
                this.salaireBase = salaireBase;
                this.allocationFamiliale = allocationFamiliale;
                this.nbreEnfant = nbreEnfant;
                this.gradeCode = gradeCode;
        }

        // Getters et Setters sont générés automatiquement par l'annotation @Data de Lombok
}