package com.gtiinfo.ecreditproject.controllers;

import com.gtiinfo.ecreditproject.auth.AuthenticationService;
import com.gtiinfo.ecreditproject.entities.Demande;
import com.gtiinfo.ecreditproject.Repositories.DemandeRepository;
import com.gtiinfo.ecreditproject.Repositories.UserRepository;
import com.gtiinfo.ecreditproject.dto.UserDTO;

import com.gtiinfo.ecreditproject.entities.User;
import com.gtiinfo.ecreditproject.services.DemandesService;
import com.gtiinfo.ecreditproject.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/demandes")
public class DemandeController {
    @Autowired
    private DemandeRepository demandeRepository;

    @GetMapping("/")
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
        Optional<Demande> demande = demandeRepository.findById(id);
        return demande.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    public ResponseEntity<Demande> createDemande(@RequestBody Demande demande) {
        Demande savedDemande = demandeRepository.save(demande);
        return new ResponseEntity<>(savedDemande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Demande> updateDemande(@PathVariable Long id, @RequestBody Demande demande) {
        Optional<Demande> optionalDemande = demandeRepository.findById(id);
        if (optionalDemande.isPresent()) {
            demande.setId(id);
            Demande updatedDemande = demandeRepository.save(demande);
            return new ResponseEntity<>(updatedDemande, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteDemande(@PathVariable Long id) {
        Optional<Demande> optionalDemande = demandeRepository.findById(id);
        if (optionalDemande.isPresent()) {
            demandeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }
}
