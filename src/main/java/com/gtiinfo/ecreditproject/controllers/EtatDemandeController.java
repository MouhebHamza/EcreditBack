package com.gtiinfo.ecreditproject.controllers;
import com.gtiinfo.ecreditproject.entities.EtatDemande;
import com.gtiinfo.ecreditproject.Repositories.EtatDemandeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/etatdemande")
public class EtatDemandeController {

    @Autowired
    private EtatDemandeRepository etatDemandeRepository;

    @GetMapping("/{id}")
    public ResponseEntity<EtatDemande> getEtatDemandeById(@PathVariable Long id) {
        Optional<EtatDemande> etatDemande = etatDemandeRepository.findById(id);
        if (etatDemande.isPresent()) {
            return ResponseEntity.ok(etatDemande.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/")
    public ResponseEntity<EtatDemande> createEtatDemande(@RequestBody EtatDemande etatDemande) {
        etatDemandeRepository.save(etatDemande);
        return ResponseEntity.ok(etatDemande);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EtatDemande> updateEtatDemande(@PathVariable Long id, @RequestBody EtatDemande etatDemande) {
        Optional<EtatDemande> existingEtatDemande = etatDemandeRepository.findById(id);
        if (existingEtatDemande.isPresent()) {
            EtatDemande updatedEtatDemande = existingEtatDemande.get();
            updatedEtatDemande.setEtape(etatDemande.getEtape());
            updatedEtatDemande.setEnAttente(etatDemande.isEnAttente());
            etatDemandeRepository.save(updatedEtatDemande);
            return ResponseEntity.ok(updatedEtatDemande);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEtatDemande(@PathVariable Long id) {
        Optional<EtatDemande> existingEtatDemande = etatDemandeRepository.findById(id);
        if (existingEtatDemande.isPresent()) {
            etatDemandeRepository.delete(existingEtatDemande.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
