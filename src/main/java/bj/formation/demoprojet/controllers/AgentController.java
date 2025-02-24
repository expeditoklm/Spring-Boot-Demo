package bj.formation.demoprojet.controllers;

import bj.formation.demoprojet.dto.*;
import bj.formation.demoprojet.entities.Agent;
import bj.formation.demoprojet.services.AgentService;
import bj.formation.demoprojet.utils.AppConstants;
import bj.formation.demoprojet.utils.AppUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/agents")
@RequiredArgsConstructor
public class AgentController {
    private final AgentService agentService;

    @PostMapping
    public ResponseEntity<AgentCreationDTO> createAgent(@RequestBody @Valid AgentCreationDTO agentCreationDTO) {
            return agentService.addAgent(agentCreationDTO);
    }

    @GetMapping
    public PagedResponse<AgentResponseDTO> getAllAgents(
          @RequestParam(name = "page", required = false, defaultValue = AppConstants.DEFAULT_PAGE_NUMBER) Integer page,
			@RequestParam(name = "size", required = false, defaultValue = AppConstants.DEFAULT_PAGE_SIZE) Integer size) {
		AppUtils.validatePageNumberAndSize(page, size);

		return agentService.getAllAgents(page, size);
    }

    @GetMapping("/{matricule}")
    public ResponseEntity<Agent> getPostsCreatedBy(@PathVariable(value = "matricule") String matricule) {
        Agent response = agentService.getAgentByMatricule(matricule);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }


}