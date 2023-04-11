package com.gtiinfo.ecreditproject.services;


import com.gtiinfo.ecreditproject.entities.Garentie;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;
import com.gtiinfo.ecreditproject.Repositories.DemandeRepository;


public interface GarentieService {
    Garentie save(Garentie garentie);
    Optional<Garentie> findById(Long id);
    List<Garentie> findAll();
    void deleteById(Long id);


}
