package bj.formation.demoprojet.repositories;

import bj.formation.demoprojet.entities.NiveauEnfant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NiveauEnfantRepository extends JpaRepository<NiveauEnfant, Long> {
}