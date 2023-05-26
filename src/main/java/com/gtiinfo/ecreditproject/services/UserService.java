package com.gtiinfo.ecreditproject.services;

import com.gtiinfo.ecreditproject.Repositories.UserRepository;
import com.gtiinfo.ecreditproject.dto.UserDTO;
import com.gtiinfo.ecreditproject.entities.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    ModelMapper modelMapper;

    public void saveUser(UserDTO userDto) {
        Optional<User> optionalUser = userRepository.findByEmail(userDto.getEmail());
        if (!optionalUser.isPresent()) {
            // insert new user
            User user = modelMapper.map(userDto, User.class);
            userRepository.save(user);
        }
    }

    public User getUser(String email) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        return null;
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long userId) {
        return userRepository.findUserById(userId);
    }
}
