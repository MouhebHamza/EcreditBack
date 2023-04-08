package com.gtiinfo.ecreditproject.Repositories;
import com.gtiinfo.ecreditproject.entities.Garentie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GarentieRepository extends JpaRepository<Garentie, Long> {
}