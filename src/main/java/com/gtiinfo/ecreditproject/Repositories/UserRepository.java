package com.gtiinfo.ecreditproject.Repositories;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import com.gtiinfo.ecreditproject.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);

}