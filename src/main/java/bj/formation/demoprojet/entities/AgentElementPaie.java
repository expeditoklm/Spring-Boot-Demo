package bj.formation.demoprojet.entities;



import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_agentement_paie")
public class AgentElementPaie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agt_id")
    private Long id;

    @Column(name = "agt_montant")
    private int montant;

    @Column(name = "agt_debut")
    private LocalDate debut;

    @Column(name = "agt_fin")
    private LocalDate fin;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "agt_agent_id")
    private Agent agent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "agt_element_paie_code")
    private ElementPaie elementPaie;

    @OneToMany(mappedBy = "agentElementPaie", fetch = FetchType.LAZY)
    private List<DetailElementGenerer> detailElementGenerers;
}



