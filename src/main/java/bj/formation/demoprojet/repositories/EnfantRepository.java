package bj.formation.demoprojet.repositories;

import bj.formation.demoprojet.entities.Enfant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnfantRepository extends JpaRepository<Enfant, Long> {
}