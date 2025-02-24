package bj.formation.demoprojet.entities;


import lombok.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_detail_element_generer")
public class DetailElementGenerer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "deg_id")
    private Long id;

    @Column(name = "deg_mont_element")
    private int montElement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "deg_agentement_paie_id")
    private AgentElementPaie agentElementPaie;
}

