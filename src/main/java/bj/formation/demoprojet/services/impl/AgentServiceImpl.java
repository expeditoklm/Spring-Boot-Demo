package bj.formation.demoprojet.services.impl;

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

import bj.formation.demoprojet.services.ResourceNotFoundException;
import bj.formation.demoprojet.utils.AppConstants;
import bj.formation.demoprojet.utils.AppUtils;
import lombok.RequiredArgsConstructor;
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
    private final MailService emailService;


    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ResponseEntity<AgentCreationDTO> addAgent(AgentCreationDTO agentCreationDTO) {

        Grade grade = gradeRepository.findById(agentCreationDTO.getGradeCode())
                .orElseThrow(() -> new ResourceNotFoundException("Grade not found"));

        Agent agent = new Agent();
        modelMapper.map(agentCreationDTO, agent);

        agent.setNom(agentCreationDTO.getNom());
        agent.setPrenom(agentCreationDTO.getPrenom());
        agent.setEmail(agentCreationDTO.getEmail());  // Assurez-vous que l'email est fourni
        agent.setDateNaissance(agentCreationDTO.getDateNaissance());
        agent.setIndice(agentCreationDTO.getIndice());
        agent.setSalaireBase((double) agentCreationDTO.getSalaireBase());
        agent.setAllocationFamiliale((double) agentCreationDTO.getAllocationFamiliale());
        agent.setNbreEnfant(agentCreationDTO.getNbreEnfant());
        agent.setActif(false);

        agent = agentRepository.save(agent);

        AgentGrade agentGrade = new AgentGrade();
        agentGrade.setAgent(agent);
        agentGrade.setGrade(grade);
        agentGrade.setDebut(LocalDate.now());
        agentGradeRepository.save(agentGrade);


        // Send an email notification
        String to = agent.getEmail();  // Assuming agent has an email field
        String subject = "Welcome to the System!";
        String body = "Dear " + agent.getNom() + " " + agent.getPrenom() + ",\n\nYour agent account has been successfully created.";

        emailService.sendEmail(to, subject, body);

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
