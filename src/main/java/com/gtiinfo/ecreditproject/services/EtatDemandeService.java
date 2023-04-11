package com.gtiinfo.ecreditproject.services;

import com.gtiinfo.ecreditproject.entities.EtatDemande;

import java.util.List;
import java.util.Optional;

public interface EtatDemandeService {
    EtatDemande save(EtatDemande etatDemande);
    Optional<EtatDemande> findById(Long id);
    List<EtatDemande> findAll();
    void deleteById(Long id);

}

