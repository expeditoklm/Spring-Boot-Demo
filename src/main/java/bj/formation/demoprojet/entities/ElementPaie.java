package bj.formation.demoprojet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.List;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_element_paie")
public class ElementPaie {

    @Id
    @Column(name = "elp_code")
    private String code;  // La clé primaire du type Long

    @Column(name = "elp_libelle")
    private String libelle;

    @OneToMany(mappedBy = "elementPaie", fetch = FetchType.LAZY)
    private List<AgentElementPaie> agentElementPaies;
}
