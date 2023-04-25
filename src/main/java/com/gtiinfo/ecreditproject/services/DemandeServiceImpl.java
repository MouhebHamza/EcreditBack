package com.gtiinfo.ecreditproject.services;

import com.gtiinfo.ecreditproject.Repositories.DemandeRepository;
import com.gtiinfo.ecreditproject.entities.Demande;
import com.gtiinfo.ecreditproject.entities.EtatDemande;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemandeServiceImpl implements DemandeService {

    private final DemandeRepository repository;

    public DemandeServiceImpl(DemandeRepository repository) {
        this.repository = repository;
    }

    @Override
    public Demande save(Demande demande) {
        return repository.save(demande);
    }

    @Override
    public Optional<Demande> findById(Long id) {
        return repository.findById(id);
    }




    @Override
    public List<Demande> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}