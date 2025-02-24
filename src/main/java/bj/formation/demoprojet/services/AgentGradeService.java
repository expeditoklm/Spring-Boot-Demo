package bj.formation.demoprojet.services;

import bj.formation.demoprojet.dto.PagedResponse;
import bj.formation.demoprojet.entities.Agent;

import java.util.List;

public interface AgentGradeService {
    List<Agent> getAgentsWithLowestIndiceForEachGrade();

}
