package bj.formation.demoprojet.dto;


import java.time.LocalDate;

public record EnfantDTO(
        Long id,
        String nom,
        String prenom,
        LocalDate dateNaissance,
        Long niveauEnfantId
) {}