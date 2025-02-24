package bj.formation.demoprojet.repositories;

import bj.formation.demoprojet.entities.Agent;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AgentRepository extends JpaRepository<Agent, String> {
    // Rechercher un agent par matricule
    Optional<Agent> findByMatricule(String matricule);

    // Vérifier si un matricule existe
    boolean existsByMatricule(String matricule);

    // Rechercher un agent actif par matricule
    Optional<Agent> findByMatriculeAndActifTrue(String matricule);

    // Rechercher tous les agents par une liste de matricules
    List<Agent> findByMatriculeIn(List<String> matricules);

    // Rechercher par matricule contenant une chaîne (insensible à la casse)
    List<Agent> findByMatriculeContainingIgnoreCase(String matricule);

    // Rechercher par matricule et vérifier si actif
    boolean existsByMatriculeAndActifTrue(String matricule);
}