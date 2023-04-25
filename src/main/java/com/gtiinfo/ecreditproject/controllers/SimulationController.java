package com.gtiinfo.ecreditproject.controllers;


import com.gtiinfo.ecreditproject.entities.Demande;
import com.gtiinfo.ecreditproject.entities.Simulation;
import com.gtiinfo.ecreditproject.Repositories.SimulationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/simulations")
public class SimulationController {

    @Autowired
    private SimulationRepository simulationRepository;

    @GetMapping("/")
    public List<Simulation> getAllSimulations() {
        return simulationRepository.findAll();
    }


    @PostMapping("/")
    public Simulation createSimulation(@RequestBody Simulation simulation) {
        return simulationRepository.save(simulation);
    }

    @GetMapping("/{id}")
    public Simulation getSimulationById(@PathVariable Long id) {
        return simulationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found with id: " + id));
    }
    @PutMapping("/{id}")
    public Simulation updateSimulation(@PathVariable Long id, @RequestBody Simulation simulationDetails) {
        Simulation simulation = simulationRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Simulation not found with id: " + id));



        Simulation updatedSimulation = simulationRepository.save(simulation);
        return updatedSimulation;
    }

    @DeleteMapping("/{id}")
    public String deleteSimulation(@PathVariable Long id) {
        simulationRepository.deleteById(id);
        return "Simulation deleted successfully with id: " + id;
    }
}