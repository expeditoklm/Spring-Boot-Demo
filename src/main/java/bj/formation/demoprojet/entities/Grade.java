package bj.formation.demoprojet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;
@Entity
@Table(name = "t_grade")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Grade {
    @Id
    @Column(name = "gra_code")
    private String code;  // Clé primaire naturelle

    @Column(name = "gra_libelle", nullable = false)
    private String libelle;

    @Column(name = "gra_indice")
    private Integer indice;

    @OneToMany(mappedBy = "grade", cascade = CascadeType.ALL)
    private List<AgentGrade> agentGrades = new ArrayList<>();
}