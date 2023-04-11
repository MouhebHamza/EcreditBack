package com.gtiinfo.ecreditproject.controllers;


import com.gtiinfo.ecreditproject.entities.EtatDemande;
import com.gtiinfo.ecreditproject.Repositories.EtatDemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/etatdemande")
public class EtatDemandeController {
    @Autowired
    private EtatDemandeRepository etatDemandeRepository;

    @GetMapping("/")
    public List<EtatDemande> getAllEtatDemandes() {
        return etatDemandeRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<EtatDemande> getDemandeById(@PathVariable Long id) {
        Optional<EtatDemande> etatDemande = etatDemandeRepository.findById(id);
        return etatDemande.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<EtatDemande> createEtatDemande(@RequestBody EtatDemande etatDemande) {
        EtatDemande savedEtatDemande = etatDemandeRepository.save(etatDemande);
        return new ResponseEntity<>(savedEtatDemande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtatDemande> updateEtatDemande(@PathVariable Long id, @RequestBody EtatDemande etatDemande) {
        Optional<EtatDemande> optionalEtatDemande = etatDemandeRepository.findById(id);
        if (optionalEtatDemande.isPresent()) {
            etatDemande.setId(id);
            EtatDemande updatedEtatDemande = etatDemandeRepository.save(etatDemande);
            return new ResponseEntity<>(updatedEtatDemande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDemande(@PathVariable Long id) {
        Optional<EtatDemande> optionalDemande = etatDemandeRepository.findById(id);
        if (optionalDemande.isPresent()) {
            etatDemandeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
