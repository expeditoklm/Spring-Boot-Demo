package bj.formation.demoprojet.services;

import bj.formation.demoprojet.entities.Enfant;
import bj.formation.demoprojet.repositories.EnfantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EnfantService {
    @Autowired
    private EnfantRepository enfantRepository;

    public List<Enfant> getAllEnfants() {
        return enfantRepository.findAll();
    }

    public Enfant getEnfantById(Long id) {
        return enfantRepository.findById(id).orElse(null);
    }

    public Enfant createEnfant(Enfant enfant) {
        return enfantRepository.save(enfant);
    }

    public Enfant updateEnfant(Long id, Enfant enfantDetails) {
        Enfant enfant = getEnfantById(id);
        return enfantRepository.save(enfant);
    }

    public void deleteEnfant(Long id) {
        enfantRepository.deleteById(id);
    }
}