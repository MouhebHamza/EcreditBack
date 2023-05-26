package com.gtiinfo.ecreditproject.controllers;


import com.gtiinfo.ecreditproject.entities.Demande;
import com.gtiinfo.ecreditproject.entities.EtatDemande;
import com.gtiinfo.ecreditproject.Repositories.EtatDemandeRepository;
import com.gtiinfo.ecreditproject.services.DemandeService;
import com.gtiinfo.ecreditproject.services.EtatDemandeService;
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
    @Autowired
    private DemandeService demandeService;

    @Autowired
    private EtatDemandeService etatDemandeService;

    @GetMapping("/")
    public ResponseEntity<Iterable<EtatDemande>> getAllEtatDemande() {
        Iterable<EtatDemande> etatsDemande = etatDemandeService.findAll();
        return new ResponseEntity<>(etatsDemande, HttpStatus.OK);
    }

    // Get EtatDemande by ID
    @GetMapping("/{id}")
    public ResponseEntity<EtatDemande> getEtatDemandeById(@PathVariable Long id) {
        Optional<EtatDemande> etatDemande = etatDemandeService.findById(id);
        if (etatDemande.isPresent()) {
            return new ResponseEntity<>(etatDemande.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/")
    public ResponseEntity<EtatDemande> createEtatDemande(@RequestBody EtatDemande etatDemande) {
        // Get the Demande associated with the EtatDemande
        Demande demande = etatDemande.getDemande();
            // Set the Demande object in the EtatDemande object
            etatDemande.setDemande(demande);
            // Save the EtatDemande object in the database
            etatDemandeService.save(etatDemande);
            return new ResponseEntity<>(etatDemande, HttpStatus.CREATED);

    }
}
