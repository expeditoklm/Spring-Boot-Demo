package bj.formation.demoprojet.services;

import bj.formation.demoprojet.entities.NiveauEnfant;
import bj.formation.demoprojet.repositories.NiveauEnfantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NiveauEnfantService {

    @Autowired
    private NiveauEnfantRepository niveauEnfantRepository;

    public List<NiveauEnfant> findAll() {
        return niveauEnfantRepository.findAll();
    }

    public Optional<NiveauEnfant> findById(Long id) {
        return niveauEnfantRepository.findById(id);
    }

    public NiveauEnfant save(NiveauEnfant niveauEnfant) {
        return niveauEnfantRepository.save(niveauEnfant);
    }

    public void deleteById(Long id) {
        niveauEnfantRepository.deleteById(id);
    }
}