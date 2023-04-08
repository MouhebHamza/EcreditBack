package com.gtiinfo.ecreditproject.controllers;


import com.gtiinfo.ecreditproject.entities.PieceJointe;
import com.gtiinfo.ecreditproject.Repositories.PieceJointeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

    import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/pieces-jointes")
public class PieceJointeController {

    @Autowired
    private PieceJointeRepository pieceJointeRepository;

    @GetMapping
    public ResponseEntity<List<PieceJointe>> getAllPieceJointes() {
        List<PieceJointe> pieceJointes = pieceJointeRepository.findAll();
        return ResponseEntity.ok(pieceJointes);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PieceJointe> getPieceJointeById(@PathVariable Long id) {
        Optional<PieceJointe> pieceJointe = pieceJointeRepository.findById(id);
        return pieceJointe.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PieceJointe> createPieceJointe( @RequestBody PieceJointe pieceJointe) {
        PieceJointe savedPieceJointe = pieceJointeRepository.save(pieceJointe);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedPieceJointe);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PieceJointe> updatePieceJointe(@PathVariable Long id, @RequestBody PieceJointe pieceJointe) {
        if (!pieceJointeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pieceJointe.setId(id);
        PieceJointe updatedPieceJointe = pieceJointeRepository.save(pieceJointe);
        return ResponseEntity.ok(updatedPieceJointe);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePieceJointe(@PathVariable Long id) {
        if (!pieceJointeRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        pieceJointeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }



//    @PostMapping("/upload")
//    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
//        // Check if file is empty
//        if (file.isEmpty()) {
//            // Handle empty file
//        }
//
//        try {
//            // Save file to disk or database
//        } catch (IOException e) {
//            // Handle file processing errors
//        }
//
//        // Return success response
//        return "redirect:/success";
//    }

}