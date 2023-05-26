package com.gtiinfo.ecreditproject.Repositories;

import com.gtiinfo.ecreditproject.entities.Demande;
import com.gtiinfo.ecreditproject.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DemandeRepository extends JpaRepository<Demande, Long> {
    List<Demande> findDemandeByUserOrderById(User user);

    List<Demande> findAllByOrderByIdDesc();
}