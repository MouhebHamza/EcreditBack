package com.gtiinfo.ecreditproject.services;

import com.gtiinfo.ecreditproject.entities.Demande;
import com.gtiinfo.ecreditproject.entities.EtatDemande;
import com.gtiinfo.ecreditproject.entities.User;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import com.gtiinfo.ecreditproject.Repositories.DemandeRepository;


public interface DemandeService {
    Demande save(Demande demande);
        Optional<Demande> findById(Long id);
    List<Demande> findAll();
    void deleteById(Long id);


}
