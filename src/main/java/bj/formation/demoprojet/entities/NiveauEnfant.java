package bj.formation.demoprojet.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
//import javax.persistence.*;
import lombok.*;
@Entity
@Table(name = "t_niveau_enfant")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class NiveauEnfant {
    @Id
    @Column(name = "niv_code")
    private String code;  // Clé primaire naturelle

    @Column(name = "niv_libelle", nullable = false)
    private String libelle;

    @Column(name = "niv_age_limit", nullable = false)
    private Integer ageLimit;

    @OneToMany(mappedBy = "niveauEnfant")
    private List<Enfant> enfants = new ArrayList<>();
}