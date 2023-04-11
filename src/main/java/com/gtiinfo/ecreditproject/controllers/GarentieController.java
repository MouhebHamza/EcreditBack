package com.gtiinfo.ecreditproject.controllers;

import com.gtiinfo.ecreditproject.entities.Garentie;
import com.gtiinfo.ecreditproject.Repositories.GarentieRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/garenties")
@RequiredArgsConstructor
public class GarentieController {
    private final GarentieRepository garentieRepository;

    @GetMapping("/")
    public List<Garentie> getAllDemandes() {
        return garentieRepository.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Garentie> getGarentieById(@PathVariable Long id) {
        Garentie garentie = garentieRepository.findById(id).orElse(null);
        if (garentie == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(garentie);
    }

    @PostMapping("/")
    public Garentie createGarentie(@RequestBody  Garentie garentie) {
        return garentieRepository.save(garentie);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Garentie> updateGarentie(@PathVariable Long id, @RequestBody  Garentie updatedGarentie) {
        Garentie existingGarentie = garentieRepository.findById(id).orElse(null);
        if (existingGarentie == null) {
            return ResponseEntity.notFound().build();
        }
        updatedGarentie.setId(id);
        Garentie savedGarentie = garentieRepository.save(updatedGarentie);
        return ResponseEntity.ok(savedGarentie);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGarentie(@PathVariable Long id) {
        Garentie existingGarentie = garentieRepository.findById(id).orElse(null);
        if (existingGarentie == null) {
            return ResponseEntity.notFound().build();
        }
        garentieRepository.delete(existingGarentie);
        return ResponseEntity.noContent().build();
    }
}
