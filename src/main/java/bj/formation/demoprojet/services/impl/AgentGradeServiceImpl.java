package bj.formation.demoprojet.services.impl;

import bj.formation.demoprojet.dto.AgentCreationDTO;
import bj.formation.demoprojet.dto.AgentResponseDTO;
import bj.formation.demoprojet.dto.PagedResponse;
import bj.formation.demoprojet.entities.Agent;
import bj.formation.demoprojet.repositories.AgentGradeRepository;
import bj.formation.demoprojet.services.AgentGradeService;
import bj.formation.demoprojet.services.AgentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class AgentGradeServiceImpl implements AgentGradeService {
    private final AgentGradeRepository agentGradeRepository;


    // Méthode qui retourne les agents avec le plus bas indice pour chaque grade
    public List<Agent> getAgentsWithLowestIndiceForEachGrade() {
        return agentGradeRepository.findAgentsWithLowestIndiceForEachGrade();
    }


}
