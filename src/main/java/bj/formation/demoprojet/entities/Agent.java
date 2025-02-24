package bj.formation.demoprojet.entities;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "t_agent")
public class Agent {
    @Id
    @Column(name = "agt_matricule")
    private String matricule;

    @Column(name = "agt_nom", nullable = false)
    private String nom;

    @Column(name = "agt_prenom", nullable = false)
    private String prenom;

    @Column(name = "agt_email", nullable = false)
    private String email;

    @Column(name = "agt_date_naissance")
    private LocalDate dateNaissance;

    @Column(name = "agt_indice")
    private Integer indice;

    @Column(name = "agt_salaire_base")
    private Double salaireBase;

    @Column(name = "agt_allocation_familiale")
    private Double allocationFamiliale;

    @Column(name = "agt_nbre_enfant")
    private Integer nbreEnfant;

    @Column(name = "agt_actif")
    private boolean actif = true;

    @OneToMany(mappedBy = "agent", cascade = CascadeType.ALL)
    private List<AgentGrade> agentGrades = new ArrayList<>();

    // Getters
    public String getMatricule() {
        return matricule;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public LocalDate getDateNaissance() {
        return dateNaissance;
    }

    public Integer getIndice() {
        return indice;
    }

    public Double getSalaireBase() {
        return salaireBase;
    }

    public Double getAllocationFamiliale() {
        return allocationFamiliale;
    }

    public Integer getNbreEnfant() {
        return nbreEnfant;
    }

    public boolean isActif() {
        return actif;
    }

    public List<AgentGrade> getAgentGrades() {
        return agentGrades;
    }

    // Setters
    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDateNaissance(LocalDate dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setIndice(Integer indice) {
        this.indice = indice;
    }

    public void setSalaireBase(Double salaireBase) {
        this.salaireBase = salaireBase;
    }

    public void setAllocationFamiliale(Double allocationFamiliale) {
        this.allocationFamiliale = allocationFamiliale;
    }

    public void setNbreEnfant(Integer nbreEnfant) {
        this.nbreEnfant = nbreEnfant;
    }

    public void setActif(boolean actif) {
        this.actif = actif;
    }

    public void setAgentGrades(List<AgentGrade> agentGrades) {
        this.agentGrades = agentGrades;
    }
}