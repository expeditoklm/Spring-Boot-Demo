package bj.formation.demoprojet.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
@Entity
@Table(name = "t_agent_grade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AgentGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agr_id", length = 10)
    private int id ;

    @Column(name = "agr_debut")
    private LocalDate debut;

    @Column(name = "agr_fin")
    private LocalDate fin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agr_agent_id", referencedColumnName = "agt_matricule")
    @JsonIgnore
    private Agent agent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agr_grade_id", referencedColumnName = "gra_code")
    @JsonIgnore

    private Grade grade;
}
