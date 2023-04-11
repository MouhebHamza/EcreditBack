package com.gtiinfo.ecreditproject.services;

import com.gtiinfo.ecreditproject.entities.EtatDemande;
import com.gtiinfo.ecreditproject.Repositories.EtatDemandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EtatDemandeServiceImpl implements EtatDemandeService {

    private final EtatDemandeRepository etatDemandeRepository;

    @Autowired
    public EtatDemandeServiceImpl(EtatDemandeRepository etatDemandeRepository) {
        this.etatDemandeRepository = etatDemandeRepository;
    }

    @Override
    public EtatDemande save(EtatDemande etatDemande) {
        return etatDemandeRepository.save(etatDemande);
    }

    @Override
    public Optional<EtatDemande> findById(Long id) {
        return etatDemandeRepository.findById(id);
    }

    @Override
    public List<EtatDemande> findAll() {
        return etatDemandeRepository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        etatDemandeRepository.deleteById(id);
    }
}
