
// AgentGradeDTO.java
package bj.formation.demoprojet.dto;

import lombok.Data;
import java.time.LocalDate;

public record AgentGradeDTO(
        int id,
        LocalDate debut,
        LocalDate fin,
        Long agentId,
        String gradeCode
) {}