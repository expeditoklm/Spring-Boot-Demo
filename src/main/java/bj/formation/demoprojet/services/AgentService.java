package bj.formation.demoprojet.services;

import bj.formation.demoprojet.dto.AgentCreationDTO;
import bj.formation.demoprojet.dto.AgentResponseDTO;
import bj.formation.demoprojet.dto.PagedResponse;
import bj.formation.demoprojet.entities.Agent;
import org.springframework.http.ResponseEntity;

public interface AgentService {
    ResponseEntity<AgentCreationDTO> addAgent(AgentCreationDTO agentCreationDTO);

    PagedResponse<AgentResponseDTO> getAllAgents(int page, int size);
    Agent getAgentByMatricule(String matricule);



}
