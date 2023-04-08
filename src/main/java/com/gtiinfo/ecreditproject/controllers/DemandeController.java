package com.gtiinfo.ecreditproject.controllers;

import com.gtiinfo.ecreditproject.entities.Demande;
import com.gtiinfo.ecreditproject.Repositories.DemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/demandes")
public class DemandeController {
    @Autowired
    private DemandeRepository demandeRepository;

    @GetMapping("/")
    @Secured("ADMIN")
    public List<Demande> getAllDemandes() {
        return demandeRepository.findAll();
    }

    @GetMapping("/{id}")
    @Secured("ADMIN")
    public ResponseEntity<Demande> getDemandeById(@PathVariable Long id) {
        Optional<Demande> demande = demandeRepository.findById(id);
        return demande.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/")
    @Secured("ADMIN")
    public ResponseEntity<Demande> createDemande(@RequestBody Demande demande) {
        Demande savedDemande = demandeRepository.save(demande);
        return new ResponseEntity<>(savedDemande, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Secured("ADMIN")
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
    @Secured("ADMIN")
    public ResponseEntity<HttpStatus> deleteDemande(@PathVariable Long id) {
        Optional<Demande> optionalDemande = demandeRepository.findById(id);
        if (optionalDemande.isPresent()) {
            demandeRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    //signle user delete or editing his own

//
//    @PutMapping("/user/{id}")
//    @PreAuthorize("#demande.userId == authentication.principal.username")
//    public ResponseEntity<Demande> updateUserDemande(@PathVariable Long id, @RequestBody Demande demande) {
//        Optional<Demande> optionalDemande = demandeRepository.findById(id);
//        if (optionalDemande.isPresent()) {
//            demande.setId(id);
//            Demande updatedDemande = demandeRepository.save(demande);
//            return new ResponseEntity<>(updatedDemande, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @DeleteMapping("/user/{id}")
//    @PreAuthorize("#demande.userId == authentication.principal.username")
//    public ResponseEntity<HttpStatus> deleteDemande(@PathVariable Long id, @RequestBody Demande demande) {
//        Optional<Demande> optionalDemande = demandeRepository.findById(id);
//        if (optionalDemande.isPresent()) {
//            demandeRepository.deleteById(id);
//            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }

}
