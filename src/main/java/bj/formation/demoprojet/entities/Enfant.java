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
@Table(name = "t_enfant")
public class Enfant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "enf_id")
    private Long id;

    @Column(name = "enf_nom")
    private String nom;

    @Column(name = "enf_prenom")
    private String prenom;

    @Column(name = "enf_date_naissance")
    private LocalDate dateNaissance;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "enf_niveau_enfant_id")
    private NiveauEnfant niveauEnfant;
}