package bj.formation.demoprojet.dto;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

import java.time.LocalDate;

@Data
@JsonInclude(Include.NON_NULL)
public class AgentResponseDTO {

    private String matricule;
    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    private int indice;
    private Double salaireBase;
    private boolean actif;
    private GradeResponseDTO grade;

    // Constructeur par défaut
    public AgentResponseDTO() {
    }

    // Constructeur avec tous les champs
    public AgentResponseDTO(String matricule, String nom, String prenom, LocalDate dateNaissance,
                            int indice, Double salaireBase, boolean actif, GradeResponseDTO grade) {
        this.matricule = matricule;
        this.nom = nom;
        this.prenom = prenom;
        this.dateNaissance = dateNaissance;
        this.indice = indice;
        this.salaireBase = salaireBase;
        this.actif = actif;
        this.grade = grade;
    }
}
