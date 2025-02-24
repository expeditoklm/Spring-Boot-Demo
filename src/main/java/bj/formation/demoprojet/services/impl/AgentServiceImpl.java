package bj.formation.demoprojet.services.impl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import bj.formation.demoprojet.dto.AgentCreationDTO;
import bj.formation.demoprojet.dto.AgentResponseDTO;
import bj.formation.demoprojet.dto.PagedResponse;
import bj.formation.demoprojet.entities.Agent;
import bj.formation.demoprojet.entities.AgentGrade;
import bj.formation.demoprojet.entities.Grade;
import bj.formation.demoprojet.exception.BadRequestException;
import bj.formation.demoprojet.repositories.AgentGradeRepository;
import bj.formation.demoprojet.repositories.AgentRepository;
import bj.formation.demoprojet.repositories.GradeRepository;
import bj.formation.demoprojet.services.AgentService;
import bj.formation.demoprojet.services.impl.MailService;
import bj.formation.demoprojet.services.ResourceNotFoundException;
import bj.formation.demoprojet.utils.AppConstants;
import bj.formation.demoprojet.utils.AppUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static bj.formation.demoprojet.utils.AppConstants.*;

@Service
@RequiredArgsConstructor
public class AgentServiceImpl implements AgentService {
    private final AgentRepository agentRepository;
    private final GradeRepository gradeRepository;
    private final AgentGradeRepository agentGradeRepository;
    private final MailService mailService;


    @Autowired
    private ModelMapper modelMapper;
    private static final Logger log = LoggerFactory.getLogger(AgentServiceImpl.class);


    @Override
    public ResponseEntity<AgentCreationDTO> addAgent(AgentCreationDTO agentCreationDTO) {
        log.info("Début de la création d'un agent avec les données : {}", agentCreationDTO);

        Grade grade = gradeRepository.findById(agentCreationDTO.getGradeCode())
                .orElseThrow(() -> {
                    log.error("Grade introuvable avec l'ID : {}", agentCreationDTO.getGradeCode());
                    return new ResourceNotFoundException("Grade not found");
                });

        log.info("Grade trouvé : {}", grade.getCode());

        Agent agent = new Agent();
        modelMapper.map(agentCreationDTO, agent);

        agent.setNom(agentCreationDTO.getNom());
        agent.setPrenom(agentCreationDTO.getPrenom());
        agent.setEmail(agentCreationDTO.getEmail());
        agent.setDateNaissance(agentCreationDTO.getDateNaissance());
        agent.setIndice(agentCreationDTO.getIndice());
        agent.setSalaireBase((double) agentCreationDTO.getSalaireBase());
        agent.setAllocationFamiliale((double) agentCreationDTO.getAllocationFamiliale());
        agent.setNbreEnfant(agentCreationDTO.getNbreEnfant());
        agent.setActif(false);

        log.info("Agent avant sauvegarde : {}", agent);

        agent = agentRepository.save(agent);
        log.info("Agent enregistré avec succès : ID={}, Matricule={}", agent.getMatricule(), agent.getMatricule());

        AgentGrade agentGrade = new AgentGrade();
        agentGrade.setAgent(agent);
        agentGrade.setGrade(grade);
        agentGrade.setDebut(LocalDate.now());
        agentGradeRepository.save(agentGrade);
        log.info("Relation Agent-Grade enregistrée");

        // Envoi de l'e-mail après enregistrement
        String subject = "Bienvenue dans notre entreprise !";
        String body = "<h1>Bienvenue, " + agent.getPrenom() + " " + agent.getNom() + "!</h1>"
                + "<p>Votre matricule est <b>" + agent.getMatricule() + "</b>.</p>"
                + "<p>Nous sommes ravis de vous accueillir.</p>";

        try {
            log.info("Tentative d'envoi d'e-mail à : {}", agent.getEmail());
            mailService.sendEmail(agent.getEmail(), subject, body);
            log.info("E-mail envoyé avec succès à : {}", agent.getEmail());
        } catch (Exception e) {
            log.error("Échec de l'envoi de l'e-mail à : {}", agent.getEmail(), e);
        }

        return new ResponseEntity<>(agentCreationDTO, HttpStatus.CREATED);
    }


    public Agent getAgentByMatricule(String matricule) {
        return agentRepository.findByMatricule(matricule).orElseThrow(() -> new ResourceNotFoundException(AGENT, ID, matricule ));
    }


    private void validatePageNumberAndSize(int page, int size) {
        if (page < 0) {
            throw new BadRequestException("Page number cannot be less than zero.");
        }

        if (size < 0) {
            throw new BadRequestException("Size number cannot be less than zero.");
        }

        if (size > AppConstants.MAX_PAGE_SIZE) {
            throw new BadRequestException("Page size must not be greater than " + AppConstants.MAX_PAGE_SIZE);
        }
    }



    public PagedResponse<AgentResponseDTO> getAllAgents(int page, int size) {
        AppUtils.validatePageNumberAndSize(page, size);

        Pageable pageable = PageRequest.of(page, size, Sort.Direction.DESC , "matricule");

        Page<Agent> agents = agentRepository.findAll(pageable);

        if (agents.getNumberOfElements() == 0) {
            return new PagedResponse<>(Collections.emptyList(), agents.getNumber(), agents.getSize(), agents.getTotalElements(),
                    agents.getTotalPages(), agents.isLast());
        }

        List<AgentResponseDTO> agentResponses = Arrays.asList(modelMapper.map(agents.getContent(), AgentResponseDTO[].class));

        return new PagedResponse<>(agentResponses, agents.getNumber(), agents.getSize(), agents.getTotalElements(), agents.getTotalPages(),
                agents.isLast());
    }

}
