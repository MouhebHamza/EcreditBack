package com.gtiinfo.ecreditproject.Repositories;


import com.gtiinfo.ecreditproject.entities.Simulation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SimulationRepository extends JpaRepository<Simulation, Long> {
}
