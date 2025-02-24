package bj.formation.demoprojet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

//import javax.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "t_generer_paie_mois")
public class GenererPaieMois {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "gpm_id")
    private Long id;

    @Column(name = "gpm_montant_brut")
    private int montantBrut;

    @Column(name = "gpm_montant_retenu")
    private int montantRetenu;

    @Column(name = "gpm_montant_paye")
    private int montantPaye;

    @Column(name = "gpm_echeance_mois")
    private LocalDate echeanceMois;

    @OneToOne
    @JoinColumn(name = "gpm_agentement_paie_id")
    private AgentElementPaie agentElementPaie;
}

