package bj.formation.demoprojet.dto;

public record NiveauEnfantDTO(
        Long id,
        String code,
        String libelle,
        int ageLimit
) {}
