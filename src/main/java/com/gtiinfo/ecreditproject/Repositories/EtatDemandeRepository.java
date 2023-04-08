package com.gtiinfo.ecreditproject.Repositories;
import com.gtiinfo.ecreditproject.entities.EtatDemande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EtatDemandeRepository extends JpaRepository<EtatDemande, Long> {
}