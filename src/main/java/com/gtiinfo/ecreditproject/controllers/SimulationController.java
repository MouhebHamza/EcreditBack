package com.gtiinfo.ecreditproject.controllers;


import com.gtiinfo.ecreditproject.entities.Simulation;
import com.gtiinfo.ecreditproject.Repositories.SimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SimulationController {

    @Autowired
    private SimulationRepository simulationRepository;

    @PostMapping("/simulations")
    public Simulation createSimulation(@RequestBody Simulation simulation) {
        return simulationRepository.save(simulation);
    }

    @GetMapping("/simulations/{id}")
    public Simulation getSimulationById(@PathVariable Long id) {
        return simulationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found with id: " + id));
    }
    @PutMapping("/simulations/{id}")
    public Simulation updateSimulation(@PathVariable Long id, @RequestBody Simulation simulationDetails) {
        Simulation simulation = simulationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found with id: " + id));

        simulation.setNom(simulationDetails.getNom());
        simulation.setPrenom(simulationDetails.getPrenom());
        simulation.setTypePieceIdentite(simulationDetails.getTypePieceIdentite());
        simulation.setNumPieceIdentité(simulationDetails.getNumPieceIdentité());
        simulation.setNumCompte(simulationDetails.getNumCompte());
        simulation.setDateCompte(simulationDetails.getDateCompte());
        simulation.setDateNaissance(simulationDetails.getDateNaissance());
        simulation.setSitFamiliale(simulationDetails.getSitFamiliale());
        simulation.setSitMedicale(simulationDetails.getSitMedicale());
        simulation.setSitProfessionnel(simulationDetails.getSitProfessionnel());
        simulation.setGSM(simulationDetails.getGSM());
        simulation.setTypeCredit(simulationDetails.getTypeCredit());
        simulation.setMontant(simulationDetails.getMontant());
        simulation.setNbreEcheance(simulationDetails.getNbreEcheance());
        simulation.setPayementPar(simulationDetails.getPayementPar());
        simulation.setSalaireAnnuel(simulationDetails.getSalaireAnnuel());
        simulation.setAutreRevenu(simulationDetails.getAutreRevenu());
        simulation.setSitLogement(simulationDetails.getSitLogement());
        simulation.setResultat(simulationDetails.getResultat());

        Simulation updatedSimulation = simulationRepository.save(simulation);
        return updatedSimulation;
    }

    @DeleteMapping("/simulations/{id}")
    public String deleteSimulation(@PathVariable Long id) {
        simulationRepository.deleteById(id);
        return "Simulation deleted successfully with id: " + id;
    }
}