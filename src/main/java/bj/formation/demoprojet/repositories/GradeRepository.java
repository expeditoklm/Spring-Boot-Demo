package bj.formation.demoprojet.repositories;

import bj.formation.demoprojet.entities.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository <Grade, String> {
}
