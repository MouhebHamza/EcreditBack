package com.gtiinfo.ecreditproject.controllers;

import com.gtiinfo.ecreditproject.Repositories.UserRepository;
import com.gtiinfo.ecreditproject.entities.User;
import com.gtiinfo.ecreditproject.services.UserService;
import com.gtiinfo.ecreditproject.token.Token;
import com.gtiinfo.ecreditproject.token.TokenRepository;
import jakarta.persistence.EntityNotFoundException;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
@RestController
@RequestMapping("/api/v1/auth/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("")
    @Secured("ADMIN")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("")
    @Secured("ADMIN")
    public User createUser(@RequestBody User user) {
        return userRepository.save(user);
    }

    @PutMapping("/{id}")
    @Secured("ADMIN")
    public User updateUser(@PathVariable("id") Integer id, @RequestBody User updateUser) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        if (updateUser.getEmail() != null) {
            user.setEmail(updateUser.getEmail());
        }
        if (updateUser.getPassword() != null) {
            user.setPassword(updateUser.getPassword());
        }
        if (updateUser.getRole() != null) {
            user.setRole(updateUser.getRole());
        }
        if (updateUser.getFirstname() != null) {
            user.setFirstname(updateUser.getFirstname());
        }
        if (updateUser.getLastname() != null) {
            user.setLastname(updateUser.getLastname());
        }

        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    @Secured("ADMIN")
    public void deleteUser(@PathVariable("id") Integer id) {
        userRepository.deleteById(id);
    }


}
