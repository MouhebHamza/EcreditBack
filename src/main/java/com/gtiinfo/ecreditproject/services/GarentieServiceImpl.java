package com.gtiinfo.ecreditproject.services;


import com.gtiinfo.ecreditproject.Repositories.GarentieRepository;
import com.gtiinfo.ecreditproject.entities.Garentie;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GarentieServiceImpl implements GarentieService {

    private final GarentieRepository repository;

    public GarentieServiceImpl(GarentieRepository repository) {
        this.repository = repository;
    }

    @Override
    public Garentie save(Garentie garentie) {
        return repository.save(garentie);
    }

    @Override
    public Optional<Garentie> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Garentie> findAll() {
        return repository.findAll();
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
