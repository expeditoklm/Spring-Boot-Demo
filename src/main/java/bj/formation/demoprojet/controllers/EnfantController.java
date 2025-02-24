package bj.formation.demoprojet.controllers;

import bj.formation.demoprojet.entities.Enfant;
import bj.formation.demoprojet.services.EnfantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enfants")
public class EnfantController {
    @Autowired
    private EnfantService enfantService;

    @GetMapping
    public List<Enfant> getAllEnfants() {
        return enfantService.getAllEnfants();
    }

    @GetMapping("/{id}")
    public Enfant getEnfantById(@PathVariable Long id) {
        return enfantService.getEnfantById(id);
    }

    @PostMapping
    public Enfant createEnfant(@RequestBody Enfant enfant) {
        return enfantService.createEnfant(enfant);
    }

    @PutMapping("/{id}")
    public Enfant updateEnfant(@PathVariable Long id, @RequestBody Enfant enfantDetails) {
        return enfantService.updateEnfant(id, enfantDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteEnfant(@PathVariable Long id) {
        enfantService.deleteEnfant(id);
    }
}