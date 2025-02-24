package bj.formation.demoprojet.services;

import bj.formation.demoprojet.entities.ElementPaie;
import bj.formation.demoprojet.repositories.ElementPaieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElementPaieService {
    @Autowired
    private ElementPaieRepository elementPaieRepository;

    public List<ElementPaie> getAllElementsPaie() {
        return elementPaieRepository.findAll();
    }

    public ElementPaie getElementPaieById(Long id) {
        return elementPaieRepository.findById(id).orElse(null);
    }

    public ElementPaie createElementPaie(ElementPaie elementPaie) {
        return elementPaieRepository.save(elementPaie);
    }

    public ElementPaie updateElementPaie(Long id, ElementPaie elementPaieDetails) {
        ElementPaie elementPaie = getElementPaieById(id);
        // Mettre à jour les champs
        return elementPaieRepository.save(elementPaie);
    }

    public void deleteElementPaie(Long id) {
        elementPaieRepository.deleteById(id);
    }
}