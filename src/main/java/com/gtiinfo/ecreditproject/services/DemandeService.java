package com.gtiinfo.ecreditproject.services;

import com.gtiinfo.ecreditproject.entities.Demande;

import java.util.List;
import java.util.Optional;

public interface DemandeService {
    Demande save(Demande demande);
    Optional<Demande> findById(Long id);
    List<Demande> findAll();
    void deleteById(Long id);
}
