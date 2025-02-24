package bj.formation.demoprojet.repositories;

import bj.formation.demoprojet.dto.PagedResponse;
import bj.formation.demoprojet.entities.Agent;
import bj.formation.demoprojet.entities.AgentGrade;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgentGradeRepository extends JpaRepository<AgentGrade, Long> {

    // Requête pour obtenir l'agent avec l'indice le plus bas pour chaque grade
    @Query("SELECT ag.agent " +
            "FROM AgentGrade ag " +
            "WHERE ag.agent.indice = (SELECT MIN(a.agent.indice) FROM AgentGrade a WHERE a.grade.code = ag.grade.code) ")
    List<Agent> findAgentsWithLowestIndiceForEachGrade();
}
